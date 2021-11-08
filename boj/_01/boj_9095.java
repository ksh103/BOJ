package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* boj 9095번 1,2,3 더하기 */
public class boj_9095 {

	static int T, N;
	static int[] dp;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		dp = new int[11];
		
		/*
		 *  N = 1 일 때, 1로만 표현 가능 --> 1가지
		 *  N = 2 일 때, 1+1, 2로 표현 가능 --> 2가지
		 *  N = 3 일 떼, 1+1+1, 1+2, 2+1, 3로 표현 가능 --> 4가지
		 */
		
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		/*
		 * N = 4는 크게 보면 1+3, 2+2, 3+1로 표현
		 */
		for(int i = 4; i <= 10; i++) { // N은 11보다 작다.
			dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
		}
		
		while(T-->0) {
			N = Integer.parseInt(br.readLine());
			System.out.println(dp[N]);
		}	
	}
}
