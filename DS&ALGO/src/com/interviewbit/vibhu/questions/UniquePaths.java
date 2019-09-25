package com.interviewbit.vibhu.questions;

public class UniquePaths {

	public UniquePaths() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {	
	     //int mat[][] = { { 0, 0, 0 },  
	     //                { 0, 1, 0 },
	     //                { 0, 0, 0}};
		int mat[][] = { { 0, 1,}};
	    		 	   
	    int rows = mat.length;
	    int cols = mat[0].length;
	    int count  = uniquePaths(mat, rows, cols); 
	    System.out.println(count);

	}

	private static int uniquePaths(int[][] mat, int m, int n) {
		int[][] dp = new int[m][n];
		if(mat[0][0] == 0)
			dp[0][0] = 1;
		
		for(int i =1;i<n;i++)
			if(mat[0][i] == 0)
			dp[0][i] = dp[0][i-1];
		
		for(int i =1;i<m;i++)
			if(mat[i][0] == 0)
			dp[i][0] = dp[i-1][0];
		
		for(int i=1;i<m;i++) {
			for(int j=1;j<n;j++) {
				if(mat[i][j] == 1)
					dp[i][j] = 0;
				else
					dp[i][j] = dp[i][j-1] + dp[i-1][j];
			}
		}
		return dp[m-1][n-1];
	}

}
