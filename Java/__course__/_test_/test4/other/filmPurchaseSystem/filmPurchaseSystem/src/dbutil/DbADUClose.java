package dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ��װ���ݿ����ɾ�ĺ͹ر����Ӳ���
 * @author Administrator
 *
 */
public class DbADUClose extends ConnectionFactory{
	protected Connection conn=null;//���Ӷ���
	protected PreparedStatement ps=null;//Ԥ������󣨴���SQL��䣩
	protected ResultSet rs =null;//�����
	//������ӵķ���
	public Connection getConnection() {
		try {
			Class.forName(DRIVER);//��������
			conn = DriverManager.getConnection(URL,USER,PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return conn;
	}
	/**
	 * ִ����ɾ�Ĳ���
	 * @param sql//SQL���
	 * @param params//��ռλ��������
	 * @return
	 */
	public int executeUpdate(String sql,Object[] params) {
		try {
			ps=getConnection().prepareStatement(sql);//������Ӳ�����Ԥ�������
			//���ã�ռλ����ֵ
			for(int i=0;i<params.length;i++) {
				ps.setObject(i+1,params[i]);//��ʾ�ڼ���Ԫ�أ�ֵ��ʲô
			}
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	/**
	 * �ر�������Դ
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