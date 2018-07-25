package com.iotek.service;

import java.util.List;

import com.iotek.entity.Student;

/**
 * ҵ���߼���   
 * @author Administrator
 *
 */
public interface StudentBiz {
	
	/**
	 * ע��
	 * @param student ��Ҫ�����ѧ������
	 * @return 0-- �������ʧ�� <br> !0 �ɹ�
	 */
	public int addStudent(Student student);
	
	/**
	 * ��ѯ����ѧ������
	 * @return List<Student>
	 */
	public List<Student> selectAll();

	public boolean isExistName(String name);

	public boolean judgeNameAndPsw(String name, String psw);


}
