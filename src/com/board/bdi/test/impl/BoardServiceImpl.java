package com.board.bdi.test.impl;

import java.util.HashMap;
import java.util.Map;

import com.board.bdi.test.BoardDAO;
import com.board.bdi.test.BoardService;

public class BoardServiceImpl implements BoardService {
	private BoardDAO bdao = new BoardDAOImpl();
	
	public Map<String, String> insertBoard(Map<String, String> board) {
		Map<String, String> rMap = new HashMap<>();
		int result = bdao.insertBoard(board);
		if(result == 1) {
			rMap.put("msg", "SUCCESS!");
		} else {
			rMap.put("msg", "FAILURE!");
		}
		return rMap;
	}
	public static void main(String[] args) {
		BoardService bs = new BoardServiceImpl();
		Map<String, String> board = new HashMap<>();
		board.put("biTitle", "title test");
		board.put("biContent", "content test");
		board.put("uiNum", "103");
		Map<String, String> rMap = bs.insertBoard(board);
		System.out.println(rMap);
	}
}
