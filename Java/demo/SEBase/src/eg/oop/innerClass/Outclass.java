package eg.oop.innerClass;

public class Outclass {//�ⲿ��
    private String name="name";
    private int num1=1;
    public void show1(){
        System.out.println("�ⲿ����");
    }
     public class intclass{//�ڲ���
        private int num1=2;
        public void show(){
            System.out.println("�ڲ�����");
            System.out.println(num1);
            System.out.println(name);//�����ⲿ��Ĳ�ͬ����Ա
            System.out.println(Outclass.this.num1);//�����ⲿ���ͬ����Ա
            show1();//�����ⲿ��ķ���
        }
    }
    @SuppressWarnings("unused")
	public static void main(String[] args) {
        Outclass o=new Outclass();
        /*
         * �����ڲ����ʵ��:
         * �ⲿ��.�ڲ��� ������ = new �ⲿ��().new �ڲ���();
         */
        Outclass.intclass i=new Outclass().new intclass();
        
//        i.show1();  ���ܵ����ⲿ��ĳ�Ա�ͷ���
        i.show();
    }
}
