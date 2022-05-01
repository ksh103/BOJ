package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 16395번 파스칼의 삼각형 */
public class boj_16395 {

	static int n, k;
	static int[][] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		dp = new int[31][31];
		
		dp[1][1] = dp[2][1] = dp[2][2] = 1; // 초기값
		
		for (int i = 3; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				if(j == 1 || i == j) dp[i][j] = 1;
				else dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
			}
		}
		System.out.println(dp[n][k]);
	}
}
