package com.interviewbit.vibhu.questions;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {
	
	public int capacity;
	public  Deque<Integer> dq = new LinkedList<Integer>();
	public  Map<Integer,Integer> pageRef = new HashMap<Integer, Integer>();

	public LRUCache(int capacity) {
		this.capacity = capacity;
	}
	
	public int get(int key) {
		int value = -1;
		if(pageRef.containsKey(key)) {
			value = pageRef.get(key);
			set(key, value);
		}
		return value;
	}
	
	void set(int key,int value) {
		
		if(pageRef.containsKey(key)) {
			int result = pageRef.get(key);
			//Remove And Add to First Position
			dq.remove(key);
			dq.addFirst(key);
			pageRef.put(key, value);
		}
		else {
			//Not Present insert case
			if(dq.size()==capacity) {
				int toDelete = dq.removeLast();
				pageRef.remove(toDelete);
				pageRef.put(key, value);
				dq.addFirst(key);
			}
			else
			{
				dq.addFirst(key);
				pageRef.put(key, value);
			}
		}
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(1);
		
		cache.set(2,1);
		System.out.println(cache.get(2));
		cache.set(3,2);
		cache.get(2);
		cache.get(3);
		System.out.println(cache.dq);
		


	}

	
}
