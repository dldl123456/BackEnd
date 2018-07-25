/*
 *  ҽ���������߿���
 */

package video.note.exceptionDemo_2;

import java.util.Random;

public class ExceptionTest {
	//������
	public static void main(String[] args) {
		Worker worker = new Worker();
		Doctor doctor = new Doctor();
		
		//�����쳣
		try{
			worker.work();
		}catch(SickException e){
			doctor.cure(worker);
			if(worker.getStatus().equals("����")){
				System.out.println("��ϲ��ָ���");
			}else{
				System.out.println("�Ҿ�����");
			}
		}finally{
			System.out.println("��ӭ�´�����Ժ����");
		}
	}
}

//������
class Worker{
	private String status;  //״̬

	//get/set����
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	//һ����������
	public void work() throws SickException {
		//ʵ����һ���������������
		Random random = new Random();
		int rad = random.nextInt(3) + 1;  //�����������int n = (int)(Math.random()*3+1);
		if(rad==1){  //�����������1ʱ
			//�׳�һ���Զ����쳣����
			throw new SickException("���в�");
		}else{
			System.out.println("���彡������������");
		}
	}
}

//�Զ����쳣��
@SuppressWarnings("serial")
class SickException extends Exception{
	private String message;
	public SickException(String message){
		this.message = message;
	}
	
	//��дgetMessage����
	public String getMessage(){
		return message;
	}
}

//ҽ��
class Doctor{
	//�β�����workerʵ������worker�����β�
	public void cure(Worker worker){
		Random random = new Random();
		int rad = random.nextInt(2) + 1;  //�������������
		
		if(rad==1){
			worker.setStatus("����");
		}else{
			worker.setStatus("����");
		}
	}
}