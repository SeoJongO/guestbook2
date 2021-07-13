package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.GuestBookDao;
import com.javaex.vo.GuestBookVo;

@WebServlet("/gc")
public class GuestController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		GuestBookDao guestDao = new GuestBookDao();
		request.setCharacterEncoding("UTF-8");
		
		String action = request.getParameter("action");
		System.out.println(action);
		
		//리스트
		if("list".equals(action)) {
			System.out.println("[리스트]");
			
			List<GuestBookVo> guestList = guestDao.guestList();
			
			request.setAttribute("gList", guestList);
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/list.jsp");
			rd.forward(request, response);
			
		// 등록
		} else if("insert".equals(action) ) {
			System.out.println("[등록]");
			
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String content = request.getParameter("content");
			
			GuestBookVo guestVo = new GuestBookVo(name, password, content);
			
			int count = guestDao.guestInsert(guestVo);
			
			if(count>0) {
				System.out.println("등록 성공");
			} else {
				System.out.println("등록 실패");
			}
			
			response.sendRedirect("/guestbook2/gc?action=list");
		
		// 삭제폼
		} else if("dForm".equals(action)) {
			System.out.println("[삭제폼]");
			
			int no = Integer.parseInt(request.getParameter("no"));
			
			request.setAttribute("no", no);
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/deleteForm.jsp");
			rd.forward(request, response);

		// 삭제	
		} else if("delete".equals(action)) {
			System.out.println("[삭제]");
			
			int guestNo = Integer.parseInt(request.getParameter("no"));
			String password = request.getParameter("password");
		
			int count = guestDao.guestDelete(guestNo, password);
			
			if(count>0) {
				System.out.println("삭제 성공");
			} else {
				System.out.println("삭제 실패");
			}
			
			response.sendRedirect("/guestbook2/gc?action=list");
		
		// 재입력
		} else {
			System.out.println("재입력");
			
			response.sendRedirect("/guestbook2/gc?action=list");
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
