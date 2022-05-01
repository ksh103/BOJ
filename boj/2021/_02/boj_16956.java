package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* boj 16956번 늑대와 양 */
public class boj_16956 {

	static int R, C;
	static char[][] map;
	static Queue<Point> queue = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = input.charAt(j);

				if(map[i][j] == 'W') queue.offer(new Point(i, j)); // 늑대의 위치
			}
		}
		if(solve()) {
			System.out.println(1);
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}else {
			System.out.println(0);
		}
	}
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static boolean solve() {
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			for (int d = 0; d < 4; d++) {
				int nx = p.x + dx[d];
				int ny = p.y + dy[d];
				
				if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
				
				if(map[nx][ny] == '.') map[nx][ny] = 'D'; // 울타리 설치		
				if(map[nx][ny] == 'S') return false; // 늑대가 이동하는 과정에서 양을 만나면 안 됨!
			}
		}
		return true;
	}
	
	static class Point{
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
