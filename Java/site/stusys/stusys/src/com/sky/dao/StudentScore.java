package com.sky.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.ResultSet;  

import com.sky.test.Student;

public class StudentScore {
	//程序的入口
	//返回值 -- 表示最终会有一个学生对象返回
//	public void queryScore(String sid) throws Exception
	public Student queryScore(String sid) throws Exception {
		//1、加载驱动,注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		
		//2、创建链接，这个程序最终要操作哪个数据库 
		String url = "jdbc:mysql://localhost:3308/student?characterEncoding=utf-8";
		
		//3、链接数据库
		Connection conn = DriverManager.getConnection(url, "root", "admin");
		
		
		/*----------------
			/*增加、修改、删除一条记录*/
		/*//4、要干嘛，--写sql语句操作数据库	--找到xx,打字
		// String sql = "INSERT INTO score VALUES(1, '马', '99', '66', '33')";
		// String sql = "UPDATE score SET name = '三' where id =1";
		// String sql = "delete from score where id=2";
		
		//5、创建执行对象
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		//6、执行sql语句	--发送
		int i = stmt.executeUpdate();
		System.out.println(i);
		
		//7、关闭连接 
        stmt.close();  
        conn.close();*/
		
	/*查询*/
		/*//4、要干嘛，--写sql语句操作数据库	--找到xx,打字
		Statement stmt = null;//表示数据库更新操作  
		ResultSet result = null;//表示接受数据库查询到的结果  
		stmt = conn.createStatement();//tatement接口需要通过connection接口进行实例化操作 
		result = stmt.executeQuery("select * from score");//执行sql语句，结果集放在result中  
		
		//5、创建执行对象
		while(result.next()){//判断是否还有下一行  
            String name = result.getString("name");//获取数据库person表中name字段的值  
            System.out.println(name);  
        }  
		
		//6、关闭连接
		result.close();  
        stmt.close();  
        conn.close();
		 * 
		 * -------------------------*/
		
		
		/*------------------------------
		//4、创建需要执行的sql语句操作数据库(查询)
		String sql = "SELECT * FROM score";
		
		//5、创建执行这个sql语句的对象，告诉他需要来执行这条语句
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		//执行sql语句，增删改都是用executeUpdate，查询用executeQuery
		//ResultSet是一个结果集，有sql执行的所有记录
		ResultSet rs = stmt.executeQuery();
		
		//获取结果集对象里面的数据
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
		
		//4、创建需要执行的sql语句操作数据库(查询)
		String sql = "SELECT * FROM score where id = ?";
		
		//5、创建执行这个sql语句的对象，告诉他需要来执行这条语句
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		//执行对象会告诉程序？是什么
		//?是占位符表示sid
		//第一个参数表示第一个问号，sid就是填充到第一个问好的值
		stmt.setString(1, sid);
		
		//执行sql语句，增删改都是用executeUpdate，查询用executeQuery
		//ResultSet是一个结果集，有sql执行的所有记录
		ResultSet rs = stmt.executeQuery();
		Student s = new Student();
		
		//获取结果集对象里面的数据
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
