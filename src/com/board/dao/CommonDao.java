package com.board.dao;

import com.board.db.sqlconfig.IBatisDBConnector;
import com.ibatis.sqlmap.client.SqlMapClient;

public class CommonDao {

	private SqlMapClient myDB;
	
	public void setDB() {
		myDB = IBatisDBConnector.getsqlMapInstance();
	}
	
	protected SqlMapClient GetDB() {
		return myDB;
	}
	
}
