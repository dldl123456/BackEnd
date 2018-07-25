package com.iotek.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iotek.dao.StudentDao;
import com.iotek.db.DbHelp;
import com.iotek.entity.Student;

/**
 * Dao ʵ����
 * �����ݿ���н�����ֻд���ݿ⽻�����룬����дҵ���߼�������룬ҵ���߼�����ŵ�service��
 * @author Administrator
 *
 */
public class StudentDaoImpl implements StudentDao {
	
	private DbHelp db;
	private Connection conn;
	private List<Student> list ; 
	
	public StudentDaoImpl() {
		db = new DbHelp(); //����һ��dbʵ��,��ʼ��
		list =  new ArrayList<>();
		//conn = db .getConnection();
	}

	@Override
	public int addStudent(Student student) {
		/**
		 * conn -- dbhelp
		 * ÿ�η������ö�Ҫ������,���ҹر�
		 * ��Ϊÿһ���������൱�ڲ���һ�����ݿ�
		 * ?����ռλ��, ���԰���Ҫ����������ӽ�ȥ
		 */
		conn = db .getConnection( );
		String sql = "insert into student(name,psw,score) values(?,?,?)";
		
		PreparedStatement ps  = null;
		try {
			//�봦�����sql ���,��û��ִ��
			ps = conn.prepareStatement(sql);
			//��ѧ�����������name ����һ��ռλ��
			ps.setString(1, student.getName());
			ps.setString(2, student.getPsw());
			ps.setDouble(3, student.getScore());
			//���ص�����Ӱ�������
			//��ɾ�� ���ǵ��õ�executeUpdate();
			//�� executeQuery();
			return ps.executeUpdate();//ִ�в��������ݿ�����
			//������ʾ,Ҫ�����ֵ���س�ȥ,���߼�������ж�
			/*if (ps.executeUpdate() !=0 ) {
				System.out.println(" ok   ");
			}
			*/
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.closeAll(conn, ps, null);
		}
		return 0;
 
		
	}

	@Override
	public int deleteStudent(int id) {
		return 0;
	}

	@Override
	public int updateStudent(Student student) {
		return 0;
	}

	@Override
	public List<Student> selectAll() {
		conn = db.getConnection();
		String sql = "select * from student";
		PreparedStatement ps  = null;
		ResultSet rs  = null;
		try {
			ps = conn.prepareStatement(sql );
			rs = ps.executeQuery();
			//һ��һ���ļ�¼��Ϣ
			Student student ;
			while(rs.next()){
				 int id = rs.getInt("id");//�õ�������һ�е�ֵ
				 String name = rs.getString("name");
				 String psw = rs.getString("psw");
				 double score  = rs.getDouble("score");
				 // ȷ��===>>ÿ�ε�ѭ���õ��Ķ���һ���µ�ѧ������  
				 student = new Student(id, name, psw, score);
				 list.add(student);//��ѧ��������ӵ���������
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.closeAll(conn, ps, rs);
		}
		return list;
	}


}
