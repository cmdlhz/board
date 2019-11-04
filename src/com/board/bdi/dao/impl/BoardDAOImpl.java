package com.board.bdi.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.board.bdi.dao.BoardDAO;

public class BoardDAOImpl implements BoardDAO {
	private static final String URL="jdbc:oracle:thin:@localhost:1521:xe";
	private static final String ID="bdi";
	private static final String PWD="12345678";
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public List<Map<String, String>> selectBoardList(Map<String, String> board) {
		try {
			con = DriverManager.getConnection(URL, ID, PWD);
			String sql = "select * from board_info bi, user_info ui ";
			sql += " where bi.ui_num = ui.ui_num ";
			sql += " order by bi_num desc ";
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			List<Map<String, String>> list = new ArrayList<>();
			while(rs.next()) {
				Map<String, String> b = new HashMap<>();
				b.put("biNum", rs.getString("bi_num"));
				b.put("biTitle", rs.getString("bi_title"));
				b.put("uiNum", rs.getString("ui_num"));
				b.put("uiName", rs.getString("ui_name"));
				b.put("uiId", rs.getString("ui_id"));
				b.put("credat", rs.getString("credat"));
				b.put("cretim", rs.getString("cretim"));
				list.add(b);
			}
			return list;
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(con != null) con.close();
			} catch(SQLException sqle) {
				sqle.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Map<String, String> selectBoard(Map<String, String> board) {
		return null;
	}

	@Override
	public int insertBoard(Map<String, String> board) {
		try {
			con = DriverManager.getConnection(URL, ID, PWD);
			String sql = "insert into board_info(bi_num, bi_title, bi_content, ui_num, credat, cretim, moddat, modtim)";
			sql += " values(seq_bi_num.nextval, ?, ?, ?, TO_CHAR(SYSDATE, 'YYYYMMDD'), TO_CHAR(SYSDATE, 'HH24MISS'), TO_CHAR(SYSDATE, 'YYYYMMDD'), TO_CHAR(SYSDATE, 'HH24MISS'))";
			ps = con.prepareStatement(sql);
			ps.setString(1, board.get("biTitle"));
			ps.setString(2, board.get("biContent"));
			ps.setString(3, board.get("uiNum"));
			return ps.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(con != null) con.close();
			} catch(SQLException sqle) {
				sqle.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public int deleteBoard(Map<String, String> board) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateBoard(Map<String, String> board) {
		// TODO Auto-generated method stub
		return 0;
	}

}
