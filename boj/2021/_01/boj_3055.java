package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* boj 3055번 탈출 */
public class boj_3055 {

	static int R, C, result;
	static char[][] map;
	static boolean[][] waterCheck;
	static boolean[][] visited;
	
	static Queue<Node> hq = new LinkedList<>();
	static Queue<Node> wq = new LinkedList<>();
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		waterCheck = new boolean[R][C];
		visited = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = input.charAt(j);
				
				if(map[i][j] == 'S') hq.offer(new Node(i, j, 0)); // 고슴도치 위치
				if(map[i][j] == '*') wq.offer(new Node(i, j, 0)); // 물 위치
			}
		}
		
		int d = Hedgehog();
		System.out.println((d == 0) ? "KAKTUS" : d);
		
	}
	
	static void water() {
		int size = wq.size();
		
		for (int i = 0; i < size; i++) {
			Node n = wq.poll();
			
			for (int d = 0; d < 4; d++) {
				int nx = n.x + dx[d];
				int ny = n.y + dy[d];
				
				if(nx < 0 || nx >= R || ny < 0 || ny >= C || waterCheck[nx][ny]) continue;
				if(map[nx][ny] == 'X' || map[nx][ny] == 'D') continue;
				
				map[nx][ny] = '*';
				waterCheck[nx][ny] = true;
				wq.offer(new Node(nx, ny, 0));
			}
		}
	}
	
	static int Hedgehog() {
		
		while(!hq.isEmpty()) {
			water();
			int size = hq.size();
			
			for(int i = 0; i < size; i++) {
				Node n = hq.poll();
	
				for (int d = 0; d < 4; d++) {
					int nx = n.x + dx[d];
					int ny = n.y + dy[d];
					
					if(nx < 0 || nx >= R || ny < 0 || ny >= C || visited[nx][ny]) continue;
					if(map[nx][ny] == 'X' || map[nx][ny] == '*') continue;
					
					if(map[nx][ny] == 'D') {
						result = n.cnt + 1;
						return result;
					}
					
					map[nx][ny] = 'S';
					visited[nx][ny] = true;
					hq.offer(new Node(nx, ny, n.cnt + 1));
				}
			}
		}
		return 0;
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
