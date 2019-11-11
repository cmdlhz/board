package com.board.bdi.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> strList = new ArrayList<>();
		strList.add("1");
		strList.add("yo");
		strList.add("아아");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(strList);
		
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

}
