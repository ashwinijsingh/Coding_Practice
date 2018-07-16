package Valid_Palindrome;

import java.util.Stack;

public class Solution125 {

	/**
	 * Valid Palindrome
	 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.
Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false
	 */
	public static void main(String[] args) {
		System.out.println(isPalindrome3("aA"));

	}
	
	
	
	/*
	    * Good Solution: (By some other user)
	    * Beats 100% of java solution 
	    * simply build an array that map all possible char into integer(if not alphanumeric,mark it as zero
	    *  
	    */
	    private static final char[]charMap = new char[256];
	    static{
	        for(int i=0;i<10;i++){
	        	//System.out.println((1+i));
	            charMap[i+'0'] = (char)(1+i);  // numeric
	            //System.out.println(i+'0');
	        }
	        
	        for(int i=0;i<26;i++){
	            charMap[i+'a'] = charMap[i+'A'] = (char)(11+i);  //alphabetic, ignore cases
	           // System.out.println("here");
	           // System.out.println((int)charMap[i+'a']);
	           // System.out.println(i+'A');
	        }
	        
	        for (int i = 0; i < charMap.length; i++) {
				System.out.print(" "+(int)charMap[i]);
			}
	        
	    
	    }
	    public static boolean isPalindrome3(String s) {
	        char[]pChars = s.toCharArray();
	        int start = 0,end=pChars.length-1;
	        char cS,cE;
	        
	       // System.out.println((char) 1);
	        while(start<end){
	        	
	            cS = charMap[pChars[start]];
	            cE = charMap[pChars[end]];
	            System.out.println((int)(cS));
	            System.out.println((int)cE);
	            if(cS!=0 && cE!=0){
	            	//System.out.println(cS);
	                if(cS!=cE)return false;
	                start++;
	                end--;
	            }else{
	                if(cS==0)start++;
	                if(cE==0)end--;
	            }
	        }
	        return true;
	    }
	
	/*
	 * First Solution:
	 * One pointer at the start second at the end
	 * Better than 90.50 %
	 */
	
	 public static boolean isPalindrome(String s) {
		 int i=0;
		 int j=s.length()-1;
		
		 //Character.v

		 while(i!=j&& i<=s.length()-1 && j>0){
		
			 if( s.charAt(i)<48 || (s.charAt(i)>57 && s.charAt(i)<65) || ( s.charAt(i)>90 && s.charAt(i) <97)|| s.charAt(i)>122  ){
				 i++;
				 continue;
			 }
			 if(s.charAt(j)<48 || (s.charAt(j)>57 && s.charAt(j)<65) || ( s.charAt(j)>90 && s.charAt(j) <97) || s.charAt(j)>122){
				 j--;
				 continue;
			 }
			 
			 if(!(Character.toString(s.charAt(i)).equalsIgnoreCase(Character.toString(s.charAt(j))))) return false;
			 i++;
			 j--;
		 }
return true;
	    }
	 
	/*
	 * Second Solution: Using String Buffer
	 * Better than 58 % Hence first solution was better
	 */
	
	public static boolean isPalindrome1(String s) {
		 int i=0;

		 StringBuffer x=new StringBuffer();

		 while( i<=s.length()-1 ){
			 if( (s.charAt(i)>=48 && s.charAt(i)<=57) || (s.charAt(i)>=65 && s.charAt(i)<=90) || (s.charAt(i) >=97 && s.charAt(i)<=122)){
				 x=x.append(s.charAt(i));
				 i++;
				 continue;
			 }
			 i++;
		 }
		// System.out.println(x);
		// System.out.println(x.reverse());
return x.toString().equalsIgnoreCase(x.reverse().toString());
	    }
	
	/*
	 * Third Solution(another user):
	 * Used Regular expression.
	 * Better than only 28.8%
	 * But this is not good in efficiency.This increases the space complexity from O(1) to O(n)
	 */
    public boolean isPalindrome2(String s) {
        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
          String rev = new StringBuffer(actual).reverse().toString();
          return actual.equals(rev);
          
      }
    
    
    
   
	
	

}
