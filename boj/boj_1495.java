package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 1495번 기타리스트 */
public class boj_1495 {
	
	static int N, S, M;
	static int[] Volume;
	static int[][] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 곡 개수
		S = Integer.parseInt(st.nextToken()); // 시작 볼륨
		M = Integer.parseInt(st.nextToken()); // 최대 볼륨값
		
		Volume = new int[N + 1];
		dp = new int[N + 1][M + 1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			Volume[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0][S] = 1;
		
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= M; j++) {
				// 최대볼륨보다 작을 경우 (P+V[i])
				if(j + Volume[i-1] <= M) {
					if(dp[i][j+Volume[i-1]] != 1) {
						dp[i][j+Volume[i-1]] += dp[i-1][j];
					}
				}
				
				// 0 혹은 크거나 같을 경우 (P-V[i])
				if(j - Volume[i-1] >= 0) {
					if(dp[i][j-Volume[i-1]] != 1) {
						dp[i][j-Volume[i-1]] += dp[i-1][j];
					}
				}
			}
		}
		
		int result = -1;
		for (int i = 0; i <= M; i++) {
			if(dp[N][i] == 1) result = i;
		}
		System.out.println(result);
	}
}
