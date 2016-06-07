package com.board.action;

import com.board.beans.Board;
import com.board.controller.CommandAction;
import com.board.dao.BoardDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;

/**
 * Created by DWKIM on 2016. 6. 7..
 */
public class DownloadAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		request.setCharacterEncoding("UTF-8");
		String idx = request.getParameter("idx");

		Board article = BoardDao.getInstance().getContent(idx);

		String filename = article.getFilename();
		String uploadFilename = request.getSession().getServletContext().getRealPath("/upload") + "/" + filename;

		System.out.println("다운로드파일 경로 : " + uploadFilename);

		File downFile = new File(uploadFilename);

		if(downFile.exists() && downFile.isFile()) {
			try {
				long filesize = downFile.length();
				response.setContentType("application/x-msdownload");
				response.setContentLength((int)filesize);

				String strClient = request.getHeader("user-agent");

				if(strClient.indexOf("MSIE 5.5")!=-1) {
					response.setHeader("Content-Disposition", "filename=" + filename + ";" );
				} else {
					filename = URLEncoder.encode(filename, "UTF-8").replaceAll("\\+","%20");
					response.setHeader("Content-Disposition", "attachment; filename=" + filename + ";" );
				}

				response.setHeader("Content-Length", String.valueOf(filesize));
				response.setHeader("Content-Transfer-Encoding", "binary;");
				response.setHeader("Pragma", "no-cache");
				response.setHeader("Cache-Control", "private");

				byte b[] = new byte[1024];
				BufferedInputStream fin = new BufferedInputStream(new FileInputStream(downFile));
				BufferedOutputStream outs = new BufferedOutputStream(response.getOutputStream());
				int read = 0;

				while((read=fin.read(b)) != -1)
				{
					outs.write(b, 0, read);
				}

				outs.flush();
				outs.close();
				fin.close();

			} catch (Exception e) {
				System.out.println("Download Exception : " + e.getMessage());
			}
		} else {
			System.out.println("Download Error : " + downFile);
		}

		return null;
	}
}
