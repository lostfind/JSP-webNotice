package com.board.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.beans.Board;
import com.board.controller.CommandAction;
import com.board.dao.BoardDao;

public class ContentAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		
		String idx = request.getParameter("idx");
		
		ArrayList<Board> contentList = BoardDao.getInstance().getContent(idx);
		
		request.setAttribute("contentList", contentList);
		
		return "content.jsp";
	}
}
