package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* boj 1600번 말이 되고픈 원숭이 */
public class boj_1600 {

	static int K, W, H;
	static int[][] map;
	static boolean[][][] visit;
	static Queue<Node> queue = new LinkedList<Node>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		K = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][W];
		visit = new boolean[H][W][K+1];
		
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
	}
	
	// 원숭이는 K번만 말처럼 장애물을 뛰어 넘을 수있음. --> 말이 탐색하는 것도 만들어야됨. (8방탐색)
	// 그 외에는 인접한 칸으로 움직인다. (대각선 X) --> 상하좌우 탐색
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1}; // 원숭이 : 4방 탐색
	static int[] hx = {-2, -2, 2, 2, 1, -1, 1, -1}; 
	static int[] hy = {1, -1, 1, -1, 2, 2, -2, -2}; // 말 : 8방 탐색
	static void bfs() {
		
		visit[0][0][0] = true;
		
		queue.offer(new Node(0, 0, 0, K));
		
		while(!queue.isEmpty()) {
			Node n = queue.poll();

			// 탐색 완료 (도착시)
			if(n.x == W-1 && n.y == H-1) {
				System.out.println(n.cnt);
				return;
			}
			
			if(n.x < 0 || n.x >= W || n.y < 0 || n.y >= H || map[n.y][n.x] == 1 || visit[n.y][n.x][n.horseX]) continue;
			
			visit[n.y][n.x][n.horseX] = true;
			
			// 원숭이
			for (int i = 0; i < 4; i++) {
				int nx = n.x + dx[i];
				int ny = n.y + dy[i];

				queue.offer(new Node(nx, ny, n.cnt+1, n.horseX));
			}
			
			// 말
			if(n.horseX > 0){	
				for (int i = 0; i < 8; i++) {
					int nx = n.x + hx[i];
					int ny = n.y + hy[i];
					
					queue.offer(new Node(nx, ny, n.cnt+1, n.horseX-1));
				}
			}
		}
		System.out.println(-1);
		return;
	}
	
	static class Node{
		int x, y, cnt, horseX;
		public Node(int x, int y, int cnt, int horseX) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.horseX = horseX;
		}
	}
}
