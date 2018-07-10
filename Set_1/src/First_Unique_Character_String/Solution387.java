package First_Unique_Character_String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class Solution387 {

	/**Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(firstUniqChar("loveleetcode"));
		System.out.println(firstUniqChar1("aavv"));
		
	}
	 /**
	 * This was my first thought and i should have gone with this approach
	 * 
	 */
  public static int firstUniqChar1(String s) {
	  
	  int[] value=new int[27];
	  //System.out.println('a'-97);
	  //System.out.println('b'-97);
	 
	  for (int i = 0; i < s.length(); i++) {
		value[s.charAt(i)-97]++;
	  }
	  for (int i = 0; i < s.length(); i++) {
		  if(value[s.charAt(i)-97]==1) return i;
	  }
	  
	
return -1;
    }
	
	
	/**
	 * Not a good code.
	 * This way gave a Time limit exceeded for very large strings
	 */
	
	
	  public static int firstUniqChar(String s) {
		  

		if(s.equals(null)) return -1;
		  for (int i = 0; i < s.length(); i++) {
			  System.out.println(s.substring(i, i+1));
			System.out.println(s);
			  if(s.charAt(i)!='Z'){
			if(s.length()-1==i){
				return i;
			}
			else if(s.substring(i+1).contains(s.substring(i, i+1))){
				s= s.replace(s.substring(i, i+1), "Z");
			 }
			 else {
				 return i;
			 } 
			 }
			  else{
				  continue;
			  }
		  }
		
	return -1;
	    }
	  
	 

}
