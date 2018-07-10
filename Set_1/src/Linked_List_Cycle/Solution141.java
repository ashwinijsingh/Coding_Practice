package Linked_List_Cycle;

import java.util.HashSet;
import java.util.Set;

public class Solution141 {

	/**
	 * Linked List Cycle:
	 * Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?
	 */
	public static void main(String[] args) {
		

	}

	/*
	 * Approach 1: Hash Table
	 * To detect if a list is cyclic, we can check whether a node had been visited before. A natural way is to use a hash table.
	 * Time complexity : O(n)
	 * Space complexity: O(n).
	 * 
	 */
	public boolean hasCycle1(ListNode head) {
	    if (head==null || head.next ==null) return false;
	        Set<ListNode> seen=new HashSet<ListNode>();
	        while(head!=null){
	        	if(seen.contains(head)){
	        		return true;
	        	}
	        	else{
	        		seen.add(head);
	        	}
	        	head=head.next;
	          
	            }     
	        return false;
	    }
	
	/*
	 * Approach 2: Two Pointers
	 * Time complexity : O(n)
	 * Space complexity : O(1). We only use two nodes (slow and fast) so the space complexity is O(1)O(1).
	 */

	public boolean hasCycle(ListNode head) {
	    if (head==null || head.next ==null) return false;
	        ListNode temp=head.next;
	        while(temp!=head){
	            if(temp==null || temp.next == null)
	             return false;
	             temp=temp.next.next;
	             head=head.next;
	            }     
	        return true;
	    }
	
	
	
}
