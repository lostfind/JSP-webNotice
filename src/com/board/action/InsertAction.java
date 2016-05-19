package com.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.controller.CommandAction;
import com.board.dao.BoardDao;


public class InsertAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		String title = request.getParameter("title");
		String user_id = request.getParameter("user_id");
		String content = request.getParameter("content");
		
		BoardDao.getInstance().insertContent(title, user_id, content);

		return "insert.jsp";
	}
}
