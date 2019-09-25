package com.interviewbit.vibhu.questions;

import java.util.ArrayList;
import java.util.List;

public class ConvertToBST {

	public ConvertToBST() {
		// TODO Auto-generated constructor stub
	}

	public static TreeNode helper(List<Integer> sortedArr, int l, int h) {
		if (l <= h) {
			int m = l + (h - l) / 2;
			TreeNode root = new TreeNode(sortedArr.get(m));
			root.left = helper(sortedArr, l, m - 1);
			root.right = helper(sortedArr, m + 1, h);
			return root;
		} else
			return null;
	}

	public static void main(String[] args) {
		ConvertToBST obj = new ConvertToBST();
		List<Integer> sortedArr = new ArrayList<Integer>();
		sortedArr.add(1);
		sortedArr.add(2);
		sortedArr.add(3);
		obj.helper(sortedArr, 0, sortedArr.size() - 1);
		TreeNode root = helper(sortedArr, 0, sortedArr.size() - 1);
		System.out.println(root.val);
	}

}
