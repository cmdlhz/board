package com.board.bdi.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("This must get passed!");
		String cmd = request.getRequestURI().substring(7);
		if("list".contentEquals(cmd)) {
			List<Map<String, String>> list = new ArrayList<>();
			for(int i=1; i<=10; i++) {
				Map<String, String> map = new HashMap<>();
				map.put("biNum", i+"");
				map.put("biTitle", "게시물 제목 : " + i);
			}
		}
		String path = "/views/board/list";	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getRequestURI().substring(7);
		Map<String, String> board = new HashMap<>();
		if("insert".contentEquals(cmd)) {
			
		}
	}
}
