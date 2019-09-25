package com.interviewbit.vibhu.questions;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

	public PalindromePartitioning() {
	}
	
	public static ArrayList<ArrayList<String>> partition(String s) {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		  decomposeString(0, s, new ArrayList<String>(), result);
		  return result;
    }

	public static void decomposeString(int currentIndex, String s, ArrayList<String> arrayList, ArrayList<ArrayList<String>> decompositions) {
		if(currentIndex==s.length()) {
			decompositions.add(new ArrayList<String>(arrayList));
			return;
		}
		
		for(int i=currentIndex;i<s.length();i++) {
			if(isPalindrome(s, currentIndex, i)) {
				String tmp = s.substring(currentIndex, i+1);
				arrayList.add(tmp);
				decomposeString(i+1, s, arrayList, decompositions);
				arrayList.remove(arrayList.size()-1);
			}
		}
		
	}

	public static void main(String[] args) {
		String s ="aab";
		System.out.println(partition(s));

	}
	
	public static boolean isPalindrome(String s,int left,int right) {
		boolean isPalin = true;
		while(left<right) {
			char l = s.charAt(left);
			char r = s.charAt(right);
			if(l!=r)
			{
				isPalin = false;
				break;
			}
			left++;
			right--;
		}
		return isPalin;
	}

}
