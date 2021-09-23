package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* boj 2133번 타일 채우기 */
public class boj_2133 {

	static int N;
	static long[] dp = new long[31];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		dp[0] = 1;
		dp[1] = 0;
		dp[2] = 3;
		
		for (int i = 4; i <= N; i+=2) {
			dp[i] = dp[i-2] * dp[2];
			for (int j = 0; j < i-2; j+=2) {
				dp[i] += dp[j] * 2;
			}
		}
		System.out.println(dp[N]);
	}
}

/* 
 * 3 x 1 -> 0가지
 * 3 x 2 -> 3가지
 * 3 x 3 -> 0가지
 * 3 x 4 -> 11가지
 */
 