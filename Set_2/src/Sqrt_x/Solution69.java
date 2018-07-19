package Sqrt_x;

public class Solution69 {

	/** Sqrt(x):
	 * Implement int sqrt(int x).

Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

Example 1:

Input: 4
Output: 2
Example 2:

Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since 
             the decimal part is truncated, 2 is returned.
	 */
	public static void main(String[] args) {
		System.out.println(mySqrt3(6));

	}
	
	/*
	 * Fourth Solution: Binary Solution: 
	 * Better than only 91.30%
	 * Time complexity = O(lg(x)) = O(32)=O(1)
	 */
	
	 public static int mySqrt3(int x) {
		 if (x == 0) return 0;
		 	int start=1, end=x;
		         while(start<end){
		             //int mid=start+(end-start)/2; //when i use this its better than only 11%
		        	 int mid=(start+end)/2; //when i use this its better than 41%
		             System.out.println(start);
		             System.out.println(end-start);
		             //System.out.println(start+(end-start)/2);
		             System.out.println(mid);
		             if(mid<=x/mid && (mid+1)>(x)/(mid+1)) return mid;
		             else if(mid>x/mid) end=mid;
		             else start=mid+1;     
		         }
		         
		         return start;
		     }
	
	
	/*
	 * Third Solution: Newton Solution: 
	 * Better than only 91.30%
	 * Time complexity = O(lg(x))
	 */
	 public int mySqrt2(int x) {
		 if (x == 0) return 0;
		 	long i=x;
		         while(i>x/i){
		             i=(i+x/i)/2;
		         }
		         return (int) i; 
		         
		     }
	
	/*
	 * First Solution: Brute Force
	 * Better than only 11.88%
	 * Time complexity = O(sqrt(x))
	 */
	public static int mySqrt(int x) {
		 if(x==0) return 0;
	        if(x==1) return 1;
	        double i=2;
	        while(i*i <= x){ i++;}
	        return (int) i-1;
      
  }
	//SomeOne else solution: Added another condition for my First Solution: use i <= x / i for comparison, instead of i * i <= x, to avoid exceeding integer upper limit.
	public static int mySqrtFirstSolutionOthers(int x) {
		 if(x==0) return 0;
	        if(x==1) return 1;
	        if (x == 0) return 0;
	    	for (int i = 1; i <= x / i; i++) 		
	    		if (i <= x / i && (i + 1) > x / (i + 1))// Look for the critical point: i*i <= x && (i+1)(i+1) > x
	    			return i;		
	    	return -1;
     
 }
	
	
	
	
	/*
	 * Second Solution: Brute Force
	 * Time Limit Exceeded
	 */
	public static int mySqrt1(int x) {
		  if(x==0) return 0;
	      if(x==1) return 1;
	        
	    double mid=(x)/2;
	    
	    while(mid>0){
	    	if((mid*mid)>x) mid--;
	    	else{
	    		break;
	    	}
	    }
	    
	   //System.out.println(1073697799*1073697799);
    return (int)mid;
      
  }
}
