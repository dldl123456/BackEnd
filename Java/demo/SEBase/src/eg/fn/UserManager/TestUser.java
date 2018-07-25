package eg.fn.UserManager;

public class TestUser {

    public static void main(String[] args) {
        UserManager um = new UserManager(5);
        um.add(new User("zs","123","����",24));    //�����Ϣ�ɹ�
        um.add(new User("ls","123","����",22));    //�����Ϣ�ɹ�
        um.add(new User("ls","123","����",23));    //��Ӳ��ɹ����Ѵ���
        um.add(new User("ww","123","����",21));    //�����Ϣ�ɹ�
        um.add(new User("zl","123","����",21));    //�����Ϣ�ɹ�
        um.add(new User("zq","123","����",22));    //�����Ϣ�ɹ�
        
        um.add(new User("S","123","��S",22));    //��Ա�ˣ������Ϣ���ɹ�
        
        System.out.println("------�ָ���------");
        
        um.delete("ls");    //ɾ��ls
        um.delete("ls1231");    //��ʾҪɾ�����û���������
        
        System.out.println("------�ָ���------");
        
        um.update(new User("S","1234","��S",23));    //��ʾҪ���µ��û���������
        um.update(new User("zq","1234","����",23));    //��ʾzq��Ϣ���³ɹ�
        
        System.out.println("------�ָ���------");
        
        um.login("zs1", "1234");    //��ʾ�û�������
        um.login("zs1", "123412");    //��ʾ�û�������
        um.login("zs", "123412");    //��ʾ�������
        um.login("zs", "123");        //��ʾ�ɹ���½ϵͳ
        
        um.login("ls", "123");    //�û��������ڣ���ʾ����
        
        System.out.println("------�ָ���------");
        
        User[] u = um.list();
        for(int i=0;i<u.length;i++) {
            System.out.println(u[i]);
        }
        
        System.out.println("------�ָ���------");
        
        um.add(1,new User("S","123","��S",22));
        um.delete("ww");
        um.add(1,new User("Y","123","��Y",22));
        um.delete("Y");
        um.add(3,new User("s","123","СS",22));
        
        System.out.println("------�ָ���------");
        
        User[] u2 = um.list();
        for(int i=0;i<u2.length;i++) {
            System.out.println(u2[i]);
        }
    }

}