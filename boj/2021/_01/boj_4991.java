package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* boj 4491번 로봇 청소기 */
public class boj_4991 {

	static int w, h, dust;
	static int[][] map;
	static boolean[][][] visit;
	
	static Queue<Node> queue = new LinkedList<>();
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(w == 0 && h == 0) break; // 종료
			
			map = new int[h][w];
			visit = new boolean[h][w][1<<10];
			
			int cnt = dust = 0;
			for (int i = 0; i < h; i++) {
				Arrays.fill(map[i], -1);
				String input = br.readLine();
				for (int j = 0; j < w; j++) {
					char c = input.charAt(j);
					
					if(c == 'o') { // 로봇의 시작 위치
						queue.offer(new Node(i, j, 0, 0));
						visit[i][j][0] = true;
					}
					if(c == '*') {
						dust++;
						map[i][j] = cnt++;
					}
					if(c == 'x') map[i][j] = -2;
				}
			}
			System.out.println(bfs());
			queue.clear();
		}
	}
	
	static int bfs() {
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			
			// 청소완료
			if(n.clean == (1 << dust)-1) return n.cnt;
			
			// 탐색
			for (int d = 0; d < 4; d++) {
				int nx = n.x + dx[d];
				int ny = n.y + dy[d];
				int clean = n.clean;
				
				if(nx < 0 || nx >= h || ny < 0 || ny >= w || visit[nx][ny][clean] || map[nx][ny] == -2) continue;
				
				// 청소하기
				if(map[nx][ny] >= 0) clean = n.clean | (1 << map[nx][ny]);
				
				visit[nx][ny][clean] = true;
				queue.offer(new Node(nx, ny, n.cnt+1, clean));
			}
		}
		return -1;
	}
	
	static class Node{
		int x, y, cnt, clean;
		
		public Node(int x, int y, int cnt, int clean) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.clean = clean;
		}
	}

}
