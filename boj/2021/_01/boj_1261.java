package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/* boj 1261번 알고스팟 */
public class boj_1261 {

	static int N, M, min;
	static int[][] map, distance;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		
		for (int i = 0; i < M; i++) {
			String input = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}
		min = Integer.MAX_VALUE;
		dijkstra(0, 0);
		System.out.println(min);
	}
	
	static void dijkstra(int x, int y) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[][] visit = new boolean[M][N];
		
		pq.offer(new Node(x, y, 0));

		while(!pq.isEmpty()) {
			Node n = pq.poll();
			
			if(n.x == M-1 && n.y == N-1) {
				min = Math.min(min, n.cost);
				return;
			}
			for (int d = 0; d < 4; d++) {
				int nx = n.x + dx[d];
				int ny = n.y + dy[d];
				
				if(nx < 0 || nx >= M || ny < 0 || ny >= N || visit[nx][ny]) continue;
				
				visit[nx][ny] = true;
				
				// 0-1 너비 우선 탐색
				if(map[nx][ny] == 1) pq.offer(new Node(nx, ny, n.cost + 1));
				else pq.offer(new Node(nx, ny, n.cost)); 
			}
		}
	}
	
	static class Node implements Comparable<Node>{
		int x, y, cost;
		public Node(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
}
