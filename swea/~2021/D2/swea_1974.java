package com.swea.im;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* swea 1974번 스도쿠 검증  (D2)*/
public class swea_1974 {

	static int testCase;
	static int[][] sudoku = new int[9][9];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		testCase = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= testCase; t++) {
			
			for(int i = 0; i < 9; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 9; j++) {
					sudoku[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			System.out.println("#" + t + " " + (solve() ? 0 : 1));
		}
	}
	
	static boolean solve() {
		// 행 체크
		for (int i = 0; i < 9; i++) {
			int[] count = new int[10];
			for (int j = 0 ; j < 9; j++) {
				if(count[sudoku[i][j]] == 1) {
					return true;
				}else {
					count[sudoku[i][j]] = 1;
				}
			}
			
		}
		// 열 체크
		for (int i = 0; i < 9; i++) {
			int[] count = new int[10];
			for (int j = 0; j < 9; j++) {
				if(count[sudoku[j][i]] == 1) {
					return true;
				
				}else {
					count[sudoku[j][i]] = 1;
				}
			}
		}
		// 격자 체크(3*3)
		for (int startX = 0; startX < 9; startX+=3) {
			for (int startY = 0; startY < 9; startY+=3) {
				int[] count = new int[10];
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						if (count[sudoku[startX + i][startY + j]] == 1) {
							return true;
						}else {
							count[sudoku[startX + i][startY + j]] = 1;
						}
					}
				}
				
			}
		}
		return false;
	}
}
