package sqltemplate;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface PreparedStatementSetter {
	//һ���ص���������PreparedStatement����Ҫִ�е�SQL����е�ռλ���滻�ɾ��������
	public void setValues(PreparedStatement pstmt) throws SQLException;
}
