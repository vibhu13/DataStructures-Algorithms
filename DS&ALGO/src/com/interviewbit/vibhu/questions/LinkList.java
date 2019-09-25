package com.interviewbit.vibhu.questions;

import java.util.List;

public class LinkList {
	
	ListNode head = null;

	public LinkList() {
		// TODO Auto-generated constructor stub
	}
	
	void push(int data) {
		ListNode temp = new ListNode(data);
		temp.next = head;
		head = temp;
		
	}
	
	static void printList(ListNode head) {
		while(head!=null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}
	
	//Smart Choice to get Middle instead of first counting the number of nodes...
	public static  ListNode getMiddle(ListNode head) 
    { 
        if (head == null) 
            return head; 
        ListNode slow = head, fast = head; 
        while (fast.next != null && fast.next.next != null) { 
            slow = slow.next; 
            fast = fast.next.next; 
        } 
        return slow; 
    } 
	
	
	ListNode mergeSort(ListNode head) {
		if(head==null||head.next==null)
		return head;
		else {
			ListNode mid = getMiddle(head);
			ListNode midNext = mid.next;
			mid.next = null;
			ListNode left = mergeSort(head);
			ListNode right = mergeSort(midNext);
			ListNode  result = sortSubRoutine(left,right);
			return result;
		}
		
	}

	public ListNode sortSubRoutine(ListNode left, ListNode right) {
		ListNode result = null;
		if(left==null)
			return right;
		if(right==null)
			return left;
		if(left.val<=right.val) {
			result = left;
			//Bad Approach using system recursion  stack memory. Use iterative approach here in sub routine
			result.next = sortSubRoutine(left.next, right);
		}
		else {
			result = right;
			result.next = sortSubRoutine(left, right.next);
		}
		
		return result;
	}
	
	public static ListNode reverseSimple(ListNode head) 
    { 
		ListNode current = head; 
		ListNode next = null; 
		ListNode prev = null; 
       while (current != null)  
       { 
           next = current.next; 
           current.next = prev; 
           prev = current; 
           current = next; 
       } 
         return prev; 
    }
	
	
	public ListNode reverse(ListNode head, int k) 
    { 
		ListNode current = head; 
		ListNode next = null; 
		ListNode prev = null; 
         
       int count = 0; 
  
       /* Reverse first k nodes of linked list */
       while (count < k && current != null)  
       { 
           next = current.next; 
           current.next = prev; 
           prev = current; 
           current = next; 
           count++; 
       } 

       if (next != null)  
          head.next = reverse(next, k); 
         return prev; 
    }
	
	private static ListNode StartOfLoop(ListNode head,ListNode meetingPoint) {
		ListNode start = head;
		ListNode merge = meetingPoint;
		while(start!=merge) {
			start=start.next;
			merge= merge.next;
			
		}
		return merge;
		
	}
	
	public static ListNode reorderList(ListNode head) {
		if(head==null||head.next==null)
		return head;
		else {
			ListNode mid = getMiddle(head);
			ListNode reversedHalf = reverseSimple(mid.next);
			mid.next=null;
			ListNode current= head;
			while(current!=null&&reversedHalf!=null) {
				ListNode t1 = current.next;
				ListNode t2 = reversedHalf.next;
				current.next = reversedHalf;
				reversedHalf.next = t1;
				current = t1;
				reversedHalf = t2;
			}
			//System.out.println();
			printList(head);
			return head;
		}
		
	}

	public static void main(String[] args) {
		LinkList li = new LinkList(); 
        /* created. The list shall be a: 2->3->20->5->10->15 
        */
        li.push(15); 
        li.push(10); 
        li.push(5); 
        li.push(20); 
        li.push(3); 
        li.push(2); 
  
        // Apply merge Sort 
        li.head = li.mergeSort(li.head); 
        System.out.print("\n Sorted Linked List is: \n"); 
        li.printList(li.head); 
        System.out.print("\n Reordered Linked List is: \n");
        reorderList(li.head);
        /*li.head = li.reverse(li.head,2); 
        System.out.print("\n Reverese Linked List is: \n");
        li.printList(li.head);
        
        
        LinkList llist = new LinkList(); 
        
        llist.push(20); 
        llist.push(4); 
        llist.push(15); 
        llist.push(10); 
  
        
        llist.head.next.next.next.next = llist.head; 
        ListNode startPoint = helperCycle(llist);
        System.out.print("\n Loop Starting At "+ startPoint.val + ": \n");
        */
  
        

	}
	
	private static ListNode helperCycle(LinkList llist) {
		ListNode meetingPoint = llist.detectLoop(llist.head); 
        if(meetingPoint!=null) {
        	System.out.print("\n Loop Detected: \n");
        	ListNode start = StartOfLoop(llist.head,meetingPoint);
        	return start;
        }
        else
        	return null;
	}

	private ListNode detectLoop(ListNode head) {
		if(head==null) {
			return head;
		}
		ListNode slow = head;
		ListNode fast = head;
		while(fast.next!=null)
		{
			if(slow==fast)
				return slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		return null;
	}

}
