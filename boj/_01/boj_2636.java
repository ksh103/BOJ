package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* boj 2636번 치즈 */
public class boj_2636 {

	static int h, w, cnt = 0, time = 0, result = 0;
	static int[][] cheese;
	static boolean[][] visited;
	static Queue<int[]> queue = new LinkedList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		
		cheese = new int[h][w];
		
		for (int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < w; j++) {
				cheese[i][j] = Integer.parseInt(st.nextToken());
				if(cheese[i][j] == 1) { // 치즈 구멍 개수 카운트
					cnt++;
					
				}
			}
		}
		
		// 치즈가 다 녹기 한시간 전까지 탐색
		while(cnt > 0) {
			time++;
//			System.out.println(cnt);
			result = cnt; // 다 녹기 전 치즈 구멍 개수 저장
			bfs();
		}
		
		System.out.println(time + "\n" + result);
	}
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static void bfs() {
	
		queue.offer(new int[] {0, 0});
		
		visited = new boolean[h][w];
		visited[0][0] = true;
		
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = tmp[0] + dx[i];
				int ny = tmp[1] + dy[i];
				
				if(nx < 0 || nx >= h || ny < 0 || ny >= w || visited[nx][ny]) continue;
				
				if(cheese[nx][ny] == 1) {
					cnt--;
					cheese[nx][ny] = 0;
				}else if(cheese[nx][ny] == 0) {
					queue.offer(new int[] {nx, ny});
				}
				
				visited[nx][ny] = true;
			}
		}
	}
}
