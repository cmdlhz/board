package com.board.bdi.test;

import java.util.ArrayList;
import java.util.List;

//class Human{
//	private String name;
//	private int age;
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setAge(int age) {
//		this.age = age;
//	}
//	public int getAge() {
//		return age;
//	}
//	
//	public String toString() {
//		return "Person [name = " + name + ", age = " + age + "]";
//	}
//
//}

interface TestInter{
	void listTest();
}

//class TestClass implements TestInter{
//	public void listTest() {
//		System.out.println("a");
//	}
//}

public class ListSort {
	public static void main(String[] args) {
//		TestInter it = new TestClass();
		
		/* 무명 Class*/
//		TestInter it = new TestInter() {
//			public void listTest() {
//				System.out.println("a");
//			}
//		};
		
		List<TestInter> tiList = new ArrayList<>();
		tiList.add(new TestInter() {
			public void listTest() {
				System.out.println("a");
			}
		});
	}
}
