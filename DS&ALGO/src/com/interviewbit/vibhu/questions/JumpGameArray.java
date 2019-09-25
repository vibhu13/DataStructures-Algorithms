package com.interviewbit.vibhu.questions;

enum Index {
    GOOD, BAD, UNKNOWN
}

public class JumpGameArray {
	
	int memo[];
	
	//Why h was required ??. how to handle l > h
//	public static int isJumpabele(int arr[],int l,int h) {
//		if(l>h)
//		return 0;
//		else if (l==h)
//			return 1;
//		else
//		{
//			if(arr[l]>0) {
//				int i = l;
//				int k = arr[l];
//				while((k--)!=0) {
//					i++;
//					
//					
//				}
//			}
//			else {
//				return 0;
//			}
//		}
//		
//	}
	//Backtrack Solution Recursion
	public static boolean canJump(int pos , int [] arr) {
		if(pos==arr.length-1)
			return true;
		else {
			int maxJumpFromCurrent = Math.min(arr[pos]+pos, arr.length-1);
			for(int nextPos = pos+1;nextPos<=maxJumpFromCurrent;nextPos++) {
				if(canJump(nextPos,arr))
					return true;
			}
		}
		return false;
	}
	
	//Memoised
		public  boolean canJumpMemo(int pos , int [] arr) {
			//if(pos==arr.length-1)
			//	return true;
			if(memo[pos]!=-1) {
				return memo[pos] == 1 ? true : false;
				
			}
			else {
				int maxJumpFromCurrent = Math.min(arr[pos]+pos, arr.length-1);
				for(int nextPos = pos+1;nextPos<=maxJumpFromCurrent;nextPos++) {
					if(canJumpMemo(nextPos,arr)) {
						memo[pos] = 1;
						return true;
					}
				}
			}
			memo[pos] = 0;
			return false;
		}
	
	
	public boolean canJumpMemoHelper(int arr[]) {
		memo = new int[arr.length];
		for(int i = 0; i<arr.length;i++) {
			memo[i] = -1;
		}
		memo[memo.length - 1] = 1;
		return canJumpMemo(0,arr);
	}

	public JumpGameArray() {
		
	}

	public static void main(String[] args) {
		int arr[] = new int[] {3,2,1,1,4};
		int len = arr.length;
		//System.out.println(isJumpabele(arr, 0, len-1));
		JumpGameArray obj = new JumpGameArray();
		if(obj.canJumpMemoHelper(arr))
		System.out.println("Yes");
		
		
			
		

	}

}
