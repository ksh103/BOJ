package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 2630번 색종이 만들기 */
public class boj_2630 {

	static int N, white = 0, blue = 0;
	static int[][] paper;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		paper = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		divide(0, 0, N);
		
		System.out.println(white);
		System.out.println(blue);
	}
	
	static void divide(int x, int y, int size) {
		
		// 기저조건
		if(checkPaper(x, y, size)) {
			if(paper[x][y] == 0) white++;
			else blue++;
			
			return;
		}
		
		int newSize = size / 2; // 반 나누기
		
		
		// 재귀를 활용한 분할정복
		divide(x, y, newSize);
		divide(x, y + newSize, newSize);
		divide(x + newSize, y, newSize);
		divide(x + newSize, y + newSize, newSize);
	}
	
	static boolean checkPaper(int x, int y, int size) {
		
		// 색종이 색상 확인
		int color = paper[x][y];
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if(paper[i][j] != color) {
					return false; 
				}
			}
		}
		return true;
	}
}
