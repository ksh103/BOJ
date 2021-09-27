package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 5557번 1학년 */
public class boj_5557 {

	static int N;
	static long numCnt;
	static int[] numbers;
	static long[][] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		numbers = new int[N];
		dp = new long[N-1][21];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0][numbers[0]] = 1;
		
		for (int i = 1; i < N-1; i++) {
			for (int j = 0; j <= 20; j++) {
				if(j + numbers[i] <= 20) dp[i][j + numbers[i]] += dp[i-1][j];
				if(j - numbers[i] >= 0) dp[i][j - numbers[i]] += dp[i-1][j];
			}
		}
		System.out.println(dp[N-2][numbers[N-1]]);
	}
}
