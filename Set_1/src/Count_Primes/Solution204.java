package Count_Primes;

public class Solution204 {

	/**
	 * Count the number of prime numbers less than a non-negative number, n.
	 * 
	 * Input: 10
	   Output: 4
	   Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
	 */
	public static void main(String[] args) {
		
		System.out.println(countPrime(10));
	}

	
	public static int countPrime(int n){
		boolean[] isPrime=new boolean[n]; // This creates an array with default value is FALSE
		  for (int i = 2; i < n; i++) {
		      isPrime[i] = true;
		   }
		  
		  /*
		   * First for loop:
		   * √n because, if n is divisible by some nber p, then n = p × q and since p ≤ q, we could derive that p ≤ √n.
		   * 
		   * Second for loop:
		   * Sieve of Eratosthenes
		   * ->We start marking off from p2, then in increments of p: p2 + p, p2 + 2p
		   * ->End : i*i < √n
		   * 
		   * 
		   */
		  for (int i = 2;  i * i < n; i++) {
			  if(!isPrime[i]) continue;
			 for (int j = i*i; j< n ; j+=i) {  //important p2 + p, p2 + 2p
				isPrime[j]=false;
			} 
			
		  }
		 int count=0;
		 
		 for (int i = 2; i < n; i++) {
			 if(isPrime[i]) count++;
		}
		  return count;
		
	
	}
}
