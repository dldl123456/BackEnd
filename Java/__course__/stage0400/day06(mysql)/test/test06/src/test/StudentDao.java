package test;

import java.util.List;

public interface StudentDao {
	//���ѧ����Ϣ
	public int addStudent(Student student);
	
	//����idɾ��ѧ��
	public int deleteStudent(int  id);
	
	//�޸�ѧ����Ϣ
	public int updateStudent(Student student);
	
	//��ѯ����ѧ����Ϣ
	public List<Student> selectAll();
}
