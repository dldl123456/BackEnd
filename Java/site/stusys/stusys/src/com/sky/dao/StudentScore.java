package com.sky.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.ResultSet;  

import com.sky.test.Student;

public class StudentScore {
	//��������
	//����ֵ -- ��ʾ���ջ���һ��ѧ�����󷵻�
//	public void queryScore(String sid) throws Exception
	public Student queryScore(String sid) throws Exception {
		//1����������,ע������
		Class.forName("com.mysql.jdbc.Driver");
		
		//2���������ӣ������������Ҫ�����ĸ����ݿ� 
		String url = "jdbc:mysql://localhost:3308/student?characterEncoding=utf-8";
		
		//3���������ݿ�
		Connection conn = DriverManager.getConnection(url, "root", "admin");
		
		
		/*----------------
			/*���ӡ��޸ġ�ɾ��һ����¼*/
		/*//4��Ҫ���--дsql���������ݿ�	--�ҵ�xx,����
		// String sql = "INSERT INTO score VALUES(1, '��', '99', '66', '33')";
		// String sql = "UPDATE score SET name = '��' where id =1";
		// String sql = "delete from score where id=2";
		
		//5������ִ�ж���
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		//6��ִ��sql���	--����
		int i = stmt.executeUpdate();
		System.out.println(i);
		
		//7���ر����� 
        stmt.close();  
        conn.close();*/
		
	/*��ѯ*/
		/*//4��Ҫ���--дsql���������ݿ�	--�ҵ�xx,����
		Statement stmt = null;//��ʾ���ݿ���²���  
		ResultSet result = null;//��ʾ�������ݿ��ѯ���Ľ��  
		stmt = conn.createStatement();//tatement�ӿ���Ҫͨ��connection�ӿڽ���ʵ�������� 
		result = stmt.executeQuery("select * from score");//ִ��sql��䣬���������result��  
		
		//5������ִ�ж���
		while(result.next()){//�ж��Ƿ�����һ��  
            String name = result.getString("name");//��ȡ���ݿ�person����name�ֶε�ֵ  
            System.out.println(name);  
        }  
		
		//6���ر�����
		result.close();  
        stmt.close();  
        conn.close();
		 * 
		 * -------------------------*/
		
		
		/*------------------------------
		//4��������Ҫִ�е�sql���������ݿ�(��ѯ)
		String sql = "SELECT * FROM score";
		
		//5������ִ�����sql���Ķ��󣬸�������Ҫ��ִ���������
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		//ִ��sql��䣬��ɾ�Ķ�����executeUpdate����ѯ��executeQuery
		//ResultSet��һ�����������sqlִ�е����м�¼
		ResultSet rs = stmt.executeQuery();
		
		//��ȡ������������������
		while(rs.next()){
			String id = rs.getString(1);
			String name = rs.getString(2);
			int chinese = rs.getInt(3);
			int math = rs.getInt(4);
			int english = rs.getInt(5);
			
			System.out.println("Student [id=" + id + ", name=" + name + ", chinese=" + chinese
					+ ", math=" + math + ", english=" + english + "]");
		}
		rs.close();
		stmt.close();  
        conn.close();
		return null;
		-----------------------------------------*/
		
		//4��������Ҫִ�е�sql���������ݿ�(��ѯ)
		String sql = "SELECT * FROM score where id = ?";
		
		//5������ִ�����sql���Ķ��󣬸�������Ҫ��ִ���������
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		//ִ�ж������߳�����ʲô
		//?��ռλ����ʾsid
		//��һ��������ʾ��һ���ʺţ�sid������䵽��һ���ʺõ�ֵ
		stmt.setString(1, sid);
		
		//ִ��sql��䣬��ɾ�Ķ�����executeUpdate����ѯ��executeQuery
		//ResultSet��һ�����������sqlִ�е����м�¼
		ResultSet rs = stmt.executeQuery();
		Student s = new Student();
		
		//��ȡ������������������
		while(rs.next()){
			s.id = rs.getString(1);
			s.name = rs.getString(2);
			s.chinese = rs.getInt(3);
			s.math = rs.getInt(4);
			s.english = rs.getInt(5);
		}
		rs.close();
		stmt.close();  
        conn.close();
		return s;
	}
}
