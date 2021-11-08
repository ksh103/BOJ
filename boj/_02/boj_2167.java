package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 2167번 2차원 배열의 합 */
public class boj_2167 {
	
	static int N, M, K, i, j, x, y;
	static int[][] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1][M+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		K = Integer.parseInt(br.readLine());
		
		while(K-->0) {
			st = new StringTokenizer(br.readLine());
			
			i = Integer.parseInt(st.nextToken());
			j = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			
			int sum = 0;
			for (int n = i; n <= x; n++) {
				for (int m = j; m <= y; m++) {
					sum += arr[n][m];
				}
			}
			System.out.println(sum);
		}
	}
}
