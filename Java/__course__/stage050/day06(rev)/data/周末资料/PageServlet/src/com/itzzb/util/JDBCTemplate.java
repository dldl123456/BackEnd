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

	// ��ɾ�Ĳ���DML  (insert,update,delete )
	public int update(String sql, PreparedStatementSetter setter) {
		int res = 0;// Ӱ�������
		try {
			conn = ConnectionFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			if (setter != null) {
				setter.setValues(pstmt);// �滻ռλ��
			}
			res = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
		return res;
	}

	// ִ�в�ѯ���
	public void query(String sql, PreparedStatementSetter setter, RsCallBackHandler handler) {
		try {
			conn = ConnectionFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			if (setter != null) {
				setter.setValues(pstmt);// �滻ռλ��
			}
			rs = pstmt.executeQuery();// ִ�в�ѯ���
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
