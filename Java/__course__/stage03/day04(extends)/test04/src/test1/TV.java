package test1;

//���ࣨ���ӣ�
public class TV extends Electrical {
	//���๹�캯����ȡ���๹�캯���ķ���
	public TV(String name){
		super(name);  //super()�Ǹ������
	}

	//��д����Ĵ򿪵�������(����)
	public void turnOn(){
		System.out.println(this.getName() + "�򿪵���");
	}
	
	//��д����Ĺرյ�������(����)
	public void turnOff(){
		System.out.println(this.getName() + "�رյ���");
	}
	
	//����˽�з��������ӻ����ϣ�
	public void trouble(){
		System.out.println("Dr." + this.getName() + ", the TV is brokened��please connect manager soon.");
	}
}
