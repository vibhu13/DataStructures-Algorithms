package com.interviewbit.vibhu.questions;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum {

	public CombinationSum() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int arr[] = {2,3,6,7};
		int target = 7;
		Arrays.sort(arr);
		System.out.println(getAllPossibleCombinations(arr,target));

	}

	public static ArrayList<ArrayList<Integer>> getAllPossibleCombinations(int[] arr, int target) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		int startIndex = 0;
		getAllPossibleCombinationsUtil(arr,target,ans,temp,startIndex);
		return ans;
		
	}

	private static void getAllPossibleCombinationsUtil(int[] arr, int target, ArrayList<ArrayList<Integer>> ans,
			ArrayList<Integer> temp,int startIndex) {
		if(target==0 && (!ans.contains(temp)))
		{
			ans.add(new ArrayList<Integer>(temp));
			return;
		}
		if(target<0)
			return;
		for(int i=startIndex;i<arr.length;i++) {
			temp.contains(arr[i]);
			temp.add(arr[i]);
			getAllPossibleCombinationsUtil(arr,target-arr[i],ans,temp,i);
			temp.remove(temp.size()-1);
		}
		
	}

}
