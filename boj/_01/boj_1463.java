package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* boj 1463번 1로 만들기 */
public class boj_1463 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[1000001];
		
		dp[1] = 0;
		
		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i-1] + 1;
			
			if(i % 2 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 2] + 1);
			}
			if(i % 3 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 3] + 1);
			}
		}
		System.out.println(dp[N]);
	}
}
