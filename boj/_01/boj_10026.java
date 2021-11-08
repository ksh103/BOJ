package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* boj 10026번 적록색약 */
public class boj_10026 {

	static int N;
	static char[][] map;
	static boolean[][] visit;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		
		for(int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		/* 적록색약 x */
		int cnt = 0;
		visit = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visit[i][j]) {;
					dfs(i, j, map[i][j]);
					cnt++;
				}
			}
		}
		System.out.print(cnt + " ");
		
		/* 적록색약 */
		// 초기화
		cnt = 0;
		visit = new boolean[N][N]; 
		
		change(); // 적록색약으로 바꿔줌
		for(int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visit[i][j]) {;
					dfs(i, j, map[i][j]);
					cnt++;
				}
			}
		}
		System.out.print(cnt);
	}
	
	static int[] dx = {-1, 1, 0, 0}; // 상 하 좌 우
	static int[] dy = {0, 0, -1, 1};
	static void dfs(int x, int y, char color) {
		visit[x][y] = true;
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || nx >= N || ny < 0  || ny >= N || map[nx][ny] == 'X') continue;
			if(visit[nx][ny] || map[nx][ny] != color) continue;
			
			dfs(nx, ny, map[nx][ny]);
		}
	}
	
	// 적록색약
	static void change() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 'G') {
					map[i][j] = 'R';
				}
			}
		}
	}
}
