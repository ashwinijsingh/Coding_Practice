package Jewels_Stones;

public class Solution771 {

	/**
	 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  
	   Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
	   The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, 
	   so "a" is considered a different type of stone from "A".
	   
Example 1:

Input: J = "aA", S = "aAAbbbb"
Output: 3
Example 2:

Input: J = "z", S = "ZZ"
Output: 0
	   
	 */
	public static void main(String[] args) {
	
System.out.println(numJewelsInStones("z","ZZZ"));
	}

	  public static int numJewelsInStones(String J, String S) {
	      int len=J.length();  
		  boolean[] jewel=new boolean[127]; 
	      for (int i = 0; i < len; i++) {
	    	  jewel[J.charAt(i)]=true;
		}  
	      
	      int count=0;
	      for (int i = 0; i < S.length(); i++) {
			if(jewel[S.charAt(i)]) count++;
		}
	      return count;
	    }
}
