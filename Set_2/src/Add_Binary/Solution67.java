package Add_Binary;

public class Solution67 {

	/**
	 * Add Binary
	 * Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
	 * 
	 */
	public static void main(String[] args) {
		System.out.println("Solution 1");
	System.out.println(addBinary("1010","1011"));
	
	System.out.println("Solution 2");
	System.out.println(addBinary1("1010","1011"));
		
	}
	
	
	/*
	 * Nice and Simple Solution.
	 * Note: Remember : a.charAt(i)-'0' if-> 0 it would be 0 (97-97) if-> 1 it would be 1 
	 * 
	 */
	
	
	public static String addBinary1(String a, String b){
		StringBuffer buf=new StringBuffer();
		int i=a.length()-1;
		int j=b.length()-1;
		int carry=0;
		System.out.println();
		while(j>=0 || i>=0){
			int aDigit=(i > -1)?a.charAt(i)-'0':0;
			int bDigit=(j >  -1)?b.charAt(j)-'0':0;
			buf.append((aDigit+bDigit+carry)%2);
			carry=(aDigit+bDigit+carry)/2;
			j--;
			i--;
			
		}
		if(carry==1) buf.append("1");
		
		return buf.reverse().toString();
		
		}
	
	
	
	/*
	 * My First Solution:
0 + 0 = 0
1 + 0 = 1
0 + 1 = 1
1 + 1 = 10
1 + 1 + 1 = 11
	 */
	public static String addBinary(String a, String b) {
        
		int diff=Math.abs(a.length()-b.length());
		String longer=a.length()-b.length()>0?a:b;
		String shorter=a.length()-b.length()>0?b:a;
		if(diff>0)
		shorter=appendZero(shorter,diff);
		StringBuffer buffer=new StringBuffer();
		System.out.println(longer);
		System.out.println(shorter);
		
		boolean carry=false;
		for (int i = longer.length()-1; i >=0 ; i--) {
			if(longer.charAt(i)=='0' && shorter.charAt(i)=='0' && !carry){
				buffer.append("0");
				carry=false;
			}
			else if(longer.charAt(i)=='0' && shorter.charAt(i)=='0' && carry){
				buffer.append("1");
				carry=false;
			}
			else if((longer.charAt(i)=='1' && shorter.charAt(i)=='0' && !carry)||(longer.charAt(i)=='0' && shorter.charAt(i)=='1' && !carry)){
				buffer.append("1");
				carry=false;
			}
			
			else if((longer.charAt(i)=='1' && shorter.charAt(i)=='0' && carry)||(longer.charAt(i)=='0' && shorter.charAt(i)=='1' && carry)){
				buffer.append("0");
				carry=true;
			}
			else if((longer.charAt(i)=='1' && shorter.charAt(i)=='1' && !carry)){
				buffer.append("0");
				carry=true;
			}
			else if((longer.charAt(i)=='1' && shorter.charAt(i)=='1' && carry)){
				buffer.append("1");
				carry=true;
			}
		}
		
		if(carry) buffer.append("1");
		
		return buffer.reverse().toString();
		
    }
	
	public static String appendZero(String x,int diff){
		//System.out.println(diff);
		String temp=x;
		x="0";
		while(diff>0){
			x+="0";
			diff--;
		}
		x+=temp;
		
		return x;
	}
}
