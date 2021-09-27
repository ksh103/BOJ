package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* boj 4963번 섬의 개수 */
public class boj_4963_bfs {

	static int w, h;
	static int[][] map;
	static boolean[][] visited;
	
	static Queue<Node> queue = new LinkedList<>();
	
	static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
	static int[] dy = {0, 0, -1, 1, 1, -1, 1, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			// 입력으로 0, 0이 들어오면 종료
			if(h == 0 && w == 0) break;
			
			map = new int[h][w];
			visited = new boolean[h][w];
			
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int cnt = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if(!visited[i][j] && map[i][j] == 1) {
						bfs(i, j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}	
	}
	
	static void bfs(int x, int y) {
		
		queue.offer(new Node(x, y));
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			
			for (int d = 0; d < 8; d++) {
				int nx = n.x + dx[d];
				int ny = n.y + dy[d];
				
				if(nx < 0 || nx >= h || ny < 0 || ny >= w || map[nx][ny] == 0 || visited[nx][ny]) continue;
				visited[nx][ny] = true;
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
