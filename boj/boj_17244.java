package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* boj 17244번 아맞다우산 */
public class boj_17244 {

	static int N, M, sx, sy, ex, ey, cnt;
	static char[][] map;
	static boolean[][][] visited;

	static Queue<Node> queue = new LinkedList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[M][N];
		
		cnt = 0;
		for (int i = 0; i < M; i++) {
			String input = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = input.charAt(j);

				if(map[i][j] == 'S') sx = i; sy = j;
				if(map[i][j] == 'X') map[i][j] = (char) (cnt++ + '0');
			}	
		}
		bfs(sx, sy);
	}

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static void bfs(int sx, int sy){
		
		visited = new boolean[M][N][(1<<cnt)];
		
		queue.offer(new Node(sx, sy, 0, 0));
		
		visited[sx][sy][0] = true;
		
		while(!queue.isEmpty()){
			Node n = queue.poll();
			
			if(map[n.x][n.y] == 'E' && visited[n.x][n.y][(1<<cnt)-1]) {
				System.out.println(n.cnt);
				return;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = n.x + dx[i];
				int ny = n.y + dy[i];
				
				
				if(nx < 0 || nx >= M || ny < 0 || ny >= N || map[nx][ny] == '#' || visited[nx][ny][n.bit]) continue;
				
				if(map[nx][ny] >= '0' && map[nx][ny] < '5') {
					int idx = n.bit | (1 << (map[nx][ny] - '0'));
					
					if(visited[nx][ny][idx]) continue;
					visited[nx][ny][idx] = true;
					queue.offer(new Node(nx, ny, n.cnt+1, idx));
				}else {
					if(visited[nx][ny][n.bit]) continue;
					visited[nx][ny][n.bit] = true;
					queue.offer(new Node(nx, ny, n.cnt+1, n.bit));
				}
			}
		}
	}
	
	static class Node{
		int x, y, cnt, bit;
		public Node(int x, int y, int cnt, int bit){
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.bit = bit;
		}
	}
}

/* https://ckdgus.tistory.com/38 */
