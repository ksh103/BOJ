package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* boj 7576번 토마토 */
public class boj_7576 {

	static int N, M, tomatoCnt, result;
	static int[][] tomato;
	static Queue<Node> queue = new LinkedList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		tomato = new int[M][N];

		tomatoCnt = 0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
				
				if(tomato[i][j] == 0) tomatoCnt++;
				else if(tomato[i][j] == 1) queue.offer(new Node(i, j, 0));
			}
		}
		
		result = -1;
		bfs();
		
		System.out.println(result);
	}
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static void bfs() {
		
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			
			if(tomatoCnt == 0) {
				result = n.cnt;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = n.x + dx[i];
				int ny = n.y + dy[i];
				
				if(nx < 0 || nx >= M || ny < 0 || ny >= N || tomato[nx][ny] != 0) continue;
	
				tomato[nx][ny] = 1;
				tomatoCnt--;
				
				queue.offer(new Node(nx, ny, n.cnt + 1));
			}
		}
	}
	
	static class Node{
		int x, y, cnt;
		public Node(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
}
