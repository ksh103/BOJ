package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* boj 2098번 외판원 순회 */
// dp + 비트마스킹
public class boj_2098 {

	static int N;
	static final int INF = 16 * 1000000;
	static int[][] map, dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		dp = new int[N][(1 << N) -1];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				Arrays.fill(dp[i], INF);
			}
		}
		
		System.out.println(TSP(0, 1));
	}
	
	static int TSP(int node, int visit) {
		
		if(visit == (1 << N) -1) {
			if(map[node][0] == 0) return INF;
			return map[node][0];
		}
		
		if(dp[node][visit] != INF) return dp[node][visit];
		
		for (int i = 0; i < N; i++) {
			int next = visit | (1 << i);
			
			if(map[node][i] == 0 || (visit & (1 << i)) != 0) continue;
			
			dp[node][visit] = Math.min(dp[node][visit], TSP(i, next) + map[node][i]);
		}
		
		return dp[node][visit];
	}
}
