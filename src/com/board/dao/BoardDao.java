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


	public ArrayList<Board> getArticleList(int page) throws SQLException {
		
		ArrayList<Board> articleList = new ArrayList<Board>();
		articleList = (ArrayList<Board>)GetDB().queryForList("getArticleList", null, page, 5);

		return articleList;
	}


	public Board getContent(String idx) throws SQLException {

		Board article = new Board();
		article = (Board)GetDB().queryForObject("getContent", idx);

		return article;
	}


	public void insertContent(String title, String user_id, String content) throws SQLException {

		Board article = new Board();

		article.setTitle(title);
		article.setUser_id(user_id);
		article.setContent(content);
		
		GetDB().insert("insertContent", article);
	}


	public void deleteContent(String idx) throws SQLException {
		GetDB().delete("deleteContent", idx);
	}
}