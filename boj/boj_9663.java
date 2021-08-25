package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* boj 9663번 N-Queen */
public class boj_9663 {

	static int N, cnt;
	static int[] col;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		col = new int[N+1]; // 퀸이 놓이는 열
		setQueens(0);
		System.out.println(cnt);
		
	}
	static void setQueens(int num) {
		if(!isAvailable(num)) return;
		
		if(num == N) { // 모든 행에 퀸을 뒀을 때
			cnt++;
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			col[num + 1] = i;
			setQueens(num + 1);
		}
	}

	static boolean isAvailable(int num) {
		for (int i = 1; i < num; i++) {
			// 같은 열에 퀸이 존재하거나 대각선에 위치한 경우
			if(col[num] == col[i] ||
					Math.abs(col[num] - col[i]) == (num - i)) return false;
		}
		return true;
	}
}
