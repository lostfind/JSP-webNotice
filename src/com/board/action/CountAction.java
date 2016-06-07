package com.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.beans.Board;
import com.board.controller.CommandAction;
import com.board.dao.BoardDao;

public class CountAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("UTF-8");
		
		String idx = request.getParameter("idx");
		String regip = request.getRemoteAddr();		//조회한 사용자의 IP

		Board article = BoardDao.getInstance().getContent(idx);
		
		if(!regip.equals(article.getRegip())) {
			int count = article.getCount();
			article.setCount(++count);
			BoardDao.getInstance().setArticleCount(article);
		}
		
		request.setAttribute("url", "content.do?idx="+idx);
		
		return "redirect.jsp";
	}

}
