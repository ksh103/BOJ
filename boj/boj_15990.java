package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/* boj 15990번 1,2,3 더하기 5 */
public class boj_15990 {

	static int T, N;
	static long result, MOD = 1000000009;
	static long[][] dp = new long[100001][4];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		
		// 없는 값은 0 대입
		for (int i = 0; i <= N; i++) {
			Arrays.fill(dp[i], 0);
		}
			
		dp[1][1] = 1;
		dp[2][2] = 1;
		dp[3][1] = 1; dp[3][2] = 1; dp[3][3] = 1;
			
		
		for (int i = 4; i < 100001; i++) {
			dp[i][1] = (dp[i-1][2] + dp[i-1][3]) % MOD;
			dp[i][2] = (dp[i-2][1] + dp[i-2][3]) % MOD;
			dp[i][3] = (dp[i-3][1] + dp[i-3][2]) % MOD;
		}

		while(T-->0) {
			N = Integer.parseInt(br.readLine());
			result = (dp[N][1] + dp[N][2] + dp[N][3]) % MOD;
			System.out.println(result);
		}
	}
}
