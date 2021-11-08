package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/* boj 4485번 녹색 옷 입은 애가 젤다지? */
public class boj_4485 {

	static int N;
	static int[][] distance, map;

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = 1;
		while(true) {
			N = Integer.parseInt(br.readLine());
			
			if(N == 0) break;
			
			map = new int[N][N];
			distance = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				Arrays.fill(distance[i], Integer.MAX_VALUE);
			}
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			System.out.println("Problem " + tc++ + ": " + dijkstra());
		}
	}
	
	static int dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[][] visited = new boolean[N][N];
		
		distance[0][0] = map[0][0];	
		pq.offer(new Node(0, 0, map[0][0]));
			
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			
			if(visited[n.x][n.y]) continue;
			visited[n.x][n.y] = true;
			
			for (int d = 0; d < 4; d++) {
				int nx = n.x + dx[d];
				int ny = n.y + dy[d];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				
				if(!visited[nx][ny] && distance[nx][ny] > distance[n.x][n.y] + map[nx][ny]) {
					distance[nx][ny] = distance[n.x][n.y] + map[nx][ny];
					pq.offer(new Node(nx, ny, distance[nx][ny]));
				}
			}
		}
		return distance[N-1][N-1];
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
