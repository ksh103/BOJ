package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 1303번 전쟁-전투 */
public class boj_1303 {
	
	static int N, M, w, b, cnt;
	static char[][] war;
	static boolean[][] visited;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		war = new char[M][N];
		visited = new boolean[M][N];
		
		for(int i = 0; i < M; i++) {
			war[i] = br.readLine().toCharArray();
		}
		
		w = 0;
		b = 0;
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					cnt = 1;
					DFS(i, j);
					if(war[i][j] == 'W') w += Math.pow(cnt, 2);
					else if(war[i][j] == 'B') b+= Math.pow(cnt, 2);
				}
				
			}
		}
		System.out.println(w + " " + b);
	}
	
	
	static int[] dx = {-1, 1, 0, 0}; // 상 하 좌 우
	static int[] dy = {0, 0, -1, 1};
	static void DFS(int y, int x) {
		
		visited[y][x] = true;
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || nx >= N|| ny < 0 || ny >= M || visited[ny][nx] || war[ny][nx] != war[y][x]) continue;
			
			DFS(ny, nx);
			cnt++;
		}
	}
}
