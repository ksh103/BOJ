package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* boj 11057번 오르막 수 */
public class boj_11057 {

	static int N;
	static long sum, MOD = 10007;
	static long[][] dp = new long[1001][10];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i <= 9; i++) {
			dp[1][i] = 1; 
		}
		
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j <= 9; j++) {
				for (int n = j; n <= 9; n++) {
					dp[i][j] += dp[i-1][n] % MOD;
				}
			}
		}
		
		sum = 0;
		for (int i = 0; i <= 9; i++) {
			sum += dp[N][i];
		}
		sum %= MOD;
		System.out.println(sum);
	}
}

/*
 * 길이 1) 
 * : 0 1 2 3 4 5 6 7 8 9 -> 10개
 * 길이 2)
 * 00일 때 : 0~9 -> 10개
 * 10일 때 : 1~9 -> 9개
 * 20일 때 : 2~9 -> 8개
 * 30일 때 : 3~9 -> 7개
 * 40일 때 : 4~9 -> 6개
 * 50일 때 : 5~9 -> 5개
 * 60일 때 : 6~9 -> 4개
 * 70일 때 : 7~9 -> 3개
 * 80일 때 : 8~9 -> 2개
 * 90일 때 : 9 -> 1개 
 * -> 55개
 * 길이 3)
 * 000일 때 -> 55개
 * 100일 때 -> 45개
 * 200일 때 -> 36개
 * 300일 때 -> 28개
 * 400일 때 -> 21개
 * 500일 때 -> 15개
 * 600일 때 -> 10개
 * 700일 때 -> 6개
 * 800일 때 -> 3개
 * 900일 때 -> 1개
 */