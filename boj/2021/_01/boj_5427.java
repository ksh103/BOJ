package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* boj 5427번 불 */
public class boj_5427 {

	static int T, w, h;
	static char[][] map;
	static boolean[][] fireCheck;
	static boolean[][] visited;

	static Queue<Node> loc, fire;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			loc = new LinkedList<>();
			fire = new LinkedList<>();
			
			map = new char[h][w];
			fireCheck = new boolean[h][w];
			visited = new boolean[h][w];
			
			for (int i = 0; i < h; i++) {
				String input = br.readLine();
				for (int j = 0; j < w; j++) {
					map[i][j] = input.charAt(j);
					
					if(map[i][j] == '@') loc.offer(new Node(i, j, 0));
					if(map[i][j] == '*') fire.offer(new Node(i, j, 0));
				}
			}
			
			System.out.println(location() ? sb : "IMPOSSIBLE");
			sb.setLength(0);
		}
	}
	
	static void fire_location() {
		int size = fire.size();
		
		for (int i = 0; i < size; i++) {
			Node n = fire.poll();
			
			for (int d = 0; d < 4; d++) {
				int nx = n.x + dx[d];
				int ny = n.y + dy[d];

				 //벽에는 불이 붙지 않는다.
				 //벽을 통과할 수 없다 

				if(nx < 0 || nx >= h || ny < 0 || ny >= w || fireCheck[nx][ny]) continue;
				if(map[nx][ny] == '#' || map[nx][ny] == '*') continue;
				
				map[nx][ny] = '*';
				fireCheck[nx][ny] = true;
				fire.offer(new Node(nx, ny, 0));
			}
		}
	}
	
	static boolean location() {
		
		while(!loc.isEmpty()) {
			fire_location();
			int size = loc.size();
			
			for (int i = 0; i < size; i++) {
				Node n = loc.poll();
				
				for (int d = 0; d < 4; d++) {
					int nx = n.x + dx[d];
					int ny = n.y + dy[d];
					
					if(nx < 0 || nx >= h || ny < 0 || ny >= w) {
						sb.append(n.cnt+1);
						return true;
					}
					
					if(visited[nx][ny] || map[nx][ny] == '*' || map[nx][ny] == '#') continue;
					
					map[nx][ny] = '@';
					visited[nx][ny] = true;
					loc.offer(new Node(nx, ny, n.cnt+1));
				}
			}
		}
		return false;
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
