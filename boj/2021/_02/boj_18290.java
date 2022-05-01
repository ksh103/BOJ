package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 18290번 NM과 K (1) */
public class boj_18290 {

	static int N, M, K, max = Integer.MIN_VALUE;
	static int[][] map;
	static boolean[][] isSelected;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		isSelected = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		perm(0, 0);
		System.out.println(max);
	}
	

	static void perm(int cnt, int sum) {
		if(cnt == K) {
			max = Math.max(max, sum);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				
				if(isSelected[i][j]) continue;
				if(check(i, j)) continue;
				
				isSelected[i][j] = true;
				perm(cnt + 1, sum + map[i][j]);
				isSelected[i][j] = false;
			}
		}
	}
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static boolean check(int x, int y) {
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
			if(isSelected[nx][ny]) return true;
		}
		return false;
	}
}
