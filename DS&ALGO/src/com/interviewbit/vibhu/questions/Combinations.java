package com.interviewbit.vibhu.questions;

import java.util.ArrayList;

public class Combinations {

	public Combinations() {
		// TODO Auto-generated constructor stub
	}
	
	public static void getCombinationsUtil(int n,int k,ArrayList<ArrayList<Integer>> ans,ArrayList<Integer> temp,int start) {
		
		if(temp.size()>k)
			return;
		if(temp.size()==k&&(!ans.contains(temp)))
			ans.add(new ArrayList<Integer>(temp));
		
		for(int i=start;i<=n;i++) {
			if(temp.contains(i))
				continue;
			temp.add(i);
			getCombinationsUtil(n,k,ans,temp,i+1);
			temp.remove(temp.size()-1);
		}
		
	}
	
	public static ArrayList<ArrayList<Integer>> getCombinations(int n , int k){
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		if(n<k)
			return ans;
		else
		{
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			getCombinationsUtil(n,k,ans,tmp,1);
			return ans;
		}
		
	}

	public static void main(String[] args) {
		int n = 4;
		int k = 2;
		System.out.println(getCombinations(n,k));

	}

}
