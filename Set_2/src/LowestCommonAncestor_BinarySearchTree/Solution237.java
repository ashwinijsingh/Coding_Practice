package LowestCommonAncestor_BinarySearchTree;

public class Solution237 {

	/**
	 * Lowest Common Ancestor of a Binary Search Tree
	 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]

        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5
Example 1:

Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.
Example 2:

Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
Output: 2
Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself 
             according to the LCA definition.
Note:

All of the nodes' values will be unique.
p and q are different and both values will exist in the BST.
	 */
	public static void main(String[] args) {
		TreeNode root=new TreeNode(6);
		root.left=new TreeNode(2);
		root.right=new TreeNode(8);
		
		root.left.left=new TreeNode(0);
		root.left.right=new TreeNode(4);
		
		root.left.right.left=new TreeNode(3);
		root.left.right.right=new TreeNode(5);
		
		root.right.left=new TreeNode(7);
		root.right.right=new TreeNode(9);
		
		System.out.println(lowestCommonAncestor(root,root.left.right,root.left).val);
		
		System.out.println("Solution 1");
		
		
		root.left.parent=root;
		root.right.parent=root;
		
		root.left.left.parent=root.left;
		root.left.right.parent=root.left;
		
		root.left.right.left.parent=root.left.right;
		root.left.right.right.parent=root.left.right;
		
		root.right.left.parent=root.right;
		root.right.right.parent=root.right;
		
		System.out.println(lowestCommonAncestor1(root,root.left,root.left.right).val);
		
		System.out.println("Solution 2");
		
		System.out.println(lowestCommonAncestor2(root,root.left,root.left.right).val);
		
		System.out.println("Solution 3");
		
		System.out.println(lowestCommonAncestor3(root,root.left,root.left.right).val);
		

		System.out.println("Solution 4");
		
		System.out.println(lowestCommonAncestor4(root,root.left,root.left.right).val);
		
		System.out.println("Solution 5");
		
		System.out.println(lowestCommonAncestor5(root,root.left,root.left.right).val);
		
		
	}
	
	/*
	 * My Solution
	 */
	
