package Merge_Binary_Tree;

public class Solution617 {

	/**
	 * 
	 * 
Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.

You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.

Example 1:
Input: 
	Tree 1                     Tree 2                  
          1                         2                             
         / \                       / \                            
        3   2                     1   3                        
       /                           \   \                      
      5                             4   7                  
Output: 
Merged tree:
	     3
	    / \
	   4   5
	  / \   \ 
	 5   4   7
Note: The merging process must start from the root nodes of both trees.
	 */
	public static void main(String[] args) {
		
	}
	
public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    
if(t1==null && t2==null) {
return null;
}
else if(t2==null && t1!=null) {
	//System.out.println("Return null t2 is null");
	return t1;
}
else if(t2!=null && t1==null) {
	//System.out.println("Return null t1 is null");
    return t2;
}

TreeNode finalNode=new TreeNode(t1.val+t2.val);
												//System.out.println("Root "+finalNode.val);
finalNode.left=mergeTrees(t1.left,t2.left);
												    /* if(finalNode.left!=null)    
												System.out.println("left "+finalNode.left.val);
												    else{
												        System.out.println("Left is Null");
												    }*/
finalNode.right=mergeTrees(t1.right,t2.right);   
												  /*    if(finalNode.right!=null)  
												System.out.println("right "+finalNode.right.val);
												else{
												        System.out.println("Right is Null");
												    } */
return finalNode;

}

}
