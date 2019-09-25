package com.interviewbit.vibhu.questions;

import java.util.ArrayList;

public class PascalTriangle {

	public PascalTriangle() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<ArrayList<Integer>> pascalTriangle(int A) {
		ArrayList<Integer> temp= new ArrayList<>();
		temp.add(1);
		ArrayList<ArrayList<Integer>> resultantList = new ArrayList<ArrayList<Integer>>();
		resultantList.add(temp);
		if(A==1)
		{
			return resultantList;
		}
		else
		{
			for(int i=1;i<A;i++) {
				ArrayList<Integer> ithPascalRow= new ArrayList<>();
				for(int j=0;j<=i;j++) {
					int lastRowSum = 0;
					if(j-1>=0)
						lastRowSum += resultantList.get(i-1).get(j-1);
					if(j<=i-1)
						lastRowSum += resultantList.get(i-1).get(j);
					ithPascalRow.add(lastRowSum);
				}
				resultantList.add(ithPascalRow);
			}
		}
		return resultantList;

	}

	public static void main(String[] args) {
		PascalTriangle pascalTriangle = new PascalTriangle();
		ArrayList<ArrayList<Integer>> result = pascalTriangle.pascalTriangle(5);
		System.out.println(result);
		

	}

}
