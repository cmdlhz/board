package com.board.bdi.test;

public class Test3Teacher {
	public static void main(String[] args) {
		int[] nums = new int[5];
		nums[0] = 12;
		nums[1] = 5;
		nums[2] = 1;
		nums[3] = 9;
		nums[4] = 2;

		for(int i=0; i<nums.length; i++) {
			for(int j=i+1; j<nums.length; j++) {
				if(nums[i] < nums[j]) {
					int tmp = nums[i];
					nums[i] = nums[j];
					nums[j] = tmp;
				}
			}
		}
		for(int i = 0; i<nums.length; i++) {
			System.out.println(nums[i]);
		}
	}
}