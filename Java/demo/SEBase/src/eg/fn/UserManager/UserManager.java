package eg.fn.UserManager;

public class UserManager {
    User[] users;
    private int nums=0;
    
    
    public UserManager(int size) {
        users = new User[size];
    }

    public void add(User user) {
        //判断数组内存是否有剩余
        if(nums>=users.length) {
            System.out.println("对不起，用户数据内存已满，无法再添加"+user.getUsername()+"信息！");
            return;
        }
        
        //判断是否存在该用户数据
        User u = this.load(user.getUsername());
        if(u!=null) {
            System.out.println("对不起，该用户:"+u.getUsername()+"数据已存在！");
            return;
        }
        
        //添加数据
        users[nums] = user;
        nums++;
        System.out.println("用户:"+user.getUsername()+"数据已添加成功！");
        return;
        
    }
    
    public User load(String username) {
        for(int i=0;i<nums;i++) {
            User u = users[i];
            if(username.equals(u.getUsername())) {
                return u;
            }
        }
        return null;
    }
    
    public void delete(String username) {
        int index=-1;
        //通过index索引找到需要删除的数组下标值
        for(int i=0;i<nums;i++) {
            User u = users[i];
            if(username.equals(u.getUsername())) {
                index=i;
                break;
            }
        }
        
        if(index==-1) {
            System.out.println("对不起，要删除的用户："+username+"不存在！");
            return;
        }
        
        //从index位置开始，后一个数组元素赋值到前一个数组元素中，最后再将users[nums]=null，nums自减
        for(int i=index+1;i<nums;i++) {
            users[i-1] = users[i];
        }
        users[nums-1]=null;
        nums--;
        System.out.println("用户："+username+"数据删除成功！");
        return;
        
    }
    
    public void add(int pos,User user) {
        //首先检查pos是否合法
        if(pos<0||pos>=nums) {
            System.out.println("对不起，用户"+user.getUsername()+"信息添加位置不正确！");
            return;
        }
        
        //判断pos是否可以插入，即nums个数据已经存满了就不可以再增加新数据
        if(nums>=users.length) {
            System.out.println("对不起，内存已满，无法再添加"+user.getUsername()+"信息！");
            return;
        }
        
        //检查是否已存在user对象
        User u = this.load(user.getUsername());
        if(u!=null) {
            System.out.println("对不起，该用户:"+u.getUsername()+"数据已存在！");
            return;
        }
        
        for(int i=nums;i>pos;i--) {
            //前面有nums>=users.length判断，因此users[nums]空间存在，可以被前面的元素赋值
            users[i] = users[i-1];
        }
        
        users[pos] = user;
        nums++;
        System.out.println("用户:"+user.getUsername()+"数据已添加成功！");
        return;
    }
    
    public void update(User user) {
        //检查是否存在该用户数据
        User u = this.load(user.getUsername());
        if(u==null) {
            System.out.println("对不起，该用户："+user.getUsername()+"数据不存在！");
            return;
        }
        
        //更新数据
        u.setNickname(user.getNickname());
        u.setPassword(user.getPassword());
        u.setAge(user.getAge());
        System.out.println("用户:"+user.getUsername()+"数据已更新成功！");
        return;
    }
    
    public void login(String username,String password) {
        //判断是否存在 username 用户名
        User u = this.load(username);
        
        if(u==null) {
            System.out.println("用户名："+username+"不正确，请检查输入！");
            return;
        }
        
        //判断密码是否正确
        if(!password.equals(u.getPassword())) {
            System.out.println("密码不正确，请检查输入！");
            return;
        }                
        //成功登录系统
        System.out.println("欢迎"+username+"登录系统！");
        return;
    }
    
    public User[] list() {
        User[] tus = new User[nums];    //只遍历数组元素中存有有效元素值的数组
        for(int i=0;i<nums;i++) {
            tus[i] = users[i];
        }
        return tus;
    }
}