package com.boj;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* boj 7569번 토마토 */
public class boj_7569 {

	static int M, N, H, day;
	static int[][][] map;

	static Queue<Node> queue = new LinkedList<>();
	
	static int[] dx = {0, 0, -1, 1, 0, 0};
	static int[] dy = {0, 0, 0, 0, -1, 1};
	static int[] dz = {-1, 1, 0, 0, 0, 0};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][N][M];
		
		for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				for (int m = 0; m < M; m++) {
					map[h][n][m] = Integer.parseInt(st.nextToken());
					if(map[h][n][m] == 1) queue.offer(new Node(h, n, m));
				}
			}
		}
		System.out.println(daySum());
	}
	
	static void bfs() {
		
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			
			for (int d = 0; d < 6; d++) {
				int nz = n.z + dz[d];
				int nx = n.x + dx[d];
				int ny = n.y + dy[d];
				
				if(nz < 0 || nz >= H || nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				
				if(map[nz][nx][ny] == 0) {
					map[nz][nx][ny] = map[n.z][n.x][n.y] + 1;
					queue.offer(new Node(nz, nx, ny));
				}
			}
		}
	}
	
	static int daySum() {
		bfs();
		
		int result = Integer.MIN_VALUE;
		
		for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < M; m++) {
					if(map[h][n][m] == 0) return -1;
					
					result = Math.max(result, map[h][n][m]);
				}
			}
		}
		
		if(result == 1) return 0;
		else return result - 1;
	}

	static class Node{
		int z, x, y;
		public Node(int z, int x, int y) {
			this.z = z;
			this.x = x;
			this.y = y;
		}
	}
}
