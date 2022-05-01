package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 1018번 체스판 다시 칠하기 */
public class boj_1018 {

	static int N, M;
	static char[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			} 
		}

		int result = Integer.MAX_VALUE;
		for (int i = 0; i <= N - 8; i++) {
			for (int j = 0; j <= M - 8; j++) {
				result = Math.min(result, solve(i, j));
			}
		}
		System.out.println(result);
	}
	
	static int solve(int x, int y) {
		
		char s1 = 'B';
		int cnt1 = 0;
		for (int i = x; i < 8 + x; i++) {
			if(map[i][y] != s1) cnt1++;
			for (int j = y + 1; j < 8 + y; j++) {
				if(map[i][j] == s1) {
					cnt1++;
					if(s1 == 'W') {
						s1 = 'B';
					}else {
						s1 = 'W';
					}	
				}else {
					s1 = map[i][j];
				}
			}
		}
		
		char s2 = 'W';
		int cnt2 = 0;
		for (int i = x; i < 8 + x; i++) {
			if(map[i][y] != s2) cnt2++;
			for (int j = y + 1; j < 8 + y; j++) {
				if(map[i][j] == s2) {
					cnt2++;
					if(s2 == 'B') {
						s2 = 'W';
					}else {
						s2 = 'B';
					}
				}else {
					s2 = map[i][j];
				}
			}
		}
		return cnt1 > cnt2 ? cnt2 : cnt1;
	}
}
