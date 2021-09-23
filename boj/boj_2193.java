package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* boj 2193번 이친수 */
public class boj_2193 {

	static int N;
	static long result = 0;
	static long[][] dp = new long[91][2];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		dp[1][0] = 0;
		dp[1][1] = 1;
		
		for (int i = 2; i <= N; i++) {
			dp[i][0] = dp[i-1][0] + dp[i-1][1];
			dp[i][1] = dp[i-1][0];
		}
		
		result = dp[N][0] + dp[N][1];
		
		System.out.println(result);
	}
}

/* 
 * 1자리수 -> 1개
 * : 1
 * 2자리수 -> 1개
 * : 10
 * 3자리수 -> 2개
 * : 100 101
 * 4자리수 -> 3개
 * : 1000 1001 1010
 * 5자리수 -> 5개
 * : 10000 10100 10010 10101 10001
 */