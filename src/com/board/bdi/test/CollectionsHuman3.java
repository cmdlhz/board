package com.board.bdi.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Human4{
	private int age;
	private int height;
	public Human4(int age, int height) {
		super();
		this.age = age;
		this.height = height;
	}
	@Override
	public String toString() {
		return "Human4 [age=" + age + ", height=" + height + "]";
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

interface Com{
	public int compare2(Object o1, Object o2);
}

public class CollectionsHuman3 {
	public static void main(String[] args) {
		List<Human4> hList = new ArrayList<>();
		hList.add(new Human4(33, 180));
		hList.add(new Human4(20, 175));
		hList.add(new Human4(49, 162));
		hList.add(new Human4(50, 187));
		hList.add(new Human4(17, 150));
		
		Com c = new Com() {
			@Override
			public int compare2(Object o1, Object o2) {
				Human4 h1 = (Human4)o1;
				Human4 h2 = (Human4)o2;
				// 숫자를 바꾸면 descending이 됨
				if(h1.getAge() < h2.getAge()) return 1;
				if(h1.getAge() > h2.getAge()) return -1;
				return 0;
			}
		};
		
		for(int i=0; i<hList.size(); i++) {
			System.out.println("나이로 sort : " + hList.get(i));
		}
	}
}
