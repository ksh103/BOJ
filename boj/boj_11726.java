package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* boj 11726번  2xn 타일링 */
public class boj_11726 {

	static int N;
	static int[] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1];
		
		if(N == 1) {
			System.out.println(1);
			return;
		}else {
			dp[1] = 1;
			dp[2] = 2;
			
			for (int i = 3; i <= N; i++) {
				dp[i] = dp[i-2] + dp[i-1];
				dp[i] %= 10007;
			}
		}
		System.out.println(dp[N]);
	}
}
/*
 * 2 x 1 -> 1
 * 2 x 2 -> 2 
 */