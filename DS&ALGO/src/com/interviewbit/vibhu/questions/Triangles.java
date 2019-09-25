package com.interviewbit.vibhu.questions;

public class Triangles {

	private int data;
	
	public Triangles() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ans = 0;
	    int tmpRoot;
	    double s,area,tempArea;
	    int a, b, c;
	    a=6;
	    int p = 21;
	    area = 20;
	    s = (double)p/2;
	   
	    for (;2*a < p; a++) {
	        for (b = 1; a+b < p; b++)
	            if ((p-2*a) > 0 && (p-2*b) > 0 && (2*a+2*b-p) > 0) {
	                c = (p - (a + b));
	                //if(a<=b && b<=c){
	                    tempArea = Math.sqrt(s*(s-a)*(s-b)*(s-c));
	                    if(tempArea>=area)
	                    ans++;
	                //}
	            }
	    }
		System.out.println(ans);
		
		

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + data;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Triangles other = (Triangles) obj;
		if (data != other.data)
			return false;
		return true;
	}
	
	    	
	    
	
	
	
}
