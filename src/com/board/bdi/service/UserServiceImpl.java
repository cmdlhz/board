package com.board.bdi.service;

import java.util.HashMap;
import java.util.Map;

import com.board.bdi.dao.UserDAO;
import com.board.bdi.dao.impl.UserDAOImpl;

public class UserServiceImpl implements UserService {
	private UserDAO udao = new UserDAOImpl();
		
	@Override
	public Map<String, String> doLogin(String uiId, String uiPwd) {
		Map<String, String> user = new HashMap<>();
		// 2nd parameter에 argument를 집어 넣음
		user.put("uiId", uiId);
		user.put("uiPwd", uiPwd);
		return user = udao.selectUser(user);
	}
	
	@Override
	public Map<String, String> doSignup(String uiName, String uiId, String uiPwd){
		Map<String, String> user = new HashMap<>();
		System.out.println(user); // {}

		user.put("uiName", uiName);
		user.put("uiId", uiId);
		user.put("uiPwd", uiPwd);
		System.out.println(user); // 잘 입력됨
		return user = udao.registerUser(user);
	}
}
