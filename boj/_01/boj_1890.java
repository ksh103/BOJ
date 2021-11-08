package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 1890번 점프 */
public class boj_1890 {

	static int N;
	static int[][] map;
	static long[][] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		dp = new long[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] = 1;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 0 ) continue;
				if(i + map[i][j] < N) dp[i + map[i][j]][j] += dp[i][j]; // 오른쪽으로 점프
				if(j + map[i][j] < N) dp[i][j + map[i][j]] += dp[i][j]; // 아래로 점프
				
			}
		}
		System.out.println(dp[N-1][N-1]);
	}
}