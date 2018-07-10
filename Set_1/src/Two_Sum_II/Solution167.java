package Two_Sum_II;

import java.util.ArrayList;

public class Solution167 {

	/**
	 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.

Note:

Your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution and you may not use the same element twice.
Example:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.

	 */
	public static void main(String[] args) {
		int[] numbers={3,24,50,79,88,150,345};
	
		int a[]=twoSum(numbers,200);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		
		a=twoSum1(numbers,200);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		
		
		
	}
	
	
	/*
	 * Good Solution
	 * Have two pointers-> start and then end
	 * If the sum is greater than target -> decrement end
	 * If Sum is less than target -> increment start
	 * if sum is equal to target -> return indexes 
	 */
	  public static  int[] twoSum1(int[] numbers, int target) {
		  int length=numbers.length;
		  int i=0;
		  int j=length-1;
		  while(i<j){
			  if(numbers[i]+numbers[j]<target) i++;
			  else if(numbers[i]+numbers[j]>target) j--;
			  else if(numbers[i]+numbers[j]==target)
				  return new int[] {i+1,j+1};
		  }
		  return new int[2];
	  }
	
	/*
	 * 17/17 Test cases passed but time limit exceeded
	 */
	  public static  int[] twoSum(int[] numbers, int target) {
	ArrayList<Integer> list=new ArrayList<Integer>();
	int a[]=new int[2];
	int k=0;
	while(k<numbers.length){
	
		list.add(numbers[k]);
		k++;
	}

	
	for (int i= 0; i < numbers.length; i++) {
		System.out.println(target-numbers[i]);
		if(list.contains(target-numbers[i])){
			a[0]=list.indexOf(numbers[i])+1;
			a[1]=list.lastIndexOf(target-numbers[i])+1;
			   break;
		}
	}

	
	return a;
	    }
	  
	  


}
