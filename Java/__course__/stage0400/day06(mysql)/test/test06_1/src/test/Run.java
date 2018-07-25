/**
 * 1����д������������JDBC���裺 ��-��-Ԥ-ִ-ʹ 
 * 2����д����ʵ�ּ���ɾ�Ĳ�ѧԱ��Ϣ
 */

package test;

import java.util.List;

public class Run {
	public static void main(String[] args) {
		//���ؽ��
		int addResult1 = 0,  //���1
			addResult2 = 0,  //���2
			delResult = 0,  //ɾ��
			updateResult = 0;  //�޸�
		
		//ʵ�������ݿ�����ӿ�ʵ����
		StudentDaoImpl stuDao = new StudentDaoImpl();
		
		//ʵ����ѧ����
		Student newStu1 = new Student("С��", 32, 66);
		Student newStu2 = new Student("����", 28, 33);
		Student newStu3 = new Student(1, "·�˼�", 20, 99.9);
		
		//��
		System.out.println("***** ���� *****");
		addResult1 = stuDao.addStudent(newStu1);
		addResult2 = stuDao.addStudent(newStu2);
		
		if(addResult1 == 1){
			System.out.println("����1����ɹ���");
		}else{
			System.out.println("����1����ʧ�ܣ�");
		}
		
		if(addResult2 == 1){
			System.out.println("����2����ɹ���");
		}else{
			System.out.println("����2����ʧ�ܣ�");
		}
		System.out.println();
		
		//ɾ
		System.out.println("***** ɾ�� *****");
		delResult =  stuDao.deleteStudent(2);
		if(delResult == 1){
			System.out.println("idΪ2������ɾ���ɹ���");
		}else{
			System.out.println("idΪ2������ɾ��ʧ�ܣ�");
		}
		System.out.println();
		
		//��
		System.out.println("***** �޸� *****");
		updateResult = stuDao.updateStudent(newStu3);
		if(updateResult == 1){
			System.out.println("idΪ1�������޸ĳɹ���");
		}else{
			System.out.println("idΪ1�������޸�ʧ�ܣ�");
		}
		System.out.println();
		
		//��
		System.out.println("***** ��ѯ *****");
		List<Student> stuList = stuDao.selectAll();
		for(Student stu:stuList){
			System.out.println(stu);
		}
	}
}
