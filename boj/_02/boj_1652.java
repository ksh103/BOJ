package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* boj 1652번 누울 자리를 찾아라 */
public class boj_1652 {

	static int N;
	static char[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 방 : NxN 정사각형 모양
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		
		// 옮길 수 없는 짐들이 많아서 영식이가 누울 자리가 없음
		// 누울 수 있는 조건 : 똑바로 연속해서 2칸 이상 빈 칸이 존재 (가로 세로 가능)
		// 1. 벽을 만나면 누울 공간 확인
		// 2. 벽 끝까지 탐색하고 나서 누울 공간 확인
		int rowCnt = 0;
		for (int i = 0; i < N; i++) {
			int cnt = 0;
			for (int j = 0; j < N; j++) {
				if(map[i][j] == '.') cnt++;
				else {
					if(cnt >= 2) rowCnt++;
					cnt = 0;
				}
				
				if(j == N - 1) {
					if(cnt >= 2) rowCnt++;
				}
			}
		}
		
		int colCnt = 0;
		for (int i = 0; i < N; i++) {
			int cnt = 0;
			for (int j = 0; j < N; j++) {
				if(map[j][i] == '.') cnt++;
				else {
					if(cnt >= 2) colCnt++;
					cnt = 0;
				}
				
				if(j == N - 1) {
					if(cnt >= 2) colCnt++;
				}
			}
		}
		System.out.println(rowCnt + " " + colCnt);
	}
}
