package com.interviewbit.vibhu.questions;

import java.lang.reflect.Array;
import java.util.Arrays;

public class NobleInteger {

	public NobleInteger() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int arr[] = new int[]{10,20,3,40,2};
		System.out.println(isNoble(arr));

	}

	public static int isNoble(int[] arr) {
		int isNoble = -1;
		int len = arr.length;
		Arrays.parallelSort(arr);
		for(int i =0; i<len-1;i++)
		{
			if(arr[i]==arr[i+1])
				continue;
			if(arr[i]==len-i-1) {
				isNoble = arr[i];
				break;
			}
		}
		if(arr[len-1]==0)
			isNoble = 0;
		
		return isNoble;
	}

}
