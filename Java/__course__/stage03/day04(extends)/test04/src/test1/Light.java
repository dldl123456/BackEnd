package test1;

//���ࣨ��ƣ�
public class Light extends Electrical {
	//���๹�캯����ȡ���๹�캯���ķ���
	public Light(String name) {
		super(name);  //super�Ǹ������
	}

	//��д����򿪵����������򿪵�ƣ�
	public void turnOn(){
		System.out.println(this.getName() + "�򿪵��");
	}
	
	//��д����رյ����������رյ�ƣ�
	public void turnOff(){
		System.out.println(this.getName() + "�رյ��");
	}
	
	//����˽�еķ�������ƹ��ϣ�
	public void trouble(){
		System.out.println("Dr." + this.getName() + ", the light is brokened��please connect manager soon.");
	}
}
