package com.board.bdi.test;

import java.util.ArrayList;
import java.util.List;

class TestClass extends AbsClass{

	@Override
	public void test() {
		// TODO Auto-generated method stub
		
	}
	
}

public abstract class AbsClass {
	
	public abstract void test();
	
	public static void main(String[] args) {
		AbsClass ac = new TestClass();
		List<AbsClass> acList= new ArrayList<>();

		acList.add(new TestClass());
		acList.add(new TestClass());
		acList.add(new TestClass());
		acList.add(new TestClass());
		acList.add(new TestClass());
		acList.add(new TestClass());
		acList.add(new TestClass());
		acList.add(new TestClass());
		acList.add(new TestClass());
		acList.add(new TestClass());
		
		System.out.println(acList);
	}
}
