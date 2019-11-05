package com.board.bdi.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Fire2 extends Test2{
	
}

public class Test2 {
	public static void main(String[] args) {
		Map<String, Test2> map = new HashMap<>();
		map.put("one", new Test2());
		map.put("two", new Fire2());
		
		Iterator<String> it = map.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			System.out.println("The list of keys : " + key);
		}
	}
}