	 public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		  if (root==p || root==q) return root;
		  else  if((p.val<root.val && q.val>root.val) || (p.val>root.val && q.val<root.val)) return root;
	      return (p.val<root.val && q.val<root.val)?lowestCommonAncestor(root.left,p,q):lowestCommonAncestor(root.right,p,q);
	    }
	 /*
	  * CTCI Solution 1 (Chapter 5 Solution 8) :
	  * With links to Parents: Similar to approach of linkedlists
	  * 
	  */
	 public static TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
		 int delta=depth(p)-depth(q);
		 TreeNode first=delta>0?p:q; //longer list
		 TreeNode second=delta>0?q:p; //shorter list
		 first=goUpBy(first,Math.abs(delta));
		 
		 while(first!=second && first!=null && second !=null){
			 first=first.parent;
			 second=second.parent;
		 }
		 
		 return first==null || second ==null ?null:first;
	 }
	 
	 public static int depth(TreeNode node){
			int depth=0;
			//System.out.println("NODE: "+node.val);
			while(node!=null){
			//System.out.println("parent "+node.val);
			node=node.parent;
			depth++;
		}
			//System.out.println("depth is : "+depth);
			return depth;
		}
	
	 public static TreeNode goUpBy(TreeNode node,int delta){
			while(delta>0){
				node=node.parent;
				delta--;
			}
			return node;
		}
	 
	 
	 
		/*
		 * CTCI Solution 2:
		 * Link to parents (better worst case)
		 * -> O(t)->size of the subtree with the first common ancestor
		 * -> O(n)-> number of nodes in the tree
		 */
	 public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
		 
		 if(!covers(root,p)||!covers(root,q)){ //check if the nodes are covered in the tree
				return null;
			}
			else if(covers(p,q)){ 				  //check if the p is a parent of q
				return p;
				
			}
			else if(covers(q,p)){				 //check if q is a parent of p
				return q;
			}
		 
			TreeNode sibling=getSibling(p);     
			TreeNode parent=p.parent;
			while(!covers(sibling,q)){          //check if the sibling covers the node. Keep moving upwards.
				sibling=getSibling(parent);
				parent=parent.parent;
			}
			return parent;
		 
	 }
	 
		public static boolean covers(TreeNode root,TreeNode node){
			if(root==null) return false;
			if(root==node) return true;
			return covers(root.left,node)|| covers(root.right,node);
		}
		
		public static TreeNode getSibling(TreeNode node){
			if(node==null){
				return null;
			}
			TreeNode parent=node.parent;
			return parent.left==node? parent.right:parent.left;
		}
		
		/*
		 * Without link to parents:
		 * 1) If both the nodes or the left side of the root -> recurse through the left side
		 * 2) If both the nodes are on the right side of the root -> recurse through the right side.
		 * 3) If both the nodes are present on opposite sides of the root then that will be the common ancestor.
		 * 
		 * Problem:
		 * 1) We keep traversing left and right of the root node over and over again. Instead we should just traverse through the nodes once
		 */
		
		public static TreeNode lowestCommonAncestor3(TreeNode root,TreeNode p,TreeNode q){
			if(!covers(root,p)||!covers(root,q)){
				System.out.println("One of the nodes is not covered");
				return null;
			}
			return ancestorHelper( root,p, q);
			
		}
		

		public static TreeNode ancestorHelper(TreeNode root,TreeNode p,TreeNode q){
			if(root==null||p==root||q==root) //When root one of the nodes is a ancestor/parent of the other //Null condition : not sure, as we will never reach this point
			{	System.out.println("One of then is a parent/ancestor of the other");
				return root;
			}
			boolean pIsOnLeft=covers(root.left,p); //if p is on left
			boolean qIsOnLeft=covers(root.left,q); //if q is on right
			
			if(pIsOnLeft!=qIsOnLeft){ //both are on opposite sides
				return root;
			}
			
			TreeNode child=pIsOnLeft?root.left:root.right;
			return ancestorHelper(child,p,q);
		}
		
		
		
		/*
		 * Solution 4:
		 * 1) Returns p, if roots subtree includes p and not q
		 * 2) Returns q, if roots subtree includes q and not p
		 * 3) Returns null, if p and q are not in roots subtree
		 * 4) Returns the common ancestor of p & q   
		 * 
		 * Problem:
		 * This program cannot differentiate between two cases:
		 * case 1: returns p when q is a sub child of p
		 * case 2: return p when q is present in the tree but q is not present in the tree 
		 * 
		 */
		
		public static TreeNode lowestCommonAncestor4(TreeNode root,TreeNode p,TreeNode q){
			if(root==null) return null;
			if(root==p && root ==q){
				return root;
			}
			
			TreeNode x=lowestCommonAncestor4(root.left,p,q);
			if(x!=null&& x!=p && x!=q){
				return x;
			}
			
			TreeNode y=lowestCommonAncestor4(root.right,p,q);
			if(y!=null && y!=p && y!=q){
				return y;
			}
			
			if(x!=null && y!=null){
				return root;
			}
			else if(root == p || root == q){
				return root;
			}
			else{
				return x==null?y:x;
			}
		}

		/*
		 * Solution 5
		 * We use a class Result which will store:
		 * 1. Node
		 * 2. isAncestor
		 * 
		 * This code will take care if one node is not there in tree (Case1 & Case 2 of Solution8d) 
		 */
		
		public static TreeNode lowestCommonAncestor5(TreeNode root, TreeNode p, TreeNode q){
			Result r=commonAncestorHelper(root,p,q);
			if(r.isAncestor){
				return r.node;
			}
			return null;
		}
		
		public static Result commonAncestorHelper(TreeNode root,TreeNode p,TreeNode q){
		
			if(root==null){
				return new Result(null,false);
			}
			else if(root==p&&root==q){
				return new Result(root,true);
			}
			
			Result Rx=commonAncestorHelper(root.left,p,q);
			if(Rx.isAncestor){
				return Rx;
			}
			Result Ry=commonAncestorHelper(root.right,p,q);
			if(Ry.isAncestor){
				return Ry;
			}
			
			if(Rx.node!=null && Ry.node!=null){
				return new Result(root,true);
			}
			else if(p==root ||q == root){
				boolean isAncestor=Rx.node!=null ||Ry.node!=null;
				return new Result(root,isAncestor);
			}
			else{
				return new Result(Rx.node!=null?Rx.node:Ry.node,false);
			}
		}
		
}
