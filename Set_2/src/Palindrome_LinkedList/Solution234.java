package Palindrome_LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution234 {

	/**
	 * Palindrome Linked List
	 * 
	 * Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true
Follow up:
Could you do it in O(n) time and O(1) space?
	 */
	public static void main(String[] args) {
	
ListNode head=new ListNode(1);
head.next=new ListNode(2);
//head.next.next=new ListNode(1);
System.out.println("My Solution :");

System.out.println(isPalindrome(head));

System.out.println("Solution 1");

System.out.println(isPalindrome1(head));

System.out.println("Solution 2");

System.out.println(isPalindrome2(head));

System.out.println("Solution 3");

System.out.println(isPalindrome3(head,lenghtOfLinkedList(head)).result);
	}
	
	
	
	/*
	 * Solution 3:
	 * Using Result class to store the value and boolean balue
	 */
	public static Result isPalindrome3(ListNode head,int length){
		if(head==null ||length==0){
			return new Result(head,true);
		}
		else if(length==1){
			return new Result(head.next,true);
		}
		Result res=isPalindrome3(head.next,length-2);
		
		if(!res.result ||res==null) return res;
		
		res.result= (head.val==res.node.val);
		res.node=res.node.next;
		return res;
		
	}
	public static int lenghtOfLinkedList(ListNode n){
		int size=0;
		while(n!=null){
			size++;
			n=n.next;
		}
		return size;
	}
	
	/*
	 * Solution 2 CTCI (Chapter 2 Solution 6): 
	 * Slow and Fast pointer. (90.10%)
	 * 
	 */
	public static boolean isPalindrome2(ListNode head) {
		if(head==null) return true;
		ListNode slow=head;
		ListNode fast=head;
		Stack<ListNode> st=new Stack<ListNode>();
		while(fast!=null && fast.next !=null){
			st.add(slow);
			slow=slow.next;
			fast=fast.next.next;
		}
		if(fast!=null){
			slow=slow.next;
		}
		
		while(slow!=null){
			if(slow.val!=st.pop().val) return false;
			slow=slow.next;
		}
		
		return true;
		
		
	}
	
	
	
	
	/*
	 * Solution 1 CTCI (Chapter 2 Solution 6): 
	 * Reverse and Clone then compare
	 * 
	 * Better solution that previous (90.10%)
	 */
	public static boolean isPalindrome1(ListNode head) {
		if(head==null) return true;
		ListNode reverse=reverseAndClone(head); 
	    return isEqual(head,reverse);
	    }
	
	public static ListNode reverseAndClone(ListNode node){
		ListNode head=null;
		while(node!=null){
			ListNode n=new ListNode(node.val);
			n.next=head;
			head=n;
			node=node.next;
		}
		
		return head;
	}
	
	public static boolean isEqual(ListNode head,ListNode reverse){
		while(head!=null){
			if(head.val!=reverse.val) return false;
			head=head.next;
			reverse=reverse.next;
		}
		return true;
	}
	
	/*
	 * First Solution: Using stacks (39.58%)
	 * 
	 */
	public static boolean isPalindrome(ListNode head) {
	if(head==null) return true;
	
	Stack<ListNode> list=new Stack<ListNode>();
	ListNode temp=head;
     while(head!=null){
    	 	
    	 	list.add(head);
    	 	//System.out.println(list.peek().val);
            head=head.next;  
        }
     
     while(temp!=null){ 
    	 if(temp.val!=list.pop().val) return false;
    	 temp=temp.next;
     }
     
     return true;
    }

}
