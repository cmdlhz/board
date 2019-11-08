package com.board.bdi.test;

interface Polygon{
	public void display();
}

class Demo{
	public void createClass() {
		Polygon p1 = new Polygon() {
			public void display() {
				System.out.println("Inside an anonymous class.");
			}
		};
		p1.display();
	}
}

public class AnonymousClass {
	public static void main(String[] args) {
		Demo test = new Demo();
		test.createClass();
	}
}
