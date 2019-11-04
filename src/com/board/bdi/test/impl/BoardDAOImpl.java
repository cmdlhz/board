package com.board.bdi.test.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.board.bdi.test.BoardDAO;

public class BoardDAOImpl implements BoardDAO {

	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String ID = "bdi";
	private static final String PWD = "12345678";
	// DRIVER_NAME도 원래는 써줘야 함
	
	private Connection con;
	private PreparedStatement ps;
	
	@Override
	public int insertBoard(Map<String, String> board) {
		try {
			// Connection은 원래 다른 class에서 불러와야 함
			con = DriverManager.getConnection(URL, ID, PWD);
			String sql = " insert into board_info ";
			sql += "values(seq_ui_num.nextval, ?, ?, ?, TO_CHAR(SYSDATE, 'YYYYMMDD'), TO_CHAR(SYSDATE, 'HH24MISS'), TO_CHAR(SYSDATE, 'YYYYMMDD'), TO_CHAR(SYSDATE, 'HH24MISS'), '1')";
			ps = con.prepareStatement(sql);
			ps.setString(1, board.get("biTitle"));
			ps.setString(2, board.get("biContent"));
			ps.setString(3, board.get("uiNum"));
			System.out.println(board);
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try{
				if(ps!= null) ps.close();
				if(con!= null) con.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
//	public static void main(String[] args) {
//		// BoardDAO, BoardDAOImpl, Object
//		// Interface를 쓰면 BoardDAO로 써줘야 함
//		BoardDAO bdao = new BoardDAOImpl();
//		Map<String, String> board = new HashMap<>();
//		board.put("biTitle", "test title");
//		board.put("biContent", "test content");
//		board.put("uiNum", "47");
//		int result = bdao.insertBoard(board);
//		if(result == 1) {
//			System.out.println("Completed!");
//		} else {
//			System.out.println("Not Saved!");
//		}
//	}
}
