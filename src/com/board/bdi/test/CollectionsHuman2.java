package com.board.bdi.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Human3{
	private int age;
	private int height;
	public Human3(int age, int height) {
		super();
		this.age = age;
		this.height = height;
	}
	@Override
	public String toString() {
		return "Human3 [age=" + age + ", height=" + height + "]";
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

public class CollectionsHuman2 {
	public static void main(String[] args) {
		List<Human3> hList = new ArrayList<>();
		hList.add(new Human3(33, 180));
		hList.add(new Human3(20, 175));
		hList.add(new Human3(49, 162));
		hList.add(new Human3(50, 187));
		hList.add(new Human3(17, 150));
		
		for(int i=0; i<hList.size(); i++) {
			// j+1 : 내 자신과 비교할 필요 없으므로
			for(int j=i+1; j< hList.size(); j++) {
				if(hList.get(i).getHeight() > hList.get(j).getHeight()) {
					Human3 tmp = hList.get(i);
					hList.set(i,hList.get(j));
					hList.set(j,tmp);
				}
			}
		}
		for(int i=0; i<hList.size(); i++) {
			System.out.println("키로 sort : " + hList.get(i));
		}
	}
}
