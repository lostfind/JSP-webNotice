package com.board.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import org.omg.PortableServer.RequestProcessingPolicy;

public class ControllerAction extends HttpServlet {
	private Map commandMap = new HashMap(); // 명령어, 명령어 처리 클래스 
	
	public void init(ServletConfig config) throws ServletException {
		//Common properties
		loadProperties("com/board/properties/Command");
	}
	
	//properties 설정
	private void loadProperties(String path) {
		ResourceBundle rbHome = ResourceBundle.getBundle(path);
		
		Enumeration<String> actionEnumHome = rbHome.getKeys();
		
		while (actionEnumHome.hasMoreElements()) {
			String command = actionEnumHome.nextElement();
			String className = rbHome.getString(command);
			
			try {
				Class commandClass = Class.forName(className);
				Object commandInstance = commandClass.newInstance();
				commandMap.put(command, commandInstance);
				
			} catch (ClassNotFoundException e) {
				continue; //error
				
//				throw new ServletException(e);
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		requestPro(request, response); //get 방식 처리
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		requestPro(request, response); //post 방식 처리
	}
	
	//사용자의 요청을 분석해서 작업 처리
	private void requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = null;
		CommandAction com = null;
		
		try {
			String command = request.getRequestURI();
			if (command.indexOf(request.getContextPath()) == 0 ) {
				command = command.substring(request.getContextPath().length());
			}
			
			com = (CommandAction) commandMap.get(command);
			
			if (com == null) {
				System.out.println("not found : " + command);
				return;
			}
			
			view = com.requestPro(request, response);
			
			if (view == null) {
				return;
			}
			
		} catch (Throwable e) {
			throw new ServletException(e);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}
}