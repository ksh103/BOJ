package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* boj 7562번 나이트의 이동 */
public class boj_7562 {

	static int l, strX, strY, endX, endY;
	static int[][] map;
	static Queue<Point> queue = new LinkedList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			l = Integer.parseInt(br.readLine());
			
			map = new int[l][l];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			strX = Integer.parseInt(st.nextToken());
			strY = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			endX = Integer.parseInt(st.nextToken());
			endY = Integer.parseInt(st.nextToken());
			
			solve();
			System.out.println(map[endX][endY]);
			
		}
	}
	
	static int[] dx = {1, 2, 1, 2, -1, -2, -1, -2};
	static int[] dy = {2, 1, -2, -1, -2, -1, 2, 1};
	static void solve() {
		
		if(strX == endX && strY == endY) return;
		
		queue.offer(new Point(strX, strY));

		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			for (int d = 0; d < 8; d++) {
				int nx = p.x + dx[d];
				int ny = p.y + dy[d];
				
				if(nx < 0 || nx >= l || ny < 0 || ny >= l) continue;
				
				if(map[nx][ny] == 0) {
					queue.offer(new Point(nx, ny));
					map[nx][ny] = map[p.x][p.y] + 1;
				}
			}
		}
	}
	
	static class Point {
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
