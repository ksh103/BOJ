package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* boj 10844번 쉬운 계단 수 */
public class boj_10844 {

	static int N;
	static int MOD = 1000000000;
	static long result;
	static long[][] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		dp = new long[101][10];
		
		
		dp[1][0] = 0;
		
		for (int i = 1; i <= 9; i++) {
			dp[1][i] = 1; 
		}
		
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j <= 9; j++) {
				if(j == 0) {
					dp[i][j] = dp[i-1][j+1] % MOD;	
				}else if(j == 9) {
					dp[i][j] = dp[i-1][j-1] % MOD;
				}else {
					dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1] % MOD;
				}
			}
		}
		
		result = 0;
		for (int i = 0; i <= 9; i++) {
			result += dp[N][i];
		}
		
		System.out.println(result % MOD);
	}

}

/* 
 * 길이가 1 -> 9 
 * : 01, 02, 03, 04, 05, 06, 07, 08, 09
 * 길이가 2 -> 17
 * : 10, 12, 21, 23, 32, 34, 43, 45, 54, 56, 65, 67, 76, 78, 87, 89, 98
 * 길이가 3 -> 32
 * : 101, 121, 123, 210, 212, 232, 234, 321, 323, 345, 343, 432, 456, 434, 454
 * 543, 567, 545, 565, 654, 678, 656, 676, 765, 789, 767, 787, 876, 878, 898, 987, 989
 */
