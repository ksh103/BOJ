package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/* boj 11559번 Puyo Puyo */
public class boj_11559 {

	static int N = 12, M = 6, bombCnt;
	static boolean isBomb;
	static char[][] map = new char[N][M];
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		
		bombCnt = 0;
		while(true) {
			isBomb = false;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] != '.') pang(i, j);
				}
			}
			downFall();
			if(isBomb) bombCnt++;
			else break;
		}
		System.out.println(bombCnt);
	}
	
	// 뿌요뿌요 터트리기.
	static void pang(int x, int y) { 
		Queue<Node> queue = new LinkedList<>();
		ArrayList<Node> list = new ArrayList<>();
		
		boolean[][] visited = new boolean[N][M];
		
		queue.offer(new Node(x, y));
		
		visited[x][y] = true;
		int cnt = 1;
		
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			
			list.add(new Node(n.x, n.y));
			for (int i = 0; i < 4; i++) {
				int nx = n.x + dx[i];
				int ny = n.y + dy[i];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if(visited[nx][ny] || map[nx][ny] != map[n.x][n.y]) continue;
				
				cnt++;
				visited[nx][ny] = true;
				
				queue.offer(new Node(nx, ny));
				
			}
		}
		if(cnt >= 4) {
			for (int k = 0; k < list.size(); k++) {
				map[list.get(k).x][list.get(k).y] = '.';
				isBomb = true;
			}
		}
	}
	
	// 터트리고 빈공간이 생기면 내리기
	static void downFall() {
		for (int i = 11; i > 0; i--) {
			for (int j = 0; j < 6; j++) {
				if (map[i][j] == '.') {
					for (int k = i-1; k >= 0; k--) {
						if (map[k][j] != '.') {
							map[i][j] = map[k][j];
							map[k][j] = '.';
							break;
						}
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