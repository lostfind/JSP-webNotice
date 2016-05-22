package com.board.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.board.beans.Board;

public class BoardDao extends CommonDao {
	
	public static BoardDao getInstance() {
		BoardDao _instance = new BoardDao();
		
		//iBatis
		_instance.setDB();
		
		return _instance;
	}


	public ArrayList<Board> getArticleList() throws SQLException {
		
		ArrayList<Board> articleList = new ArrayList<Board>();
		articleList = (ArrayList<Board>)GetDB().queryForList("getArticleList", null);

		System.out.println("리스트 조회쿼리 실행완료");

		return articleList;
	}


	public Board getContent(String idx) throws SQLException {

		Board article = new Board();
		article = (Board)GetDB().queryForObject("getContent", idx);

		System.out.println("컨텐츠 조회쿼리 실행완료");
		
		return article;
	}


	public void insertContent(String title, String user_id, String content) throws SQLException {

		Board article = new Board();

		article.setTitle(title);
		article.setUser_id(user_id);
		article.setContent(content);
		
		GetDB().insert("insertContent", article);

		System.out.println("입력쿼리 실행완료");
	}


	public void deleteContent(String idx) throws SQLException {
		GetDB().delete("deleteContent", idx);
		
		System.out.println("삭제쿼리 실행완료");
	}
}