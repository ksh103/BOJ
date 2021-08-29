package com.swea.im;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* swea 2805번 농작물 수확하기 (D3) */
public class swea_2805 {
	
	static int testCase, N;
	static int[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		testCase = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= testCase; t++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				String input = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = input.charAt(j) - '0';
				}
			}
			
			int sum = 0;
			for (int i = 0; i < N; i++) {
				int start = Math.abs(N/2 - i);
				int end = N - Math.abs(N/2 - i);
//				System.out.println(i + " => " + start + " " + end);
				
				for(int j = start; j < end; j++) {
					sum += map[i][j];
				}
			}
			System.out.println("#" + t + " " + sum);
		}
	}
}
