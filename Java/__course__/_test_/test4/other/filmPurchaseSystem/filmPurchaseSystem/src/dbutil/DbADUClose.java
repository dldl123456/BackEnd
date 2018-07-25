package dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 封装数据库的增删改和关闭连接操作
 * @author Administrator
 *
 */
public class DbADUClose extends ConnectionFactory{
	protected Connection conn=null;//连接对象
	protected PreparedStatement ps=null;//预处理对象（处理SQL语句）
	protected ResultSet rs =null;//结果集
	//获得连接的方法
	public Connection getConnection() {
		try {
			Class.forName(DRIVER);//加载驱动
			conn = DriverManager.getConnection(URL,USER,PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return conn;
	}
	/**
	 * 执行增删改操作
	 * @param sql//SQL语句
	 * @param params//？占位符的数组
	 * @return
	 */
	public int executeUpdate(String sql,Object[] params) {
		try {
			ps=getConnection().prepareStatement(sql);//获得连接并创建预处理对象
			//设置？占位符的值
			for(int i=0;i<params.length;i++) {
				ps.setObject(i+1,params[i]);//表示第几个元素，值是什么
			}
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	/**
	 * 关闭所有资源
	 */
	public void closeAll(){	
		try {
			if(rs!=null){
				rs.close();
			}
			if(ps!=null){
				ps.close();
			}
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}finally{
		conn =null;
		ps = null;
		rs =null;
	}
}
}