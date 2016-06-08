package com.board.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.beans.Board;
import com.board.controller.CommandAction;
import com.board.dao.BoardDao;

public class ListAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		request.setCharacterEncoding("UTF-8");

		int page = 0;
		int pageTotal = 1;

		//page파라미터가 있는경우에만 넘김
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}

		ArrayList<Board> articleList = BoardDao.getInstance().getArticleList(page);
		pageTotal = BoardDao.getInstance().getPageTotal();

		request.setAttribute("articleList", articleList); // 뷰에 리스트 포워드
		request.setAttribute("page", page);
		request.setAttribute("pageTotal", pageTotal);

		return "list.jsp";
	}
}