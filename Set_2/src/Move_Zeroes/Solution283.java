package Move_Zeroes;

public class Solution283 {

	/**
	 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.

	 */
	public static void main(String[] args) {
		
	}

	
	/*
	  * This solution satisfies the condition to minimize the number of operations
	  * Space Complexity : O(1)O(1). Only constant space is used.
	  * Time Complexity: O(n)O(n). 
	  * However, the total number of operations are still sub-optimal. The total operations (array writes) that code does is nn (Total number of elements).
	  */
	 public void moveZeroes(int[] nums){
		 
		 int count =0;
		    // If the current element is not 0, then we need to
		    // append it just in front of last non 0 element we found. 
		 for (int i = 0; i < nums.length; i++) {
			int temp=nums[i];
			if(temp!=0){
				nums[count]=temp;
				count++;
			}
		}
		// After we have finished processing new elements,
		 // all the non-zero elements are already at beginning of array.
		   // We just need to fill remaining array with 0's.
		 while(count < nums.length){
			 nums[count]=0;
			 count++;
		 }
	 }
	 
	 
	 /*
	  * This solution does not satisfy the condition to minimize the number of operations
	  */
	 
	 public void moveZeroes1(int[] nums) {
	        int i=0;
	        int j=1;
	        while(i<nums.length && j<nums.length){
	            if(nums[i]!=0 && nums[j]!=0) {
	                i=i+2;
	                j=j+2;
	            }
	            else if(nums[i]==0 && nums[j]==0) {
	             
	                j++;
	            }
	            else if(nums[i]==0 && nums[j]!=0){
	               
	                nums[i]=nums[j];
	                nums[j]=0;
	               
	                i++;
	                j++;
	               
	            }
	            else{


	                i++;
	                j++;
	           }
	        }
}
	 
}
