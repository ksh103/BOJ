package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* boj 17144번 미세먼지 안녕 */
public class boj_17144 {

	static int R, C, T;
	static int[] airCleaner;
	static int[][] map;
	
	static Queue<Node> queue = new LinkedList<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		airCleaner = new int[2];
		int idx = 0;
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == -1) {
					airCleaner[idx++] = i;
				}
			}
		}
		
		// T초만큼 돌리기
		while(T-->0) {	
			spread();
			move();
		}
		System.out.println(sum());
	}
	
	static int[] dr = {-1, 0, 0, 1}; // 상 우 좌 하
	static int[] dc = {0, 1, -1, 0};
	static void spread() { // 미세먼지 확산

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] != 0 && map[i][j] != 1) {
					queue.offer(new Node(i, j, map[i][j]));
				}
			}
		}
		
		// 미세먼지는 인접한 네 방향으로 확산
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			
			int spreadDust = n.amount / 5; // 확산되는 양 : Ar,c/5
			int dustCnt = 0;
			
			for (int d = 0; d < 4; d++) {
				int nr = n.r + dr[d];
				int nc = n.c + dc[d];
				
				// 인접한 방향에 공기청정기가 있거나, 칸이 없으면 그 방향으로는 확산 X
				if(nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] == -1) continue;

				dustCnt++; // 확산된 방향의 개수
				map[nr][nc] += spreadDust;
			}
			map[n.r][n.c] -= (spreadDust * dustCnt); 
		}
	}
	
	static int[] clock = {1, 3, 2, 0}; 
	static int[] rclock = {1, 0, 2, 3};
	
	static void move() { // 공기청정기 작동
		
		int[][] airCopy = new int[R][C];
		copy(airCopy, map);
		
		// 위쪽 공기청정기의 바람은 반시계 방향으로 순환
		int cleanerR = airCleaner[0];
		int cleanerC = 1; // 
		map[cleanerR][cleanerC] = 0; // 공기청정기에 부는 바람은 미세먼지가 없음
		
		for (int d = 0; d < 4; d++) {
			while(true) {
				int nr = cleanerR + dr[rclock[d]];
				int nc = cleanerC + dc[rclock[d]];
				
				if(nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] == -1) break;
				
				map[nr][nc] = airCopy[cleanerR][cleanerC];
				cleanerR = nr;
				cleanerC = nc;
			}
		}

		// 아래쪽 공기청정기의 바람은 시계 방향으로 순환
		cleanerR = airCleaner[1];
		cleanerC = 1;
		map[cleanerR][cleanerC] = 0; // 공기청정기에 부는 바람은 미세먼지가 없음
		
		for (int d = 0; d < 4; d++) {
			while(true) {
				int nr = cleanerR + dr[clock[d]];
				int nc = cleanerC + dc[clock[d]];
				
				if(nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] == -1) break;
				
				map[nr][nc] = airCopy[cleanerR][cleanerC];
				cleanerR = nr;
				cleanerC = nc;
			}
		}
	}
	
	static void copy(int[][] airCopy, int[][] map) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				airCopy[i][j] = map[i][j];
			}
		}
	}
	
	static int sum() {
		int sum = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] != -1) {
					sum += map[i][j];
				}
			}
		}
		return sum;
	}
	
	static class Node{
		int r, c, amount;
		public Node(int r, int c, int amount) {
			this.r = r;
			this.c = c;
			this.amount = amount;
		}
	}
}
