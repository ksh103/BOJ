package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* boj 2447번 별 찍기 - 10 */
public class boj_2447 {

	static int N;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				check(i, j, N);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static void check(int x, int y, int size) {
		if((x / size) % 3 == 1 && (y / size) % 3 == 1) {
			sb.append(" ");
		}else {
			if(size / 3 == 0) {
				sb.append("*");
			}else {
				check(x, y, size/3);
			}
		}
	}
}
