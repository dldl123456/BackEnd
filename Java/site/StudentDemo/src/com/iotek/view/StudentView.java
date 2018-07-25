package com.iotek.view;

import com.iotek.entity.Student;
import com.iotek.service.StudentBiz;
import com.iotek.service.impl.StudentBizImpl;
import com.iotek.util.Util;

/**
 * ����ҳ��
 * @author Administrator
 *
 */
public class StudentView {
	
	private StudentBiz stuBiz;
	public StudentView() {
		stuBiz = new StudentBizImpl();
	}

	/**
	 * ע��ķ���
	 */

	public void regist() {
		while (true) {
			// ע��ʱҪ��ȥ�ж��û����Ƿ����
			String name = Util.getString("��������Ҫ������û���:");
			if (stuBiz.isExistName(name)) {
				System.out.println("��������û����Ѿ�����,�뻻һ������ע��");
			} else {
				// �������������������,, �����ݿ������������������
				String psw = Util.getString("����������:");
				// ����һ�������û����������ѧ������
				Student student = new Student(name, psw);
				if (stuBiz.addStudent(student) != 0) {
					System.out.println("ok ..ע��ɹ�.....");

					break;
				} else {
					System.out.println("sorry,ʧ��");
				}

			}
		}

	}

	/**
	 * �����û�����������е�¼
	 */
	public void login() {
		while (true) {

			String name = Util.getString("������Ҫ��¼���û���:");
			if (stuBiz.isExistName(name)) {
				boolean flag =true;
				// ok ��������
				while (flag  ) {
					String psw = Util.getString("����������:");
					if (stuBiz.judgeNameAndPsw(name, psw) ) {
						System.out.println("��¼�ɹ�!");
						flag  = false;//
					}else{
						System.out.println("���������������������..");
					}
					
				}

				break;
			} else {
				System.out.println("�û���������,����");
			}
		}
	}

}
