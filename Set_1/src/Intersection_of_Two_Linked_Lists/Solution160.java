package Intersection_of_Two_Linked_Lists;

public class Solution160 {

	/**
	 * 
	 * Intersection of Two Linked Lists
	 * Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a=new ListNode(1);
		a.next=new ListNode(2);
		ListNode b=a.next;
		//ListNode b=new ListNode(4);
		//b.next=a.next;
		System.out.println(getIntersectionNode(a,b).val);
		
		
		//System.out.println(getIntersectionNode1(b,a).val);
	}
	
	/*
	 * Very Good Solution by another person:
	 * 1) Scan both lists
	 * 2) For each list once it reaches the end, continue scanning the other list
	 * 3) Once the two runner equal to each other, return the position
	 * Modification of Circular list
	 *  */
	 
	 
	public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
		if( null==headA || null==headB )
			return null;
		
		ListNode curA = headA, curB = headB;
		while( curA!=curB){
	/**		System.out.println("Not equal ");
			if(curA==null && curB!=null){
				System.out.println("curA NULL");
				System.out.println("curB "+curB.val);
			}
			else if(curB==null && curA!=null){
				System.out.println("curA "+curA.val);
				System.out.println("curB  NULL");
			}
			else if(curB==null && curA==null){
				System.out.println("curA NULL");
				System.out.println("curB  NULL");
			}
			else{
				
			System.out.println("curA "+curA.val);
			System.out.println("curB "+curB.val);
			}
		*/
			curA = curA==null?headB:curA.next;
			curB = curB==null?headA:curB.next;
		}
		//System.out.println("curA "+curA.val);
		return curA;
    }
	
	
	/*
	 * My solution Based on CTCI
	 * 1) If the last nodes are the same the there is an intersection, we then continue else return NULL
	 * 2) Make the longer node the same size as the shorter node by moving forward;
	 * 3) Then we traverse both the nodes and find the intersection
	 */
	 
	 
	
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	        
      if(headA == null || headB==null) return null;  
      
      Result rA=getTail(headA);
      Result rB=getTail(headB);
      
      if(rA.node!=rB.node){
    	  return null; // Tails are not the same
      }

      
     ListNode shorter=rA.size>rB.size?headB:headA;
     ListNode longer=moveNodeForward(rA.size>rB.size?headA:headB,Math.abs(rA.size-rB.size));

       return getNode(longer,shorter); // or you can use a while loop
       									/* while (longer != shorter){
											longer=longer.next;
											shorter=shorter.next;
											}
       									 
       									 */
      
  }
	
	
	
	public static Result getTail(ListNode node) {
		int size=0;
        while(node.next!=null){
        	size++;
        	node=node.next;
        }
        return new Result(node,size+1);
	}
	
	public static ListNode moveNodeForward(ListNode node,int diff){
		while(diff>0){
			node=node.next;
			diff--;
		}
		return node;
	}
	
	
	public static ListNode getNode(ListNode headA, ListNode headB) {
	        
	        if(headA == null || headB==null) return null;
	        if(headA==headB) return headA;  
	        else{
	            return getNode(headA.next,headB.next);
	        }
	        
	    }

}
