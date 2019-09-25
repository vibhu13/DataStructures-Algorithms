package com.interviewbit.vibhu.questions;

import java.util.Arrays;

public class MinXorValuePair {

	public MinXorValuePair() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int [] arr = {9, 5, 3};
		Arrays.sort(arr);
		int ans = MinXorValuePair.minXorValuePair(arr);
		System.out.println(ans);

	}

	private static int minXorValuePair(int[] arr) {
		// TODO Auto-generated method stub
		int len = arr.length;
		int ans = Integer.MAX_VALUE;
		for(int i=0;i<len-1;i++) {
			ans = Math.min(ans,arr[i]^arr[i+1]);
		}
		return ans;
	}

}
