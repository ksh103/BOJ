package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* boj 2156번 포도주 시식 */
public class boj_2156 {

	static int N;
	static int[] dp, wine;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		wine = new int[10001];
		dp = new int[10001];
		
		for (int i = 1; i <= N; i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}
		
//		Arrays.fill(dp, 0);
		
		dp[1] = wine[1];
		dp[2] = dp[1] + wine[2];
		
		for (int i = 3; i <= N; i++) {
			dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + wine[i], dp[i-3] + wine[i-1] + wine[i]));
		}
		
		System.out.println(dp[N]);
	}
}

/*
 * 포도주 선택
 * 1. O O X O O X -> dp[i] = dp[i-1]
 * 2. O X O O X O -> dp[i] = dp[i-2] + wine[i]
 * 3. X O O X O O -> dp[i] = dp[i-3] + wine[i-1] + wine[i]
 */

