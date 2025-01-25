package com.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

/* swea 1249번 보급로 (D4) */
public class swea_1249 {

	static int T, N, min;
	static int[][] map, distance;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			distance = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				String input = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = input.charAt(j) - '0';
				}
			}
			min = Integer.MAX_VALUE;
			dijkstra();
			System.out.println("#" + t + " " + min);
		}
	}
	
	static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[][] visit = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			Arrays.fill(distance[i], Integer.MAX_VALUE);
		}
		
		distance[0][0] = map[0][0];
		pq.offer(new Node(0, 0, distance[0][0]));
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			
			if(n.x == N-1 && n.y == N-1) {
				min = Math.min(min, distance[N-1][N-1]);
				return;
			}
			
			if(visit[n.x][n.y]) continue;
			visit[n.x][n.y]  = true;
			
			for (int d = 0; d < 4; d++) {
				int nx = n.x + dx[d];
				int ny = n.y + dy[d];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				
				if(!visit[nx][ny] && distance[nx][ny] > distance[n.x][n.y] + map[nx][ny]) {
					distance[nx][ny] = distance[n.x][n.y] + map[nx][ny];
					pq.offer(new Node(nx, ny, distance[nx][ny]));
				}
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
