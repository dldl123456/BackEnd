package com.itzzb.util;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RsCallBackHandler {
	//����������һ���ص�����
   public void processRs(ResultSet rs)throws SQLException;
}
