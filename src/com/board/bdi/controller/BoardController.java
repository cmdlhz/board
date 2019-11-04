package com.board.bdi.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.bdi.service.BoardService;
import com.board.bdi.service.impl.BoardServiceImpl;

public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService bs = new BoardServiceImpl();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("This must get passed!");
		String cmd = request.getRequestURI().substring(7);
		Map<String, String> board = new HashMap<>();
		
		if("list".contentEquals(cmd)) {
			List<Map<String, String>> list = new ArrayList<>();
			request.setAttribute("list", list);
		}
		String path = "/views/board/list";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String cmd = request.getRequestURI().substring(7);
		Map<String, String> board = new HashMap<>();
		String path = "/views/msg";
		
		if("insert".contentEquals(cmd)) {
			board.put("biTitle", request.getParameter("bi_title"));
			board.put("biContent", request.getParameter("bi_content"));
			
			HttpSession hs = request.getSession();
			Map<String, String> user = (Map<String, String>)hs.getAttribute("user");
			board.put("uiNum", user.get("uiNum"));
			
			Map<String, String> rMap = bs.insertBoard(board);
			request.setAttribute("msg", rMap.get("msg"));
			request.setAttribute("msg", rMap.get("url"));
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
