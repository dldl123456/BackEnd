package eg.fn.UserManager;

public class UserManager {
    User[] users;
    private int nums=0;
    
    
    public UserManager(int size) {
        users = new User[size];
    }

    public void add(User user) {
        //�ж������ڴ��Ƿ���ʣ��
        if(nums>=users.length) {
            System.out.println("�Բ����û������ڴ��������޷������"+user.getUsername()+"��Ϣ��");
            return;
        }
        
        //�ж��Ƿ���ڸ��û�����
        User u = this.load(user.getUsername());
        if(u!=null) {
            System.out.println("�Բ��𣬸��û�:"+u.getUsername()+"�����Ѵ��ڣ�");
            return;
        }
        
        //�������
        users[nums] = user;
        nums++;
        System.out.println("�û�:"+user.getUsername()+"��������ӳɹ���");
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
        //ͨ��index�����ҵ���Ҫɾ���������±�ֵ
        for(int i=0;i<nums;i++) {
            User u = users[i];
            if(username.equals(u.getUsername())) {
                index=i;
                break;
            }
        }
        
        if(index==-1) {
            System.out.println("�Բ���Ҫɾ�����û���"+username+"�����ڣ�");
            return;
        }
        
        //��indexλ�ÿ�ʼ����һ������Ԫ�ظ�ֵ��ǰһ������Ԫ���У�����ٽ�users[nums]=null��nums�Լ�
        for(int i=index+1;i<nums;i++) {
            users[i-1] = users[i];
        }
        users[nums-1]=null;
        nums--;
        System.out.println("�û���"+username+"����ɾ���ɹ���");
        return;
        
    }
    
    public void add(int pos,User user) {
        //���ȼ��pos�Ƿ�Ϸ�
        if(pos<0||pos>=nums) {
            System.out.println("�Բ����û�"+user.getUsername()+"��Ϣ���λ�ò���ȷ��");
            return;
        }
        
        //�ж�pos�Ƿ���Բ��룬��nums�������Ѿ������˾Ͳ�����������������
        if(nums>=users.length) {
            System.out.println("�Բ����ڴ��������޷������"+user.getUsername()+"��Ϣ��");
            return;
        }
        
        //����Ƿ��Ѵ���user����
        User u = this.load(user.getUsername());
        if(u!=null) {
            System.out.println("�Բ��𣬸��û�:"+u.getUsername()+"�����Ѵ��ڣ�");
            return;
        }
        
        for(int i=nums;i>pos;i--) {
            //ǰ����nums>=users.length�жϣ����users[nums]�ռ���ڣ����Ա�ǰ���Ԫ�ظ�ֵ
            users[i] = users[i-1];
        }
        
        users[pos] = user;
        nums++;
        System.out.println("�û�:"+user.getUsername()+"��������ӳɹ���");
        return;
    }
    
    public void update(User user) {
        //����Ƿ���ڸ��û�����
        User u = this.load(user.getUsername());
        if(u==null) {
            System.out.println("�Բ��𣬸��û���"+user.getUsername()+"���ݲ����ڣ�");
            return;
        }
        
        //��������
        u.setNickname(user.getNickname());
        u.setPassword(user.getPassword());
        u.setAge(user.getAge());
        System.out.println("�û�:"+user.getUsername()+"�����Ѹ��³ɹ���");
        return;
    }
    
    public void login(String username,String password) {
        //�ж��Ƿ���� username �û���
        User u = this.load(username);
        
        if(u==null) {
            System.out.println("�û�����"+username+"����ȷ���������룡");
            return;
        }
        
        //�ж������Ƿ���ȷ
        if(!password.equals(u.getPassword())) {
            System.out.println("���벻��ȷ���������룡");
            return;
        }                
        //�ɹ���¼ϵͳ
        System.out.println("��ӭ"+username+"��¼ϵͳ��");
        return;
    }
    
    public User[] list() {
        User[] tus = new User[nums];    //ֻ��������Ԫ���д�����ЧԪ��ֵ������
        for(int i=0;i<nums;i++) {
            tus[i] = users[i];
        }
        return tus;
    }
}