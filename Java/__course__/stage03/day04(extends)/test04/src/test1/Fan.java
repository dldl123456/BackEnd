package test1;

//����(����)
public class Fan extends Electrical {
	//���๹�캯����ȡ���๹�캯���ķ���
	public Fan(String name){
		super(name);  //super��ʾ�������
	}
	
	//��д���࿪���������������ȣ�
	public void turnOn(){
		System.out.println(this.getName() + "�򿪵���");
	}
	
	//��д����رյ����ķ��������ȣ�
	public void turnOff(){
		System.out.println(this.getName() + "�رյ���");
	}
}
