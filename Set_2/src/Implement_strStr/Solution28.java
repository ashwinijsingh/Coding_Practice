package Implement_strStr;

public class Solution28 {

	/**
	 * Implement strStr()
	 * 

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().


	 */
	public static void main(String[] args) {
		
System.out.println(strStr2("aaaa","a"));

	}

	
	
	/*
	 * Third Solution: Not great (5.96%)
	 */
	public static int strStr2(String haystack, String needle) {
		
		//System.out.println(haystack.substring(2, needle.length()+2));
        if(needle.length()==0) return 0;
       
        int j=0;
        for (int i = 0; i < haystack.length(); i++) {
			if(haystack.charAt(i)==needle.charAt(j) && (i+needle.length())<=haystack.length()){
				int temp=0;
				String x=new String();
				while(temp<needle.length()){
					x+=String.valueOf(haystack.charAt(temp+i));
					temp++;
				}
				System.out.println(x);
				if(x.equals(needle)) return i;
			}
		}
        
        return -1;
    }
	/*
	 * Second Solution: better (98.32%)
	 * Substring
	 * 
	 */
	public static int strStr1(String haystack, String needle) {
		
		System.out.println(haystack.substring(2, needle.length()+2));
        if(needle.length()==0) return 0;
       
        int j=0;
        for (int i = 0; i < haystack.length(); i++) {
			if(haystack.charAt(i)==needle.charAt(j) && (i+needle.length())<=haystack.length()){
	
				if(haystack.substring(i, needle.length()+i).equals(needle)) return i;
			}
			
			if((i+needle.length())>haystack.length()) return -1; //after adding this it increased to 99.73 
		}
        
        return -1;
    }
	/*
	 * First Solution: Not great (5.18%)
	 */
	 public static int strStr(String haystack, String needle) {
	        if(needle.length()==0) return 0;
	       
	        int j=0;
	        for (int i = 0; i < haystack.length(); i++) {
				if(haystack.charAt(i)==needle.charAt(j)){
		
					int temp=i+1;
					j++;
					while(temp<haystack.length()&& j<needle.length()){
		
						if(haystack.charAt(temp)!=needle.charAt(j)) break;
						temp++; j++;
				
					}
			
					if((temp-i)==needle.length()) return i;
					j=0;
				}
			}
	        
	        return -1;
	    }
}
