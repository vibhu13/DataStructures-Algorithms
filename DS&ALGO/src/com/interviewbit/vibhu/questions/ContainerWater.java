package com.interviewbit.vibhu.questions;

public class ContainerWater {

	public ContainerWater() {
		// TODO Auto-generated constructor stub
	}

	public static int maxWater(int [] height) {
		int maxWater = Integer.MIN_VALUE;
		int i = 0;
		int j = height.length-1;
		while(i<j) {
			int min = Math.min(height[i], height[j]);
			
			maxWater = Math.max(maxWater, min *(j-1));
			if(height[i]<height[j])
				i++;
			else
				j--;
		}
		return maxWater;
	}
	
	public static void main(String[] args) {
		
		int [] test = {1, 5, 4, 3};
		System.out.println(maxWater(test));

	}

}
