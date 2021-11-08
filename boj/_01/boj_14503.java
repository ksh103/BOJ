package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 14503번 로봇 청소기 */
public class boj_14503 {

	static int N, M, r, c, d, result;
	static int[][] map;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken()); // 로봇 위치 (r,c)
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken()); // 로봇이 바라보는 방향
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		result = 0;
		solve(r, c, d);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 2) {
					result++;
				}
			}
		}
		System.out.println(result);
		
	}
	
	static int[] dx = {-1, 0, 1, 0}; // 북동남서
	static int[] dy = {0, 1, 0, -1};
	static void solve(int r, int c, int d) {
		
		map[r][c] = 2; // 청소했음을 표시
		
		// 0 : 북쪽, 1 : 동쪽, 2 : 남쪽, 3 : 서쪽
		int nDir = d;
		
		for (int i = 0; i < 4; i++) {
			nDir = (nDir + 3) % 4; // 현재 방향을 기준으로 왼쪽 방향으로 탐색
			
			int nr = r + dx[nDir];
			int nc = c + dy[nDir];
			
			if(map[nr][nc] == 0) {
				solve(nr, nc, nDir);
				return;
			}
		}
		
		// 왼쪽 방향에 청소할 공간이 없으면 그 방향으로 회전 -> 왼쪽 방향으로 탐색을 반복
		int sr = r - dx[d];
		int sc = c - dy[d];
		
		if(sr < 0 || sr >= N || sc < 0 || sc >= M || map[sr][sc] == 1) return;
		
		solve(sr, sc, d);	
	}
}
