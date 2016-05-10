package com.board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CommonDao {

//	request.setCharacterEncoding("UTF-8");

	//공통사용 DB정보 변수
	private final String driverName = "com.mysql.jdbc.Driver";
	private final String URL = "jdbc:mysql://localhost:3307/testdb";
	private final String USER = "dwkim";
	private final String PASS = "dwkim";
	
	private Connection conn = null;
	private Statement stmt = null;
	
	//DB 접속 메소드
	public Statement openConnection() {
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(URL, USER, PASS);
			System.out.println("MySQL connection success!");
			stmt = conn.createStatement();
			
		} catch (Exception e) {
			System.err.println("MySQL connection fail!");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return stmt;
	}

	//DB 접속 해제 메소드
	public void closeConnection() {
		try {
			//Connection이 닫히지 않았을 경우만
			if(!conn.isClosed()) {
				stmt.close();
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
