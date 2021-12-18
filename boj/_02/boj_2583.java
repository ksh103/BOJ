package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/* boj 2583번 영역 구하기 */
public class boj_2583 {

	static int M, N, K, size = 0;
	static boolean[][] map;
	static ArrayList<Integer> list = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new boolean[N][M];
		
		while(K-->0) {
			st = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			for(int x = x1; x < x2; x++) {
				for(int y = y1; y < y2; y++) {
					map[x][y] = true;
				}
			}
		}
		
		int cnt = 0;
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < M; y++) {
				if (!map[x][y]) {
					cnt++; // 영역 개수 
					size = 0; // 영역 넓이 초기화
					solve(x, y);
					list.add(size);
				}
			}
		}
		
		Collections.sort(list); // 오름차순
		sb.append(cnt).append("\n");
		
		for (int n : list) {
			sb.append(n).append(" ");
		}
		
		System.out.println(sb);

	}
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static void solve(int x, int y) {
		
		map[x][y] = true; // 방문처리
		size++; // 영역 넓이
		
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny]) continue;

			solve(nx, ny);
		}
	}
}
