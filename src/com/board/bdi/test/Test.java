package com.board.bdi.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Fire extends Test {
	
}

public class Test {
	public static void main(String[] args) {
		Map<String, Test> map = new HashMap<>();
		map.put("one", new Test());
		map.put("two", new Fire());
		
		Iterator<String> it = map.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			System.out.println("The list of keys : " + key);
		}
	}
}
