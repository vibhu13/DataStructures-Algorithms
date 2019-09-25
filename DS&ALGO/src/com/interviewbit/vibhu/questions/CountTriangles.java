package com.interviewbit.vibhu.questions;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CountTriangles {

	public CountTriangles() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] sidesArr = {4, 3, 5, 7, 6}; 
	    System.out.println(CountTriangles(sidesArr)); 

	}

	private static int CountTriangles(int[] a) {
		// TODO Auto-generated method stub
		Arrays.sort(a);
		int ans = 0;
		for(int i=a.length-1;i>=1;i--) {
			int l = 0;
			int r = i-1;
			while(l<r) {
			if(a[l]+a[r]>a[i])
			{
				ans+=r-l;
				r--;
			}
			else
				l++;
			}
		}
		return ans;
		
	}

}
