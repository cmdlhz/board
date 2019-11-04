package com.board.bdi.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
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
	public Map<String, String> selectUser(Map<String, String> user) {
		try {
			con = DriverManager.getConnection(URL, ID, PWD);
			String sql = "select * from user_info where ui_id=? and ui_pwd=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, user.get("uiId"));
			ps.setString(2, user.get("uiPwd"));
			rs = ps.executeQuery();
			// true일 경우에만 실행됨
			if(rs.next()) {
				user.put("uiId", rs.getString("ui_id"));
				user.put("uiPwd", rs.getString("ui_pwd"));
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
}
