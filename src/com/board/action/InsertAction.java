package com.board.action;

import com.board.beans.Board;
import com.board.controller.CommandAction;
import com.board.dao.BoardDao;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		request.setCharacterEncoding("UTF-8");

		MultipartRequest multi = null;

		int sizeLimit = 1024 * 1024 * 10;
		String savePath = request.getSession().getServletContext().getRealPath("/upload");

		try {
			multi = new MultipartRequest(request, savePath, sizeLimit, "UTF-8", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			e.printStackTrace();
		}

		String filename = multi.getFilesystemName("filename");
		String title = multi.getParameter("title");
		String user_id = multi.getParameter("user_id");
		String content = multi.getParameter("content");
		String regip = request.getRemoteAddr();

		Board article = new Board();

		article.setTitle(title);
		article.setUser_id(user_id);
		article.setContent(content);
		article.setRegip(regip);
		article.setFilename(filename);

		BoardDao.getInstance().insertContent(article);

		return "insert.jsp";
	}
}
