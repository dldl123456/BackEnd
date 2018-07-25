package com.iotek.dao;

import java.util.List;

import com.iotek.entity.Student;

/**
 * ����ŵĶ��ǽӿ�  
 * �ӿ�����ŵ�����ɾ�Ĳ鷽��������
 * �ӿڱ������һ�ֹ淶;����ӿڽ��б��
 * ���Ҳ��չ��,�����
 * ���϶�̬,
 * һ���಻Ҫ�����ھ��������б��,�����ڽӿ�--������
 * 
 * @author Administrator
 *
 */
public interface StudentDao {
	/**
	 * ���ѧ����Ϣ
	 * @param student ��Ҫ�����ѧ������
	 * @return 0-- �������ʧ�� <br> !0 �ɹ�
	 */
	public int addStudent(Student student);
	
	/**
	 * ����idɾ��ѧ��
	 * @param  id 
	 * @return 0-- �������ʧ�� <br> !0 �ɹ�
	 */
	public int deleteStudent(int  id );
	
	/**
	 * �޸�ѧ����Ϣ
	 * update ���� set score=? where id=?
	 * @param student
	 * @return 0-- �������ʧ�� <br> !0 �ɹ�
	 */
	public int updateStudent(Student student);
	
	/**
	 * ��ѯ����ѧ����Ϣ
	 * @return List<Student>���ز鵽�����е�ѧ��������Ϣ -- list--
	 */
	public List<Student> selectAll();
	
}
