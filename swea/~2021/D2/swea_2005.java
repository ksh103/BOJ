package com.swea.im;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* swea 2005번 파스칼의 삼각형 (D2) */
public class swea_2005 {

	static int testCase, N;
	static int[][] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		testCase = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<=testCase; t++) {
			N = Integer.parseInt(br.readLine());
			
			arr = new int[N][N];
			arr[0][0] = 1; // 첫 줄은 1부터 시작
			
			for(int i = 1; i < N; i++) {
				for (int j = 0; j <= i; j++) {
					if(j == 0 || j == i) { // 두번째 줄
						arr[i][j] = 1;
					}else {
						arr[i][j] = arr[i-1][j-1] + arr[i-1][j]; 
					}
				}
			}
			
			System.out.println("#" + t);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= i; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}

	}
}
