package com.boj;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* boj 10872번 팩토리얼 */
public class boj_10872 {

	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		System.out.println(Factorial(N));

	}
	
	static int Factorial(int n) {
		if(n == 0) return 1; // 0! = 1이다.
		if(n <= 1) return n;
		else return Factorial(n-1) * n;
	}
}
