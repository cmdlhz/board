package com.board.bdi.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Human2{
	private int age;
	private int height;
	public Human2(int age, int height) {
		super();
		this.age = age;
		this.height = height;
	}
	@Override
	public String toString() {
		return "Human2 [age=" + age + ", height=" + height + "]";
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
}

// 공통으로 쓸 거라면 generic 사용 : T means "type".
//class Compare<T> implements Comparator<T>{
//
//	@Override
//	public int compare(T o1, T o2) {
//		Human2 h1 = (Human2)o1;
//		Human2 h2 = (Human2)o2;
//		// 숫자를 바꾸면 descending이 됨
//		if(h1.getAge() < h2.getAge()) return -1;
//		if(h1.getAge() > h2.getAge()) return 1;
//		return 0;
//	}
//}

public class CollectionsHuman {
	public static void main(String[] args) {
		List<Human2> hList = new ArrayList<>();
		hList.add(new Human2(33, 180));
		hList.add(new Human2(20, 175));
		hList.add(new Human2(49, 162));
		hList.add(new Human2(50, 187));
		hList.add(new Human2(17, 150));
		
//		Collections.sort(hList, new Compare<Human2>());
		
		Collections.sort(hList, new Comparator<Human2>(){
			@Override
			public int compare(Human2 o1, Human2 o2) {
				if(o1.getAge() < o2.getAge()) return -1;
				if(o1.getAge() > o2.getAge()) return 1;
				return 0;
			}
		});
		
		for(int i=0; i<hList.size(); i++) {
			System.out.println("나이로 sort : " + hList.get(i));
		}
	}
}

















