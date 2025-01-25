package com.jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* jungol 1707번 달팽이사각형 */
public class jungol_1707 {

	static int N;
	static int[][] map;
	// 우 하 좌 상
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		int x = 0, y = 0, d = 0;
		for (int i = 1; i <= N*N; i++) {
			map[x][y] = i;
			x += dx[d];
			y += dy[d];
			
			if(x < 0 || x >= N || y < 0 || y >= N || map[x][y] != 0) {
				// 원 위치
				x -= dx[d];
				y -= dy[d];
				
				// 방향 전환
				d = (d + 1) % 4;
				
				x += dx[d];
				y += dy[d];
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(map[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
