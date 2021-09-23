package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 9465번 스티커 */
public class boj_9465 {

	static int T, N, result = 0;
	static int[][] dp, sticker;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());

		while(T-->0) {
			N = Integer.parseInt(br.readLine());
			
			dp = new int[2][N+1];
			sticker = new int[2][N+1];
			
			for (int i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					sticker[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			dp[0][1] = sticker[0][1];
			dp[1][1] = sticker[1][1];
			
			for (int i = 2; i <= N; i++) {
				dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + sticker[0][i];
				dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + sticker[1][i];
			}
			
			result = Math.max(dp[0][N], dp[1][N]);
			System.out.println(result);
		}
	}
}
