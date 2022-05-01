package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* boj 2234번 성곽 */
public class boj_2234 {

	static int N, M, maxSize = Integer.MIN_VALUE;
	static int[][] map;
	static boolean[][] visit;
	
	// 좌 상 우 하
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {-1, 0, 1, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visit = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int roomCnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(!visit[i][j]) {
					bfs(i, j);
					roomCnt++;
				}
			}
		}
		
		System.out.println(roomCnt);
		System.out.println(maxSize);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				breakWall(i, j);
			}
		}
		System.out.println(maxSize);
	}
	
	static void breakWall(int x, int y) {
		for (int k = 0; k < 4; k++) {
			if((map[x][y] & (1 << k)) != 0) {
				visit = new boolean[N][M];
				map[x][y] -= (1 << k);
				bfs(x, y);
				map[x][y] += (1 << k);
			}
		}
	}
	
	static void bfs(int x, int y) {
		Queue<Node> queue = new LinkedList<>();
		 
		queue.offer(new Node(x, y));
		visit[x][y] = true;
		int roomSize = 1;
		
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			
			for (int d = 0; d < 4; d++) {
				int nx = n.x + dx[d];
				int ny = n.y + dy[d];
				
				if((map[n.x][n.y] & (1 << d)) != 0) continue;
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M || visit[nx][ny]) continue;
				
				visit[nx][ny] = true;
				queue.offer(new Node(nx, ny));
				roomSize++;
			}
		}
		maxSize = Math.max(maxSize, roomSize);
	}
	
	static class Node{
		int x, y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}

/* https://coder-in-war.tistory.com/entry/%EA%B0%9C%EB%85%90-53-%EB%B9%84%ED%8A%B8%EB%A7%88%EC%8A%A4%ED%82%B9bit-mask */
