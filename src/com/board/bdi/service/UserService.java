package com.board.bdi.service;

import java.util.Map;

public interface UserService {
	public Map<String, String> doLogin(String uiId, String uiPwd);
	public Map<String, String> doSignup(String uiName, String uiId, String uiPwd);
	public Map<String, String> getUsers(Map<String, String> board);
}

/*
 * 여기서 login request를 처리해줘도 됨 => 그럼 controller가 compact해짐
 */