package Reverse_Linked_List;

import java.util.List;
import java.util.Stack;

public class Solution206 {

	/**
	 * 
	 */
	public static void main(String[] args) {
		ListNode head=new ListNode(1);
		head.next=new ListNode(2);
		head.next.next=new ListNode(3);
		head.next.next.next=new ListNode(4);
		head.next.next.next.next=new ListNode(5);
		//head.next=new ListNode(2);

		
		
		ListNode finalNode=reverseListRecursive(head,null);
		
		while(finalNode!=null){
		System.out.println(finalNode.val);
		finalNode=finalNode.next;
	}
	}
	
	/**
	 * Iterative approach- writtenBy Someone else
	 * Does not use any extra memory.
	 */
	  public static ListNode reverseList1(ListNode head) {
	      
		  ListNode newHead=null;
		  while(head!=null){
			  ListNode nextNode=head.next;
			  head.next=newHead;
			  newHead=head;
			  head=nextNode;
		  }
		  return newHead;
	        
	    }
	
	/**
	 * Iterative approach
	 */
	  public static ListNode reverseList(ListNode head) {
	      
		  if(head==null) return null;
          Stack<ListNode> ob=new Stack<ListNode>();
	        while(head!=null){
	        	ob.add(head);
	        	head=head.next;	
	        }
	        
	        ListNode reversed=ob.pop();
	        ListNode returnList=reversed;
	        while(!ob.empty()){
	        	reversed.next=ob.pop();
	        	reversed=reversed.next;
	        	
	        }
	        reversed.next=null; //---> This is important else it will go to an infinite loop
	        return returnList;
	        
	    }
	  
		
	  
	  /**
		 * Recursive approach
		 */
	  
	  public static ListNode reverseListRecursive(ListNode head,ListNode newHead){
	       if(head==null) return newHead;
	       ListNode nextNode=head.next;
	       head.next=newHead;
	       return reverseListRecursive(nextNode,head);
	   }
}
