package com.itzzb.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCTemplate {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			
		}
	}

	// 增删改操作DML  (insert,update,delete )
	public int update(String sql, PreparedStatementSetter setter) {
		int res = 0;// 影响的行数
		try {
			conn = ConnectionFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			if (setter != null) {
				setter.setValues(pstmt);// 替换占位符
			}
			res = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
		return res;
	}

	// 执行查询语句
	public void query(String sql, PreparedStatementSetter setter, RsCallBackHandler handler) {
		try {
			conn = ConnectionFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			if (setter != null) {
				setter.setValues(pstmt);// 替换占位符
			}
			rs = pstmt.executeQuery();// 执行查询语句
			if (handler != null) {
				handler.processRs(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
	}
}
