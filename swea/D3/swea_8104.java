package com.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* swea 8104번 조 만들기 (D3) */
public class swea_8104 {

	static int N, K;
	static int[][] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken()); // 명
			K = Integer.parseInt(st.nextToken()); // 조
			
			arr = new int[N + 1][K];
			
			int cnt = 1;
			for (int i = 1; i <= N; i++) {
				// 짝수는 역순으로
				if(i % 2 == 0) { 
					for (int j = K - 1; j >= 0; j--) {
						arr[i][j] = cnt;
						cnt++;
					}
				}else {
					for (int j = 0; j < K; j++) {
						arr[i][j] = cnt;
						cnt++;
					}
				}
			}
			
			sb.append("#" + t + " ");
			for (int i = 0; i < K; i++) {
				int sum = 0;
				for (int j = 1; j <= N; j++) {
					sum += arr[j][i];
				}
				sb.append(sum).append(" ");
			}
			System.out.println(sb);
			sb.setLength(0);
		}
	}
}
