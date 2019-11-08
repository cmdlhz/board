package com.board.bdi.test;

import java.util.ArrayList;
import java.util.List;

public class Test3List {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(3);
		list.add(10);
		list.add(2);
		list.add(33);
		list.add(15);
		
		for(int i=0; i<list.size(); i++) {
			for(int j=i+1; j<list.size(); j++) {
				if(list.get(i) < list.get(j)) {
					int tmp = list.get(i);
					list.set(i, list.get(j));
					list.set(j, tmp);
				}
			}
		}
		System.out.println(list);
	}
}
