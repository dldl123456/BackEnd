/*
 *  throw,throws
 *  ͨ��throw�����ڷ����������λ���׳��쳣
 *  �ܲ��쳣�����벶�񣬷����ܱ��룩�����ܲ��쳣�����Ա��룩
 */

package video.note.exceptionDemo_1;

public class ExceptionDemo_2 {
	public static void main(String[] args) {
		//��̬���÷Ǿ�̬�����Ȳ���һ������
		Bar bar = new Bar();
		/*bar.enter(15);  //����׳��쳣�������ڴ��ж�
		System.out.println("end");*/
		
		//�ó����ж�
		try{
			bar.enter(15);
		}catch(Exception e){
			System.out.println("������Ϣ��" + e.getMessage());
		}
		
		/*catch(IllegalArgumentException e){
			//e.getMessage()��ʾ������Ϣ���ַ�������
			System.out.println("������Ϣ��" + e.getMessage());
		}*/
		System.out.println("end");
	}
}

class Bar{
	public void enter(int age) throws /*IllegalArgumentException*/ Exception {  //����ʹ���ߣ��ҿ��ܻ��׳�����쳣��������Ӧ��Ҫ����һ������쳣
		//���ֶ��׳������ܲ��쳣������Exception����ʱ������throws
		//�����Լ����������壩
		if(age<18){
			//����쳣������Exception������쳣����
			//�׳�һ�����쳣(new)
			//���ܲ��쳣�����Բ�������ֱ�ӽ���ϵͳ����ϵͳ�Զ���⣬�������ǽ���ȱʡ���쳣������������д���
			//throw new IllegalArgumentException("���䲻�ϸ�");  //�Ƿ������쳣
			throw new Exception("���䲻�ϸ�");  //Exception���ܲ��쳣�����벶��
		}else{
			System.out.println("��ӭ����");
		}
	}
}