package com.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.beans.Board;
import com.board.controller.CommandAction;
import com.board.dao.BoardDao;

import java.io.File;

public class DeleteAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");

		String idx = request.getParameter("idx");

		//게시글의 첨부파일 삭제
		Board article = BoardDao.getInstance().getContent(idx);
		String filename = article.getFilename();
		//첨부파일의 실제경로
		String uploadFilename = request.getSession().getServletContext().getRealPath("/upload") + "/" + filename;

		File uploadFile = new File(uploadFilename);

		if(uploadFile.exists() && uploadFile.isFile()) {
			//파일 삭제
			uploadFile.delete();
		}

		//게시글 삭제
		BoardDao.getInstance().deleteContent(idx);

		return "delete.jsp";
	}

}
