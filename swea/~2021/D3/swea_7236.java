package com.swea.im;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* swea 7236번 저수지의 물의 총 깊이 구하기 (D3) */
public class swea_7236 {
	
	static int N;
	static char[][] map;
	
	static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0}; // 8방 탐색
	static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= testCase; t++) {
			
			N = Integer.parseInt(br.readLine());
			
			map = new char[N][N];
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = st.nextToken().charAt(0);
				}
			}
			
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					
					int cnt = 0;
					for (int d = 0; d < 8; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];
							
						if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
						if(map[nx][ny] == 'W') cnt++;
					}
					max = Math.max(max, cnt);
				}
			}
			System.out.println("#" + t + " " + max);
		}
	}
	
}
