/*
 *  �Զ����쳣��
 */

package video.note.exceptionDemo_1;

public class ExceptionDemo_3 {
	public static void main(String[] args) {
		Bar0 b0 = new Bar0();
		try{
			b0.enter(15);
		}catch(AgeLessThanEighteenException e){
			System.out.println("������Ϣ��" + e.getMessage());
		}
		System.out.println("end~");
	}
}

//�Զ�����һ���쳣��(С��18��)
//һ���ܲ��쳣
@SuppressWarnings("serial")
class AgeLessThanEighteenException extends Exception{  //�̳��쳣����
	//��������
	private String message;  //�����쳣��Ϣ
	
	//����һ����һ�������Ĺ��췽��
	public AgeLessThanEighteenException(String message){
		this.message = message;
	}
	
	//��д��ȡ�����쳣��Ϣ�ķ���
	public String getMessage(){
		return message;
	}
}

//����
class Bar0{
	public void enter(int age) throws AgeLessThanEighteenException{
		if(age<18){
			throw new AgeLessThanEighteenException("���䲻�ϸ�");
		}else{
			System.out.println("��ӭ����");
		}
	}
}
