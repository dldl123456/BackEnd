package demo.oop.sleep;

public class Sleep2 {
	//��һ��������˯���Ķ���
	void sleepSth(SplleWay slp){
		slp.speepWay();
    }
	
	//��������������ڣ�
	public static void main(String[] args) {
		SplleWay01 slpy1 = new SplleWay01();  //ʵ������һ��˯�������࣬����slpy1����
		SplleWay02 slpy2 = new SplleWay02();  //ʵ�����ڶ���˯�������࣬����slpy2����
		SplleWay03 slpy3 = new SplleWay03();  //ʵ����������˯�������࣬����slpy3����
		
        Sleep2 slp2 = new Sleep2();  //ʵ����˯���࣬����slp2����
        
        //���û�����˯���ķ���
        slp2.sleepSth(slpy1);
        slp2.sleepSth(slpy2);
        slp2.sleepSth(slpy3);
	}
}

//һ������˯���Ľӿڽӿ�
interface SplleWay {
	//�������󷽷�
	public void speepWay();
}

//��һ��˯����������ýӿ�
class SplleWay01 implements SplleWay {
	//�Խӿ��еĳ��󷽷����о���ʵ��
  public void speepWay() {
      System.out.println("��Ҫ����˯");
  }
}

//�ڶ���˯����������ýӿ�
class SplleWay02 implements SplleWay {
	//�Խӿ��еĳ��󷽷����о���ʵ��
	public void speepWay() {
		System.out.println("��Ҫ����˯");
  }
}

//�ڶ���˯����������ýӿ�
class SplleWay03 implements SplleWay {
	//�Խӿ��еĳ��󷽷����о���ʵ��
	public void speepWay() {
		System.out.println("������ô˯����ô˯");
	}
}