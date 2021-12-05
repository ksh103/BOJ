package com.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* swea 1961번 숫자 배열 회전(D2) */
public class swea_1961 {

	static int T, N;
	static int[][] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			
			arr = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			sb.append("#" + t + " " + "\n");
			
			for (int i = 0; i < N; i++) {
				for (int j = N-1; j >= 0; j--) {
					sb.append(arr[j][i]);
				}
				
				sb.append(" ");
				for (int j = N-1; j >= 0; j--) {
					sb.append(arr[N-i-1][j]);
				}
				
				sb.append(" ");
				for (int j = N-1; j >= 0; j--) {
					sb.append(arr[N-j-1][N-i-1]);
				}
				
				sb.append("\n");
			}
			
			System.out.print(sb);
			sb.setLength(0);
		}
	}
}
