package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 1236번 성 지키기 */
public class boj_1236 {

	static int N, M;
	static char[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		
		/* 행 탐색 */
		int rowCnt = 0;
		for (int i = 0; i < N; i++) {
			boolean flag = true;
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 'X') { // 경비원이 있을 때
					flag = false;
					break;
				}
			}
			if(flag) rowCnt++;
		}
		
		/* 열 탐색 */
		int colCnt = 0;
		for (int i = 0; i < M; i++) {
			boolean flag = true;
			for (int j = 0; j < N; j++) {
				if(map[j][i] == 'X') { // 경비원이 있을 때
					flag = false;
					break;
				}
			}
			if(flag) colCnt++;
		}
		System.out.println(Math.max(rowCnt, colCnt));
	}
}