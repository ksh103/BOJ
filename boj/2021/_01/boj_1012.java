package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* boj 1012번 유기농 배추 */
public class boj_1012 {

	static int T, M, N, K, cnt;
	static int[][] map;
	
	static Queue<Node> queue = new LinkedList<>();
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			M = Integer.parseInt(st.nextToken()); // 가로 
			N = Integer.parseInt(st.nextToken()); // 세로
			K = Integer.parseInt(st.nextToken()); // 배추가 심어져 있는 위치의 개수
			
			map = new int[N][M];

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				map[b][a] = 1;
			}
			
			cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] == 1) {
						queue.offer(new Node(i, j));
						cnt++;
						bfs();
					}
				}
			}
			System.out.println(cnt);
		}
	}
	
	static void bfs() {
		
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			
			for (int d = 0; d < 4; d++) {
				int nx = n.x + dx[d];
				int ny = n.y + dy[d];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == 0) continue;
				map[nx][ny] = 0;
				queue.offer(new Node(nx, ny));
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
