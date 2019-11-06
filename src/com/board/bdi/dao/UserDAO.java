package com.board.bdi.dao;

import java.util.List;
import java.util.Map;

public interface UserDAO {
	public Map<String, String> loginUser(Map<String, String> user);
	public Map<String, String> registerUser(Map<String, String> user);
	public List<Map<String, String>> selectUsers(Map<String, String> user);
}
