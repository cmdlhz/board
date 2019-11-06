package com.board.bdi.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.board.bdi.dao.UserDAO;
import com.board.bdi.dao.impl.UserDAOImpl;
import com.board.bdi.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDAO udao = new UserDAOImpl();
		
	@Override
	public Map<String, String> doLogin(String uiId, String uiPwd) {
		Map<String, String> user = new HashMap<>();
		// 2nd parameter에 argument를 집어 넣음
		user.put("uiId", uiId);
		user.put("uiPwd", uiPwd);
		return user = udao.loginUser(user);
	}
	
	@Override
	public Map<String, String> doSignup(String uiName, String uiId, String uiPwd){
		Map<String, String> user = new HashMap<>();
		System.out.println(user); // {}
		user.put("uiName", uiName);
		user.put("uiId", uiId);
		user.put("uiPwd", uiPwd);
		System.out.println("user : " + user); // 잘 입력됨
		return user = udao.registerUser(user);
	}
	
	@Override
	public List<Map<String, String>> getUsers(Map<String, String> user){
		return udao.selectUsers(user);
	}
}
