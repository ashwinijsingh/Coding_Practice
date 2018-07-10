package BestTime_Buy_and_SellStock;

import java.util.Stack;

public class Solution121 {

	/**
	 * Best Time to Buy and Sell Stock:
	 * 
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.

Example 1:

Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
Example 2:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.

	 */
	public static void main(String[] args) {
		int[] prices={3,2,6,5,0,1};
		System.out.println(maxProfit3(prices));
	}

	
	/*
	 * Similar to my First thought/approach:use two values Min and Max
	 * But here inly minimum is required & Profit variables required. No need to maintain max.
	 * ->The mistake I had made is: If the value in array that i consider as max i need o check the profit and then choose the max.
	 * (second if condition)
	 */
	
	 public static int maxProfit3(int[] prices) {
		 if(prices.length==0) return 0;
		 int min=prices[0];
		 
		 int profit=0;
		 for (int i = 1; i < prices.length; i++) {
			 if(prices[i]<min){
				min=prices[i]; 
			 }
			 else if(prices[i]-min>profit){
				 profit=prices[i]-min;
			 }
		 }
		 return profit;
	 }
	
	
	/*
	 * Used 2 stacks stack: Still not best solution
	 */
	 public static int maxProfit1(int[] prices) {
	   if(prices.length==0) return 0;
	   Stack<Integer> min=new Stack<Integer>();
	   min.add(prices[0]);
	   Stack<Integer> max=new Stack<Integer>();
	   max.add(0);
	   int profit=0;
	   for (int i = 1; i < prices.length; i++) {
	   if(prices[i]<min.peek()){
		   min.add(prices[i]);
		   max.add(0); // we are adding this as we cannot use the previous max 
	   }
	   else if(prices[i]>max.peek()){
		   max.add(prices[i]);
		   min.add(min.peek());
	   }
	   int temp=max.peek()-min.peek();
	   System.out.println(temp);
	   if(temp>profit){
		   profit=temp;
		   max.pop();
		   min.pop();
	   }
	}
	   
	  
//	   while(!min.isEmpty()){ 
//		   System.out.println(min.peek());
//		   int temp=max.pop()-min.pop();
//		   System.out.println(temp);
//		   if(temp>profit){
//			   profit=temp;
//		   }
//	   }
	   return profit;
	    }
	
	/*
	 * My first Solution: Very basic approach Brute Force approach
	 * 
	 */
	 public int maxProfit(int[] prices) {
	        int profit=0;
	        for(int i=0;i<prices.length;i++){
	            for(int j=i+1;j<prices.length;j++){
	                if(prices[i]<prices[j] && profit<prices[j]-prices[i]){
	                profit=prices[j]-prices[i];
	                }
	            }
	        }
	        
	        return profit;
	    }
}
