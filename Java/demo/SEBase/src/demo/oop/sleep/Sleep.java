package demo.oop.sleep;

import java.util.Scanner;

public class Sleep {
	public static void main(String[] args) {	
		int n = (int)(Math.random()*3+1);
		
		switch(n){
			case 1:
				SleepProcess slp1 = new SleepWay1();
				slp1.beginSleep();
				slp1.sleeping();
				slp1.doomsday();
			case 2:
				SleepProcess slp2 = new SleepWay2();
				slp2.beginSleep();
				slp2.sleeping();
				slp2.doomsday();
			case 3:
				SleepProcess slp3 = new SleepWay3();
				slp3.beginSleep();
				slp3.sleeping();
				slp3.doomsday();
		}
	}
}

abstract class SleepProcess{
	public int n = 0;  //���С��
	public int i;  //����һ��Сѭ��
	public int myRadom;  //���
	
	@SuppressWarnings("resource")
	public void beginSleep(){
		System.out.println("�����ǣ���Ҫ˯���ˣ��ҵı���������");
		System.out.println("==*  һ�����Ѻ���ͷ�Ĺ���   *== \n");
		System.out.print("�š�������ֻ����أ�  ");
		
		//���׼�ֻ����
		myRadom = (int)(Math.random()*5+1);
		
		//��Ҫ��ʲô
		Scanner in = new Scanner(System.in);
		n = in.nextInt() + myRadom;
		
		for(i=0; i<n; i++){
			if(i<n-1){
				System.out.print((i+1) + "ֻ��" + ",");
			}else{
				System.out.print((i+1) + "ֻ�򡭡�����\n");
			}
		}
		System.out.println("\n��ģ���ۣ�����̫�ԣ��������ɡ�����");
		System.out.println("�����࣬������Zzzz");
		System.out.println("Zzzz");
		System.out.println("Zz..");
		System.out.println("......\n");
	}
	
	//����˯������
	public abstract void sleeping();
	
	@SuppressWarnings("resource")
	public void doomsday(){
		String answer = "";  //y/n
		
		System.out.println("\n^*)%$@~");
		System.out.println("ʲô��Ҫ�𴲣�\n");
		System.out.println("#$!/*+#%&");
		System.out.println("���ᣬ�Բۣ�ʲô������ĩ����\n");
		System.out.println("��������������������");
		System.out.println("���Ǳ�������˯������������\n");
		System.out.print("//*-&(���룺��������) y/n��  ");
		
		Scanner in = new Scanner(System.in);
		answer = in.nextLine();
		
		if(answer.equals("n")){
			System.out.println("\n(������)��Ҫ˯���쳤�ؾã���Ҫ˯������ʯ�ã�");
			System.out.println("�����࣬������Zzz..");
			System.out.println("...............\n");
			System.out.println("�أ���!!!");
			System.out.println("end~   ^_^");
		}else{
			System.out.println("\n(������)��������������������ĩ����������");
			System.out.println("...............\n");
			System.out.println("�أ���!!!");
			System.out.println("end~   ^_^");
		}
		
		System.out.println("------------------------------------\n");
		
		return;
	}
	
	//˯��˯��
	public void sleep(){
		//��ʼ˯����
		beginSleep();
		//������ô˯����ô˯
		sleeping();
		//����������
		doomsday();
	}
}

//����˯
class SleepWay1 extends SleepProcess{
	public void sleeping(){
		System.out.println("��Ҫ����˯");
		System.out.println("�����鵽�����");
		System.out.println("��������");
	}
}

//����˯
class SleepWay2 extends SleepProcess{
	public void sleeping(){
		System.out.println("��Ҫ����˯");
		System.out.println("���˼��ing����");
		System.out.println("�������У������������Ѿ�������");
	}
}

//������ô˯����ô˯
class SleepWay3 extends SleepProcess{
	public void sleeping(){
		System.out.println("������ô˯����ô˯");
		System.out.println("�չ�����ing");
		System.out.println("�źߡ�����ˬ");
	}
}