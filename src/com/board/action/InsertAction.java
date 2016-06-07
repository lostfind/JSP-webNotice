package com.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.beans.Board;
import com.board.controller.CommandAction;
import com.board.dao.BoardDao;

public class InsertAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		request.setCharacterEncoding("UTF-8");
		
		String title = request.getParameter("title");
		String user_id = request.getParameter("user_id");
		String content = request.getParameter("content");
		String regip = request.getRemoteAddr();
		int count = 0;
		
		Board article = new Board();
		
		article.setTitle(title);
		article.setUser_id(user_id);
		article.setContent(content);
		article.setCount(count);
		article.setRegip(regip);
				
		BoardDao.getInstance().insertContent(article);

		return "insert.jsp";
	}
}
