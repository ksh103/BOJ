package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* boj 2178번 미로 탐색 */
/* DFS 사용 */
public class boj_2178 {
	
	static int N, M, cnt;
	static int[][] map, visited;

	static Queue<Node> queue = new LinkedList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			String input = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j) -'0';
			}
		}
		dfs(0, 0);
		System.out.println(visited[N-1][M-1]);
	}
	
	static int[] dx = {-1, 1, 0, 0}; // 상 하 좌 우 
	static int[] dy = {0, 0, -1, 1};
	static void dfs(int y, int x) {
		queue.offer(new Node(y, x));
		visited[y][x] = 1; // 첫번째 좌표 방문 표시
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			for(int i = 0; i < 4; i++) {
				int ny = node.y + dy[i];
				int nx = node.x + dx[i];
				
				if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
				if(map[ny][nx] != 1) continue;
				visited[ny][nx] = visited[node.y][node.x] + 1; // 방문 처리
				queue.offer(new Node(ny, nx));
				map[ny][nx] = 0; // 지나간 곳은 0으로 처리(boolean보다 속도가 빠름)
				

			}
		}
	}
	static class Node{
		int y, x;
		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}