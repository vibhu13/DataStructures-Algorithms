package com.ideserve.vibhu.questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Tree {
	
	private TreeNode root;

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.createSampleTree();
		//tree.printPreorder();
		//tree.rootToLeafPaths(tree.getRoot());
		tree.isCompleteTree(tree.getRoot());

	}
	
	/*
     * Create a sample tree
     *              1
     *      2               3
     * 4        5       6       7
     * 
     */
    public void createSampleTree() {
        root = new TreeNode(1, new TreeNode(2, null, null), new TreeNode(3, new TreeNode(6), new TreeNode(7)));
    }
    
    /*
     * Create a sample tree
     *              1
     *      2               3
     * 4        5       6       7
     * 
     */
    public void createSampleTree2() {
        root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
    }
    
    public void printPreorder() {
    	printPreorder(root);
    }
    
    private void printPreorder(TreeNode root) {
    	if(root==null)
    		return;
    	System.out.println(root.getData());
    	printPreorder(root.getLeft());
    	printPreorder(root.getRight());
    }
    
    public ArrayList<ArrayList<Integer>> rootToLeafPaths(TreeNode root){
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	if(root==null)
    	{
    		return result;
    	}
    	ArrayList<Integer> path = new ArrayList<>();
		getAllRootToLeafPaths(root,path,result);
		formatRootToLeaf(result);
		return result;
    	
    }

	private void getAllRootToLeafPaths(TreeNode root, ArrayList<Integer> path,ArrayList<ArrayList<Integer>> result) {
		path.add(root.getData());
		if(root.getLeft()==null && root.getRight()==null)
		{
			result.add(path);
			return;
		}
		getAllRootToLeafPaths(root.getLeft(), new ArrayList<Integer>(path), result);
		getAllRootToLeafPaths(root.getRight(), new ArrayList<Integer>(path), result);
		
		
	}
	
	private List<String> formatRootToLeaf(ArrayList<ArrayList<Integer>> result){
		List<String> response = new ArrayList<String>();
		for(ArrayList<Integer> tmp : result) {
			StringBuilder builder = new StringBuilder();
			for(Integer i : tmp) {
				builder.append(i);
				builder.append("->");
			}
			builder.deleteCharAt(builder.length()-1);
			builder.deleteCharAt(builder.length()-1);
			response.add(builder.toString());
		}
		return response;
	}
	
	public boolean isCompleteTree(TreeNode root) {
		if(root==null)
			return true;
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		boolean nonComplete = false;
		
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode currenNode = queue.remove();
			if(currenNode.getLeft()!=null) {
				if(nonComplete) {
					return false;
				}
				queue.add(currenNode.getLeft());
				//queue.add(currenNode.getRight());
			}
			else
				nonComplete = true;
			
			if(currenNode.getRight()!=null) {
				if(nonComplete) {
					return false;
				}
				queue.add(currenNode.getRight());
				
			}
			else
				nonComplete = true;
			
			if(currenNode.getLeft()==null&&currenNode.getRight()!=null) {
				
					return false;
				
				//nonComplete = true;
				//queue.add(currenNode.getLeft());
				
			}
			
			
		}
		return true;
		
	}

}
