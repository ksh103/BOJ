package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* boj 1194번 달이 차오른다,가자 */
/* 비트마스킹 */
public class boj_1194 {

	static int N, M, sx, sy;
	static char[][] map;
	static boolean[][][] visited; 
	
	static Queue<Node> queue = new LinkedList<>();
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		visited = new boolean[N][M][1<<6]; // 열쇠,문이 6개
		
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j);
				
				// 민식이의 현재 위치
				if(map[i][j] == '0') {
					sx = i; sy = j;
				}
			}
		}
		System.out.println(bfs(sx, sy));
	}
	
	static int bfs(int sx, int sy) {
	
		queue.offer(new Node(sx, sy, 0, 0));
		visited[sx][sy][0] = true;
		
		while(!queue.isEmpty()) {
			Node n = queue.poll();
		
			// 출구 : 미로 탈출
			if(map[n.x][n.y] == '1') return n.cnt;
		
			// 탐색
			for (int d = 0; d < 4; d++) {
				int nx = n.x + dx[d];
				int ny = n.y + dy[d];
				int key = n.bit; // 탐색 구문 안에 선언
				
				// 범위를 벗어나고 벽(#)일 때 이동 x
				if(nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == '#' || visited[nx][ny][n.bit]) continue;
				
				// 열쇠가 있는 곳에 도착했을 때 (a~f)
				if('a' <= map[nx][ny] && map[nx][ny] <= 'f') {
					key = n.bit | (1 << (map[nx][ny] - 'a'));
				}
				
				// 문이 있는 곳에 도착했을 때 (열쇠에 대응되어야 됨. (A~F))
				if('A' <= map[nx][ny] && map[nx][ny] <= 'F') {
					if((key & (1 << (map[nx][ny] - 'A'))) == 0) continue;
				}
				
				if(visited[nx][ny][key]) continue;
				
				visited[nx][ny][key] = true;
				queue.offer(new Node(nx, ny, key, n.cnt+1));
			}
		}
		return -1;
	}
	
	static class Node{
		int x, y, bit, cnt;
		public Node(int x, int y, int bit, int cnt) {
			this.x = x;
			this.y = y;
			this.bit = bit;
			this.cnt = cnt;
		}
	}
}
