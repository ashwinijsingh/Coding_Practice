package Count_and_Say;

public class Solution38 {

	/**
	 * Count and Say:
	 * The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.

Example 1:

Input: 1
Output: "1"
Example 2:

Input: 4
Output: "1211"

	 */
	public static void main(String[] args) {
		
System.out.println(countAndSay(4));
	}

	
	/*
	 * My first Solution: 
	 * 
	 */
	
	 public static String countAndSay(int n) {
		 if(n==1){
			 return "1";
		 }
		
		 StringBuilder str=new StringBuilder("1");
		 StringBuilder str1=new  StringBuilder("");

			 while(n>1){
			 int count=1;
			 int i=1;
			 char c=str.charAt(0);
			 while(i<str.length()){
				
				if(str.charAt(i)==c){
					count++;
				}
				else{
				
					str1.append(count);
					str1.append(c);
					count=1;
					c=str.charAt(i);
					
				 }
				i++;
			}
			 str1.append(count);
			 str1.append(c);
			 str=str1;
			 str1=new  StringBuilder("");
			 n--;
			 
			 }
			 
		        return str.toString();
	    }

}
