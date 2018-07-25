package video.note.templateDemo;

public class TemplateDemo {
	public static void main(String[] args) {
		Teacher t1 = new DBTeacher();
		t1.work();
		
		System.out.println("====================");
		
		Teacher t2 = new CTeacher();
		t2.work();
	}
}

//�����ࣨ�г��󷽷�����г����ࣩ
//����
abstract class Teacher{
	//�ڿ�ǰ׼����ÿ����ʦ��һ����
	public void prepared(){
		System.out.println("׼���װ��");
		System.out.println("��ͶӰ��");
	}
		
	//�ڿν�����ÿ����ʦ��һ����
	public void end(){
		System.out.println("�ر�ͶӰ��");
		System.out.println("��������");
	}
	
	//���������������󷽷����ڿβ�ͬ����ʦ��һ��
	public abstract void teaching();
	
	//��ʦ�����ķ���������һ�����̣�
	//ģ�巽��
	public void work(){
		//1���ڿ�ǰ׼��
		prepared();
		//2�������ڿ�
		teaching();
		//3���ڿν���
		end();
	}
}

//����
class DBTeacher extends Teacher{
	//�Գ�����ĳ��󷽷���ʵ��
	public void teaching(){
		System.out.println("��Oracle");
		System.out.println("��дpl-sqlָ��");
		System.out.println("�Ż�sqlָ��");
	}
}

//����
class CTeacher extends Teacher{
	//�Գ�����ĳ��󷽷���ʵ��
	public void teaching(){
		System.out.println("��VM");
		System.out.println("��дCָ��");
		System.out.println("����C����");
	}
}