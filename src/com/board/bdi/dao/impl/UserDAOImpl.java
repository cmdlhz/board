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

import com.board.bdi.dao.UserDAO;

public class UserDAOImpl implements UserDAO {
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String ID = "bdi";
	private static final String PWD = "12345678";
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public Map<String, String> loginUser(Map<String, String> user) {
		try {
			con = DriverManager.getConnection(URL, ID, PWD);
			String sql = "select * from user_info where ui_id=? and ui_pwd=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, user.get("uiId"));
			ps.setString(2, user.get("uiPwd"));
			rs = ps.executeQuery();
			// true일 경우에만 실행됨
			if(rs.next()) {
				user.put("uiName", rs.getString("ui_name"));
				user.put("uiNum", rs.getString("ui_num"));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(con != null) con.close();
				if(ps != null) ps.close();
			} catch(SQLException sqle) {
				sqle.printStackTrace();
			}
		}
		return null;
	}
	
	public Map<String, String> registerUser(Map<String, String> user){
		try {
			con = DriverManager.getConnection(URL, ID, PWD);
			String sql = "insert into user_info(ui_num, ui_name, ui_id, ui_pwd, credat, cretim, moddat, modtim, active) ";
			sql += "values(seq_ui_num.nextval, ?, ?, ?, TO_CHAR(SYSDATE, 'YYYYMMDD'), TO_CHAR(SYSDATE, 'HH24MISS'), TO_CHAR(SYSDATE, 'YYYYMMDD'), TO_CHAR(SYSDATE, 'HH24MISS'), '1')";
			ps = con.prepareStatement(sql);
			ps.setString(1, user.get("uiName"));
			ps.setString(2, user.get("uiId"));
			ps.setString(3, user.get("uiPwd"));
			int result = ps.executeUpdate();
			if(result == 1) return user;
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(con != null) con.close();
				if(ps != null) ps.close();
			} catch(SQLException sqle) {
				sqle.printStackTrace();
			}
		}
		return null;
	}
	
//	public static void main(String[] args) {
//		UserDAO udao = new UserDAOImpl();
//		Map<String, String> user = new HashMap<>();
//		user.put("uiId", "mkkim");
//		user.put("uiPwd", "12345");
//		user = udao.selectUser(user);
//		System.out.println(user);
//	}
	
	public List<Map<String, String>> selectUsers(Map<String, String> user) {
		List<Map<String, String>> userList = new ArrayList<>();
		try {
			con = DriverManager.getConnection(URL,ID,PWD);
			// where 1=1 (일단 where문 실행, 그 이후에 조건문이 몇 개일지는 나중에 결정)
			// 지금은 마이바틱스라는 프로그램을 쓰는데 거기서 알아서 해줌
			String sql = "select * from user_info where 1=1 ";
			if(user.get("uiId") != null) {
				sql += " and uiId=? ";
			}
			if(user.get("uiNum") != null) {
				sql += " and uiNum=? ";
			}
			if(user.get("uiName") != null) {
				sql += " and uiName=? ";
			}
			sql += " order by ui_num desc";
			
			ps = con.prepareStatement(sql);
			
			if(user.get("uiId") != null && user.get("uiNum") == null && user.get("uiName") == null) {
				ps.setString(1, user.get("uiId"));
			} else if(user.get("uiId") == null && user.get("uiNum") != null && user.get("uiName") == null) {
				ps.setString(1, user.get("uiNum"));
			} else if(user.get("uiId") == null && user.get("uiNum") == null && user.get("uiName") != null) {
				ps.setString(1, user.get("uiName"));
			} else if(user.get("uiId") != null && user.get("uiNum") != null && user.get("uiName") == null) {
				ps.setString(1, user.get("uiId"));
				ps.setString(2, user.get("uiNum"));
			} else if(user.get("uiId") != null && user.get("uiNum") == null && user.get("uiName") != null) {
				ps.setString(1, user.get("uiId"));
				ps.setString(2, user.get("uiName"));
			} else if(user.get("uiId") == null && user.get("uiNum") != null && user.get("uiName") != null) {
				ps.setString(1, user.get("uiNum"));
				ps.setString(2, user.get("uiName"));
				// 그냥 else로 하면 안 나옴 ㅠㅠ 전체 목록이
			} else if(user.get("uiId") != null && user.get("uiNum") != null && user.get("uiName") != null) {
				ps.setString(1, user.get("uiId"));
				ps.setString(2, user.get("uiNum"));
				ps.setString(3, user.get("uiName"));
			}
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Map<String, String> u = new HashMap<>();
				u.put("uiNum", rs.getString("ui_num"));
				u.put("uiId", rs.getString("ui_id"));
				u.put("uiName", rs.getString("ui_name"));
				u.put("cretim", rs.getString("cretim"));
				u.put("credat", rs.getString("credat"));
				u.put("moddat", rs.getString("moddat"));
				u.put("mottim", rs.getString("modtim"));
				u.put("active", rs.getString("active"));
				userList.add(u);
			}
			return userList;
		} catch(SQLException e) {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(con!=null) con.close();
			} catch(SQLException sqle) {
				 sqle.printStackTrace();
			}
		}
		return null;
	}
}
