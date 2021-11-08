package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 1149번 RGB거리 */
public class boj_1149 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); 
		int[][] dp = new int[N+1][3]; // RGB
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			dp[i][0] = Integer.parseInt(st.nextToken());
			dp[i][1] = Integer.parseInt(st.nextToken());
			dp[i][2] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i < N; i++) {
			dp[i][0] += Math.min(dp[i-1][1], dp[i-1][2]);
			dp[i][1] += Math.min(dp[i-1][2], dp[i-1][0]);
			dp[i][2] += Math.min(dp[i-1][0], dp[i-1][1]);
			// System.out.println(dp[i][0] + " " + dp[i][1] + " " + dp[i][2]);
		}
		
		System.out.println(Math.min(Math.min(dp[N-1][0], dp[N-1][1]), dp[N-1][2]));
	}
}

/*
 * R : 26 49 13
 * G : 40 60 89
 * B : 83 57 99
 * 
 * dp[1][0] += min(49, 40) --> dp[1][0] = 89
 * dp[1][1] += min(60, 26) --> dp[1][1] = 86
 * dp[1][2] += min(57, 26) --> dp[1][2] = 83
 * 
 * dp[2][0] += min(83, 86) --> dp[2][0] = 96
 * dp[2][1] += min(89, 83) --> dp[2][1] = 172
 * dp[2][2] += min(89, 86) --> dp[2][2] = 185
 *  
 */
