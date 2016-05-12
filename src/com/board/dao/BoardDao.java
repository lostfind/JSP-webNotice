package com.board.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.board.beans.Board;

public class BoardDao extends CommonDao {
	
	public static BoardDao getInstance() {
		BoardDao _instance = new BoardDao();
		return _instance;
	}
	
	public ArrayList<Board> getArticleList() throws SQLException {
		ResultSet rs = null;
		
		//게시물 목록 조회 쿼리
		String sql = "select * from testdb.NOTICE order by idx desc";
		
		//openConnection()으로 연결 후 쿼리 실행 결과 반환
		rs = openConnection().executeQuery(sql);
		System.out.println("쿼리실행 : " + sql);
		
		//Board형 배열객체 생성
		ArrayList<Board> articleList = new ArrayList<Board>();
		
		while(rs.next()) {
			Board article = new Board();
			
			article.setIdx(rs.getInt("idx"));
			article.setTitle(rs.getString("title"));
			article.setUserid(rs.getString("user_id"));
			article.setRegdttm(rs.getString("reg_dttm"));
			article.setCount(rs.getInt("count"));
			
			articleList.add(article);
		}
		
		//DB 접속 해제
		closeConnection();
		
		//결과 배열객체 반환
		return articleList;
	}
	
	public ArrayList<Board> getContent(String idx) throws SQLException {

		ResultSet rs = null;
		
		String sql = "select * from testdb.NOTICE where idx = " + idx;
		
		rs = openConnection().executeQuery(sql);
		System.out.println("쿼리실행 : " + sql);
		
		ArrayList<Board> contentList = new ArrayList<Board>();
		
		while(rs.next()) {
			Board content = new Board();
			
			content.setIdx(rs.getInt("idx"));
			content.setTitle(rs.getString("title"));
			content.setUserid(rs.getString("user_id"));
			content.setRegdttm(rs.getString("reg_dttm"));
			content.setCount(rs.getInt("count"));
			content.setContent(rs.getString("content"));
			
			contentList.add(content);
		}
		//DB 접속 해제
		closeConnection();
		
		return contentList;
	}
}