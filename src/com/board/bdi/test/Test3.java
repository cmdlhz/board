package com.board.bdi.test;

import java.util.Arrays;

public class Test3 {
	
	public static void main(String[] args) {
		int[] nums = new int[5];
		nums[0] = 12;
		nums[1] = 5;
		nums[2] = 1;
		nums[3] = 9;
		nums[4] = 2;
		// List는 Collections.sort();
		Arrays.sort(nums);
		System.out.println(nums);
		
		for(int i = 0; i<nums.length; i++) {
			System.out.println(nums[i]);
		}
	}
}