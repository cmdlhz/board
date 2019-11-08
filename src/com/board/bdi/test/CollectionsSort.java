package com.board.bdi.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsSort {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(3);
		list.add(10);
		list.add(2);
		list.add(33);
		list.add(15);
		
		Collections.sort(list, Collections.reverseOrder());
		System.out.println(list);
	}
}
