package com.board.bdi.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.bdi.service.UserService;
import com.board.bdi.service.impl.UserServiceImpl;

public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService us = new UserServiceImpl();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String uiName = request.getParameter("uiName");
		String uiId = request.getParameter("uiId");
		String uiPwd = request.getParameter("uiPwd");
		
		String uri = request.getRequestURI();
		// "/users/" 삭제
		String cmd = uri.substring(7);
		String path = "/views/msg";
		
		if("login".contentEquals(cmd)) {
			Map<String, String> user = us.doLogin(uiId, uiPwd);
//			System.out.println(user);
			// null이 아니면 입력이 됐다는 얘기
			if(user != null) {
				HttpSession hs = request.getSession();
				hs.setAttribute("user", user);
				request.setAttribute("msg", "Login SUCCESS!");
				request.setAttribute("url", "/views/index");
			} else {
				request.setAttribute("msg", "Login FAILED!");
				request.setAttribute("url", "/views/user/login");
			}
		} else if("signup".equals(cmd)) {
			Map<String, String> user = us.doSignup(uiName, uiId, uiPwd);
//			System.out.println(user);
			if(user != null) {
				HttpSession hs = request.getSession();
				hs.setAttribute("user", user);
				request.setAttribute("msg", "Signup SUCCESS!");
				request.setAttribute("url", "/views/user/login");
			} else {
				request.setAttribute("msg", "Signup FAILED!");
				request.setAttribute("url", "/views/user/signup");
			}
		} else if("logout".equals(cmd)) {
			
		} else if("update".equals(cmd)) {
			
		} else if("delete".equals(cmd)) {
			
		}		
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}