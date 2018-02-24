package com.arrays;

import java.util.Arrays;

public class PrimeFactors {

	
	//https://www.geeksforgeeks.org/sieve-of-eratosthenes/
	
	public static void main(String[] args) {
		
		PrimeFactors pm = new PrimeFactors();
		
		pm.findPrimeFactors(2);
		
		
	}

	public void findPrimeFactors(int n){
		
		boolean primes[] = new boolean[n+1];
		Arrays.fill(primes, true);
		
		for(int i=2;i<= Math.sqrt(n);i++){
			if(primes[i] == true){
				for(int j=2; i*j<=n;j++){
					primes[i*j] = false;
				}
			}
		}
		
		//print numbers
		for(int i=2;i<=n;i++){
			if(primes[i])
				System.out.println(i + " ");
		}
		
	}
	
}
