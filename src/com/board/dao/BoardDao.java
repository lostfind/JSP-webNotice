package com.board.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.board.beans.Board;

public class BoardDao extends CommonDao {

	//페이지당 게시물 개수
	private int pageCount = 7;

	public static BoardDao getInstance() {
		BoardDao _instance = new BoardDao();

		//iBatis
		_instance.setDB();

		return _instance;
	}


	public ArrayList<Board> getArticleList(int page) throws SQLException {

		ArrayList<Board> articleList = new ArrayList<Board>();
		articleList = (ArrayList<Board>)GetDB().queryForList("getArticleList", (page * pageCount));

		return articleList;
	}

	public int getPageTotal() throws SQLException {

		int pageTotal = 0;
		pageTotal = (int)GetDB().queryForObject("getPageTotal", pageCount);

		return pageTotal;
	}


	public Board getContent(String idx) throws SQLException {

		Board article = new Board();
		article = (Board)GetDB().queryForObject("getContent", idx);

		return article;
	}


	public void insertContent(Board article) throws SQLException {
		GetDB().insert("insertContent", article);
	}


	public void deleteContent(String idx) throws SQLException {
		GetDB().delete("deleteContent", idx);
	}


	public void setArticleCount(Board article) throws SQLException {
		GetDB().update("setArticleCount", article);
	}
}