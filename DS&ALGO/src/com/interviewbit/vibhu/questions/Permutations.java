package com.interviewbit.vibhu.questions;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

	public Permutations() {
		// TODO Auto-generated constructor stub
	}
	
	public static List<List<Integer>> permute(int[] nums) {
	    List<List<Integer>> result = new ArrayList<>();
	    helper(0, nums, result);
	    return result;
	}
	 
	private static void helper(int start, int[] nums, List<List<Integer>> result){
	    if(start==nums.length-1){
	        ArrayList<Integer> list = new ArrayList<>();
	        for(int num: nums){
	            list.add(num);
	        }
	        result.add(list);
	        return;
	    }
	 
	    for(int i=start; i<nums.length; i++){
	        swap(nums, i, start);
	        helper(start+1, nums, result);
	        swap(nums, i, start);
	    }
	}
	 
	private static void swap(int[] nums, int i, int j){
	    int temp = nums[i];
	    nums[i] = nums[j];
	    nums[j] = temp;
	}

	public static void main(String[] args) {
		ArrayList<Integer> arrList =  new ArrayList<>(Arrays.asList(1,2,3));
		int[] arr = new int[arrList.size()];
		for(int i = 0; i<arrList.size();i++)
		{
			arr[i] = arrList.get(i);
		}
		//int arr[] = {1,2,3};
		
		System.out.println(permute(arr));

	}

}
