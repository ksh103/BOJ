package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 2580번 스도쿠 */
public class boj_2580 {
	
	static int SIZE = 9;
	static int[][] map = new int[SIZE][SIZE];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i < SIZE; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < SIZE; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		sudoku(0, 0);
	}
	
	// 스도쿠
	static void sudoku(int row, int col) {
		
		if(col == SIZE) {
			sudoku(row + 1, 0);
			return;
		}
		
		if(row == SIZE) {
			for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < SIZE; j++) {
					sb.append(map[i][j]).append(" ");
				}
				sb.append("\n");
			}
			System.out.println(sb);
			System.exit(0);
		}
		
		// 0은 스도쿠 판의 빈 칸을 의미
		if(map[row][col] == 0) {
			for (int i = 1; i <= SIZE; i++) {
				// 중복 검사
				if(check(row, col, i)) {
					map[row][col] = i;
					sudoku(row, col + 1);
				}
			}
			map[row][col] = 0;
			return;
		}
		
		sudoku(row, col + 1);
		
	}
	// 중복 확인
	static boolean check(int row, int col, int num) {
		/* 조건 1. 각각의 가로줄과 세로줄에는 1부터 9까지의 숫자가 한 번씩만 나타나야 한다. */
		
		// 같은 행에 있는 원소들 중 겹치는 열이 있는지 확인 
		for (int i = 0; i < SIZE; i++) {
			if(map[row][i] == num) {
				return false;
			}
		}
		
		// 같은 열에 있는 원소들 중 겹치는 행이 있는지 확인
		for (int i = 0; i < SIZE; i++) {
			if(map[i][col] == num) {
				return false;
			}
		}
		
		/* 조건 2. 굵은 선으로 구분되어 있는 3x3 정사각형 안에도 1부터 9까지의 숫자가 한 번씩만 나타나야 한다. */
		// 3 x 3 칸에 중복되는 원소가 있는지 확인
		int setRow = (row / 3) * 3;
		int setCol = (col / 3) * 3;
		
		for(int i = setRow; i < setRow + 3; i++) {
			for(int j = setCol; j < setCol + 3; j++) {
				if(map[i][j] == num) {
					return false;
				}
			}
		}
		return true;
	}
}
