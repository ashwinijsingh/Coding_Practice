package Missing_Number;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

Example 1:

Input: [3,0,1]
Output: 2
Example 2:

Input: [9,6,4,2,3,5,7,0,1]
Output: 8
Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 *
 */

public class Solution268 {
	
	public static void main(String[] args) {
		
		int[] nums={2,0,1};

		System.out.println(missingNumber(nums));
		System.out.println(missingNumber1(nums));
		System.out.println(missingNumber2(nums));
	}
	
/*
 * Used Hash Set:
 * 
 * 1) Time complexity : O(n).
 * Because the set allows for O(1) containment queries, the main loop runs in O(n) time. 
 * Creating the set costs O(n) time, as each set insertion runs in amortized O(1) time, 
 * so the overall runtime is O(n+n)=O(n).
 * 
 * 2) pace complexity : O(n).
 * nums contains n-1 distinct elements, so it costs O(n) space to store a set containing all of them
 * 
 */	
	 public static int missingNumber(int[] nums) {
	        Set<Integer> h=new HashSet<Integer>();
	        for (int i = 0; i < nums.length; i++) {
	        	 h.add(nums[i]);
			}	
	       //nums.length+1 : because that would be the expected size of the array
	        for (int i = 0; i < nums.length+1; i++) {
				if(!h.contains(i)){
					return i;
				}
	        }
	  return -1;
	    }
	 
	/*
	 * Sort the array:
	 * 1) Time complexity : O(nlgn):
	 * for loop O(n) time & sort invocation which runs in O(nlgn)  : 
	 * Therefore the runtime is dominated by sort, and the entire runtime is O(nlgn).
	 * 
	 * 2) Space complexity : O(n))
	 * In the sample code, we sorted nums in place, allowing us to avoid allocating additional space. 
	 * If modifying nums is forbidden, we can allocate an \mathcal{O}(n)O(n) size copy and sort that instead.
	 */
	 public static int missingNumber1(int[] nums) {
	       Arrays.sort(nums);
	      
	       // Ensure that n is at the last index
	       if(nums.length!=nums[nums.length-1]){
	    	   return nums.length;
	       }
	      for (int i = 0; i < nums.length; i++) {
	    	  if(i!=nums[i]){
	    		  return i;
	    	  }
	    	 
		}
	       
	       return -1;
	    }
	 
	 /*
	  * Gauss' Formula:
	  * Sum of first n natural numbers = n(n+1)/2
	  * 1) Time complexity : O(n)
	  * summing nums costs us O(n) time, so the algorithm is overall linear.
	  * 
	  * 2) Space complexity : O(1)
	  * This approach only pushes a few integers around, so it has constant memory usage.
	  * 
	  */
	 public static int missingNumber2(int[] nums) {
	     int expectedSum=nums.length*(nums.length+1)/2;
	     int actualSum=0;
	     
	     for (int val : nums) {
			actualSum+=val;
		}

	       return expectedSum-actualSum;
	    }
}
