package com.board.bdi.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.bdi.service.BoardService;
import com.board.bdi.service.impl.BoardServiceImpl;
import com.google.gson.Gson;


public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService bs = new BoardServiceImpl();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		List<Map<String,String>> hList = new ArrayList<>();
		
		Map<String, String> board = new HashMap<>();
		List<Map<String, String>> hList = bs.getBoardList(board);
//		Map<String,String> h = new HashMap<>();
//		h.put("name", "jen");
//		h.put("age", "30");
//		hList.add(h);
//		hList.add(h);
//		hList.add(h);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		Gson gson = new Gson();
		pw.print(gson.toJson(hList));
//		pw.print(hList);
		
//		List<String> strList = new ArrayList<>();
//		strList.add("1");
//		strList.add("yo");
//		strList.add("아아");
//		response.setContentType("text/html;charset=utf-8");
//		response.getWriter().print(strList);
		
		/*  이렇게 출력하려면 아래와 같이 코딩할 수도 있지만,
		 *  JSON을 사용해 language에 상관없이 사용할 수 있게 함
		 *  1
			yo
			아아
		 */
		
//		String html = "";
//		for(String str : strList) {
//			html += "<br>" + str + "<br>";
//		}
//		response.getWriter().print(html);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("name", "jen");
		map.put("age", "30");
		map.put("country", "Korea");
		System.out.println(map);
		
		Gson gson = new Gson();
		String jsonStr = gson.toJson(map);
		System.out.println(jsonStr);
	}
	
	/*
	 * {country=Korea, color=green, gender=female, name=jen, age=30, height=170}
		{"country":"Korea","color":"green","gender":"female","name":"jen","age":"30","height":"170"}
	 */
}
