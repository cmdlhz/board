package com.board.bdi.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Human{
	private String name;
	private int age;
	public Human(String string, int i) {
		// TODO Auto-generated constructor stub
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	
	public String toString() {
		return "Person [name = " + name + ", age = " + age + "]";
	}
}

class HumanComparator implements Comparator<Human>{

	@Override
	public int compare(Human o1, Human o2) {
		int fAge = o1.getAge();
		int lAge = o2.getAge();
		if(fAge < lAge) {
			return -1;
		} else if(fAge > lAge) {
			return 1;
		}
		return 0;
	}
}

public class ListSort2 {
	public static void main(String[] args) {
//		List<Integer> intList = new ArrayList<>();
//		intList.add(10);
//		intList.add(1);
//		intList.add(5);
//		Collections.sort(intList);
//		System.out.println(intList);
		
		List<Human> intList = new ArrayList<>();
		intList.add(new Human("James", 5));
		intList.add(new Human("Kyle", 12));
		intList.add(new Human("James", 1));
		
		Comparator hc = new HumanComparator();
		Collections.sort(intList, hc);
		System.out.println(intList);
	}
}
