package com.interviewbit.vibhu.questions;

public class WaysToDecode {

	public WaysToDecode() {
		// TODO Auto-generated constructor stub
	}
	
	
    public static int numDecodings(String A) {
        int length = A.length();
        char[] arr = A.toCharArray();
        //int result = solution(arr,length);
        int result = solutionOptimised(arr, length);
		return result;
    }

	private static int solution(char[] arr, int length) {
		// TODO Auto-generated method stub
		if(length==0||length==1)
			return 1;
		if(arr[0]=='0')   //for base condition "01123" should return 0  
	          return 0; 
		if(arr[0]=='0')
			return 0;
		int count = 0;
		if(arr[length-1]>'0')
			count= solution(arr,length-1);
		if(arr[length-2]>'1'||arr[length-2]=='2'&& arr[length-2]<'7')
			count+= solution(arr,length-2);
		return count;
			
	}
	
	private static int solutionOptimised(char[] arr, int length) {
		// TODO Auto-generated method stub
		int result[] = new int[length+1];
		result[0] = result[1] = 1;

		for(int i=2;i<=length;i++) {
			if(arr[i-1]>'0')
				result[i] = result[i-1];
			if(arr[i-2]=='1'||arr[i-2]=='2'&& arr[i-1]<'7')
				result[i] = result[i] + result[i-2];
		}
		
		return result[length];
			
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "10";
		int ans = numDecodings(test);
		System.out.println(ans);

	}

}
