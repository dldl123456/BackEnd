/*
 *  �������ģʽ:���ʵ��������ֻ����һ�ι��췽��
 *  ����ģʽ������Ҫnew���󣬾�̬��װʵ������������������ȡ��̬����
 */

package video.note.singleTonDemo;

public class SingleTonDemo {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		//SingleTon st1 = new SingleTon();  //newһ��st1����ʵ����SingleTon��,����st1����
		SingleTon st1 = SingleTon.getInstance();
		SingleTon st2 = SingleTon.getInstance();
	}
}

/*class SingleTon{
 * 	//����ʽ
	//�Լ��ڲ�newһ��������Ϊ���췽����˽�е�
	private static SingleTon singleTon = new SingleTon();
	
	//���췽������Ϊ��������ÿ��ʵ���������ã����Բ�����public��
	//˽�з���ֻ�ܱ�����ܵ���
	private SingleTon(){
		System.out.println("�������ģʽ");
	}
	
	//����������SingleTon��˵�������㹹�������SingleTon���������������SingleTon����
	public static SingleTon getInstance(){
		return singleTon;
	}
}*/

class SingleTon{
	//�Լ��ڲ�newһ��������Ϊ���췽����˽�е�
	// private static SingleTon singleTon = new SingleTon();
	
	//����һ������
	private static SingleTon singleTon = null;
	
	//���췽������Ϊ��������ÿ��ʵ���������ã����Բ�����public��
	//˽�з���ֻ�ܱ�����ܵ���
	private SingleTon(){
		System.out.println("�������ģʽ");
	}
	
	//����������SingleTon��˵�������㹹�������SingleTon���������������SingleTon����
	//����������������ʱ���ж�singleTon�Ƿ�Ϊ�գ��յĻ�˵����û���������ٰ��������������ٷ���
	//�ٴε������������ʱ����Ϊ�Ǿ�̬�ģ��ǹ���ģ����Բ��ٻ���null������ֱ�ӷ���
	//���ֽ�����ʽ����
	public static SingleTon getInstance(){
		if(singleTon == null){
			singleTon = new SingleTon();
		}
		return singleTon;
	}
}
