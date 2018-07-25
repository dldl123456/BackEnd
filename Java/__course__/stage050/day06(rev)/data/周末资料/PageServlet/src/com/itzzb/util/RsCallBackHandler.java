package com.itzzb.util;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RsCallBackHandler {
	//处理结果集的一个回调函数
   public void processRs(ResultSet rs)throws SQLException;
}
