package com.board.bdi.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.board.bdi.dao.BoardDAO;
import com.board.bdi.dao.impl.BoardDAOImpl;
import com.board.bdi.service.BoardService;

public class BoardServiceImpl implements BoardService {
	private BoardDAO bdao = new BoardDAOImpl();

	@Override
	public List<Map<String, String>> getBoardList(Map<String, String> board) {
		return bdao.selectBoardList(board);
	}

	@Override
	public Map<String, String> getBoard(Map<String, String> board) {
		return null;
	}

	@Override
	public Map<String, String> insertBoard(Map<String, String> board) {
		Map<String, String> rMap = new HashMap<>();
		int result = bdao.insertBoard(board);
		
		if(result == 1) {
			rMap.put("msg", "게시물 생성 Success!");
			rMap.put("url", "/board/list");
		} else {
			rMap.put("msg", "게시물 생성 Failure!");
			rMap.put("url", "/views/board/insert");
		}
		return rMap;
	}

	@Override
	public Map<String, String> updateBoard(Map<String, String> board) {
		return null;
	}

	@Override
	public Map<String, String> deleteBoard(Map<String, String> board) {
		return null;
	}

}
