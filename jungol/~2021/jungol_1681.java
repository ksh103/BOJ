package com.jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* jungol 1681번 해밀턴 순환회로 */
public class jungol_1681 {

	static int N;
	static final int INF = 987654321;
	static int[][] map, dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		dp = new int[N][(1 << N) -1]; // N개의 비트가 있음
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				Arrays.fill(dp[i], INF);
			}
		}
		System.out.println(go(0, 1));
	}
	
	static int go(int node, int visit) {
		// 모든 지점 방문
		if(visit == (1 << N) -1) {
			if(map[node][0] == 0) return INF;
			return map[node][0];
		}
		
		// 메모이제이션
		if(dp[node][visit] != INF) return dp[node][visit];
		
		
		for (int i = 0; i < N; i++) {
			// i배달장소 방문
			int next = visit | (1 << i); // 비트를 1로 원소 추가
			
			// 길이 없거나 이미 방문한 경우
			if(map[node][i] == 0 || (visit & (1 << i)) != 0) continue;
			
			// go(다음 배달 장소, 다음 배달 장소 방문했다고 가정) + 다음 배달 장소까지의 거리와 최소거리 비교 
			dp[node][visit] = Math.min(dp[node][visit], go(i, next) + map[node][i]);
		}
		return dp[node][visit];
	}
}
/* 참고 
 * https://coder-in-war.tistory.com/entry/%EA%B0%9C%EB%85%90-53-%EB%B9%84%ED%8A%B8%EB%A7%88%EC%8A%A4%ED%82%B9bit-mask
 * https://loosie.tistory.com/272
 */
