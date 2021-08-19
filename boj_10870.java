package com.boj;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* boj 피보나치 수 5 */
public class boj_10870 {

	static int N, result;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		System.out.println(Fibo(N));
	}
	
	// 재귀 사용
	static int Fibo(int n) {
		if(n == 0) return 0;
		if(n == 1) return 1;
		
		return Fibo(n-1) + Fibo(n-2);
	}
}
