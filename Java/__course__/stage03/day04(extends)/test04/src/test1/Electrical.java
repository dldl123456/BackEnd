/*
 *   �������Կ��ؼ�����κε����������ơ����ӡ����ȵȡ�ʹ�ü̳кͶ�̬��ʵ�ֿ��ص����ķ�����
 */

package test1;

//���࣬����
public class Electrical {
	//����˽�б���
	private String name;  //ʹ���ߵ�����
	
	//ʹ��get/set����Ϊ˽�б����ṩ�ӿ�
	//name
	public String getName() {  //����name����
		return name;
	}
	public void setName(String name) {  //��ȡname����
		this.name = name;
	}

	//���캯����ʼ������
	public Electrical(String name){
		this.name = name;
	}
	
	//���������������
	public void turnOn(){
		System.out.println("the methods of turn on");
	}
	
	//��������رշ���
	public void turnOff(){
		System.out.println("the methods of turn off");
	}
	
	//������
	public static void main(String[] args) {
		//����������ഴ�����󣨵�ƣ�
		//����ת��,�ᵼ�����෽���Ķ�ʧ
		Electrical ectl1 = new Light("����");  //��������ñ�����������������ĵĶ���(������������Light��Ķ���ʵ����ectl1����)
		ectl1.turnOn();  //���ࣨLight���Ķ��������д�Ŀ�����������
		ectl1.turnOff();  //���ࣨLight���Ķ��������д�Ŀ�����������
		
		//�������˽�з���(����ת��)
		//�жϵ����������ǲ��ǵ���������ʵ��
		if(ectl1 instanceof Light){
			Light lgt = (Light)ectl1;  //�Ѹ����ͣ�������ǿ������ת���������ͣ���ƣ�
			lgt.trouble();  //���������trouble����
		}
		
		System.out.println("====================");  //��ʽ����
		
		
		//����
		Electrical ectl2 = new TV("����");  //����TV�࣬ʵ����Electrical�࣬����ectl2��TV������
		ectl2.turnOn();  //ectl2�����������д�Ŀ�����������
		ectl2.turnOff();  //ectl2�����������д�Ĺرյ����ķ���
		
		//���øö������������˽�з���
		if(ectl2 instanceof TV){  //�жϸö����Ƿ���TV���ʵ��
			TV tv = (TV)ectl2;  //��TV�����ǿת��ectl2����
			tv.trouble();  //����TV��˽�з���
		}
		
		System.out.println("====================");  //��ʽ����
		
		
		//����
		Electrical ectl3 = new Fan("����");  //ʵ����Electrical����ectl3����
		ectl3.turnOn();  //ectl3������ø�����Ĵ򿪵�������
		ectl3.turnOff();  //ectl3������ø�����رյ����ķ���
	}
}
