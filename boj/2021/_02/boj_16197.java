package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/* boj 16197번 두 동전 */
public class boj_16197 {

	static int N, M, result = Integer.MAX_VALUE;
	static char[][] map;
	static ArrayList<Point> list = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j);
				
				if(map[i][j] == 'o') list.add(new Point(i, j));
			}
		}
		solve(list.get(0).x, list.get(0).y, list.get(1).x, list.get(1).y, 0);
		
		if(result == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(result);
	}
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static void solve(int x1, int y1, int x2, int y2, int push) {
		
		// 동전은 10번보다 많이 누르면 안 됨.
		if(push > 10) return;

		// 둘 다 범위에서 벗어날때
		if(!rangeCheck(x1, y1) && !rangeCheck(x2, y2)) return; 
		
		// 두 동전 중 하나만 보드에서 떨어질 때
		if((rangeCheck(x1, y1) && !rangeCheck(x2, y2)) || (!rangeCheck(x1, y1) && rangeCheck(x2, y2))) {
			result = Math.min(result, push); // 동전 버튼 누른 횟수 반환
			return;
		}
		
		for (int d = 0; d < 4; d++) {
			int nx1 = x1 + dx[d];
			int ny1 = y1 + dy[d];
			int nx2 = x2 + dx[d];
			int ny2 = y2 + dy[d];
			
			// 동전이 범위 내에 있고 이동하려는 칸이 벽이면 동전은 이동하지 않음.
			if(rangeCheck(nx1, ny1) && map[nx1][ny1] == '#') {
				nx1 = x1;
				ny1 = y1;
			}
			
			// 동전이 범위 내에 있고 이동하려는 칸이 벽이면 동전은 이동하지 않음.
			if(rangeCheck(nx2, ny2) && map[nx2][ny2] == '#') {
				nx2 = x2;
				ny2 = y2;
			}
			solve(nx1, ny1, nx2, ny2, push + 1);
		}

	}
	
	static boolean rangeCheck(int x, int y) {
		if(x < 0 || x >= N || y < 0 || y >= M) return false;
		
		return true;
	}
	
	static class Point {
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
