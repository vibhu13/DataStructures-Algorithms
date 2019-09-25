package com.interviewbit.vibhu.questions;

public class BinaryTree {
	
	class Node {
		Node left;
		Node right;
		int data;
		Node(int data){
			this.left = null;
			this.right = null;
		}
	}
	
	public Node sortedArrayToBST(int [] arr,int l,int h) {
		if(l>h)
			return null;
		else {
			int m = l + (h-l)/2;
			Node root = new Node(arr[m]);
			root.left = sortedArrayToBST(arr, l, m-1);
			root.right = sortedArrayToBST(arr, m+1, h);
			return root;
		}
	}

	public BinaryTree() {
		BinaryTree tree = new BinaryTree();
		int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7}; 
		Node root = tree.sortedArrayToBST(arr, 0, arr.length-1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
