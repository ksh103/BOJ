package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* boj 2206번 벽 부수고 이동하기 */
public class boj_2206 {

	static int N, M, result;
	static int[][] map, visited;
	
	static Queue<Node> queue = new LinkedList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new int[N][M];
		
		result = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j) - '0';
				visited[i][j] = Integer.MAX_VALUE; // 무한대로 초기화 해줘야 됨.
			}
		}

		System.out.println(bfs() ? result : -1);
	}
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static boolean bfs() {
		
		queue.offer(new Node(0, 0, 1, 0));
		visited[0][0] = 0;
		
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			
			if(n.x == N-1 && n.y == M-1) {
				result = n.cnt;
				return true;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = n.x + dx[i];
				int ny = n.y + dy[i];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] <= n.crash) continue;

				// 이동 가능
				if(map[nx][ny] == 0) { 
					visited[nx][ny] = n.crash;
					queue.offer(new Node(nx, ny, n.cnt + 1, n.crash));
				}
				// 벽이 있고 아직 벽을 부수지 않았을 경우
				else if(map[nx][ny] == 1 && n.crash == 0) {
					visited[nx][ny] = n.crash + 1;
					queue.offer(new Node(nx, ny, n.cnt + 1, n.crash + 1));
				}
			}
		}
		return false;
	}
	
	static class Node{
		int x, y, cnt, crash ; // x, y, 부서진 벽의 수, 벽이 부서졌는지 안 부서졌는지
		public Node(int x, int y, int cnt, int wall) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.crash = wall;
		}
	}
}
