package com.ideserve.vibhu.questions;

public class MinimumJump {

	public MinimumJump() {
		// TODO Auto-generated constructor stub
	}

	//Brute Force
	static int minJumps(int arr[],int l,int h) {
		if(l==h)
			return 0;
		else if(arr[0]==0)
			return Integer.MAX_VALUE;
		else
		{
			int min = Integer.MAX_VALUE;
			int maxJumpFromCurrent = Math.min(arr[l]+l, arr.length-1);
			for(int nextPos = l+1;nextPos<=maxJumpFromCurrent;nextPos++) {
				int jumps = minJumps(arr, nextPos, h); 
	            if(jumps != Integer.MAX_VALUE && jumps + 1 < min) 
	              min = jumps + 1; 
			}
			return min;
		}
	}
	
	static int minJumpsOptimised(int arr[],  int n) 
	{  
		// jumps[0] will 
		// hold the result 
		int[] jumps = new int[n];  
		int min; 

		// Minimum number of jumps  
		// needed to reach last  
		// element from last elements  
		// itself is always 0 
		jumps[n - 1] = 0; 


		// Start from the second  
		// element, move from right 
		// to left and construct the  
		// jumps[] array where jumps[i]  
		// represents minimum number of 
		// jumps needed to reach arr[m-1] 
		// from arr[i] 
		for (int i = n - 2; i >= 0; i--) 
		{ 
			// If arr[i] is 0 then arr[n-1]  
			// can't be reached from here 
			if (arr[i] == 0) 
				jumps[i] = Integer.MAX_VALUE; 

			// If we can direcly reach to  
			// the end point from here then 
			// jumps[i] is 1 
			else if (arr[i] >= n - i - 1) 
				jumps[i] = 1;  
			else
			{  
    // initialize min value 
				min = Integer.MAX_VALUE;  

    // following loop checks  
    // with all reachable points  
    // and takes the minimum 
    for (int j = i + 1; j < n &&  
             j <= arr[i] + i; j++) 
    { 
        if (min > jumps[j]) 
            min = jumps[j]; 
    }  
    	// Handle overflow  
    	if (min != Integer.MAX_VALUE) 
    		jumps[i] = min + 1; 
    	else
        jumps[i] = min; // or Integer.MAX_VALUE 
			} 
} 

return jumps[0]; 
} 
	
	
	public static void main(String[] args) {
		int arr[] = new int[] {1, 3, 6, 3, 2, 3, 6, 8, 9, 5};
		int n = arr.length; 
        System.out.print("Minimum number of jumps to reach end is " 
                          + minJumpsOptimised(arr, n)); 

	}

}
