package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/* boj 2665번 미로만들기 */
public class boj_2665 {

	static int N;
	static int[][] map, distance;

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		distance = new int[N][N];
	
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = input.charAt(j) - '0';
				
				Arrays.fill(distance[i], Integer.MAX_VALUE);
			}
		}
		dijkstra();
		System.out.println(distance[N-1][N-1]);
	}
	
	static void dijkstra() {
		
		Queue<Node> pq = new LinkedList<>();

		pq.offer(new Node(0, 0));
		distance[0][0] = 0;
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
				
			for (int d = 0; d < 4; d++) {
				int nx = n.x + dx[d];
				int ny = n.y + dy[d];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				
				if(map[nx][ny] == 0) {
					if(distance[nx][ny] > distance[n.x][n.y] + 1) {
						distance[nx][ny] = distance[n.x][n.y] + 1;
						pq.offer(new Node(nx, ny));
					}
				}else {
					if(distance[nx][ny] > distance[n.x][n.y]) {
						distance[nx][ny] = distance[n.x][n.y];
						pq.offer(new Node(nx, ny));
					}
				}
			}
		}
	}
	
	static class Node{
		int x, y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
