package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* boj 9461번 파도반 수열 */
public class boj_9461 {

	static int T, N;
	static long[] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			N = Integer.parseInt(br.readLine());
			
			dp = new long[101];
		
			// 초기값
			dp[1] = dp[2] = dp[3] = 1;
			
			for (int i = 4; i <= 100; i++) {
				dp[i] = dp[i-2] + dp[i-3];
			}
			System.out.println(dp[N]);
		}
	}
}
