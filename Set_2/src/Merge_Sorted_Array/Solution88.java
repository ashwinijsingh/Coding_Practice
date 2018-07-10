package Merge_Sorted_Array;

public class Solution88 {

	/**
	 * Merge Sorted Array:
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
	 */
	public static void main(String[] args) {
		int[] nums1={1,2,3,0,0,0};
		int[] nums2={2,5,6};
		int m=3;
		int n=3;
		merge(nums1,m,nums2,n);
	}
	
	 public static void merge(int[] nums1, int m, int[] nums2, int n) {
	        int index=nums1.length-1;
	        m=m-1;
	        n=n-1;
	        while(m>=0 && n>=0){
	            if(nums1[m]>nums2[n]){
	                nums1[index]=nums1[m];
	                index--;
	                m--;
	            }
	            else{
	                nums1[index]=nums2[n];
	                index--;
	                n--;
	            }
	        }
	        
	        while(n>=0){
	            nums1[index]=nums2[n];
	                index--;
	                n--;
	        }
	        
	       for (int i = 0; i < nums1.length; i++) {
			System.out.print(nums1[i]);
		}
	 }

}
