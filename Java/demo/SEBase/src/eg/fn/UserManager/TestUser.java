package eg.fn.UserManager;

public class TestUser {

    public static void main(String[] args) {
        UserManager um = new UserManager(5);
        um.add(new User("zs","123","张三",24));    //添加信息成功
        um.add(new User("ls","123","李四",22));    //添加信息成功
        um.add(new User("ls","123","李四",23));    //添加不成功，已存在
        um.add(new User("ww","123","王五",21));    //添加信息成功
        um.add(new User("zl","123","赵六",21));    //添加信息成功
        um.add(new User("zq","123","朱七",22));    //添加信息成功
        
        um.add(new User("S","123","大S",22));    //满员了，添加信息不成功
        
        System.out.println("------分割线------");
        
        um.delete("ls");    //删除ls
        um.delete("ls1231");    //提示要删除的用户名不存在
        
        System.out.println("------分割线------");
        
        um.update(new User("S","1234","大S",23));    //提示要更新的用户名不存在
        um.update(new User("zq","1234","朱七",23));    //提示zq信息更新成功
        
        System.out.println("------分割线------");
        
        um.login("zs1", "1234");    //提示用户名错误
        um.login("zs1", "123412");    //提示用户名错误
        um.login("zs", "123412");    //提示密码错误
        um.login("zs", "123");        //提示成功登陆系统
        
        um.login("ls", "123");    //用户名不存在，提示错误
        
        System.out.println("------分割线------");
        
        User[] u = um.list();
        for(int i=0;i<u.length;i++) {
            System.out.println(u[i]);
        }
        
        System.out.println("------分割线------");
        
        um.add(1,new User("S","123","大S",22));
        um.delete("ww");
        um.add(1,new User("Y","123","大Y",22));
        um.delete("Y");
        um.add(3,new User("s","123","小S",22));
        
        System.out.println("------分割线------");
        
        User[] u2 = um.list();
        for(int i=0;i<u2.length;i++) {
            System.out.println(u2[i]);
        }
    }

}