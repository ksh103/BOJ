package com.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* swea 1979번 어디에 단어가 들어갈 수 있을까 (D2) */
public class swea_1979 {

	static int N, K;
	static int[][] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken()); // 특정 길이
			
			arr = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int cnt = 0, res = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(arr[i][j] == 1) {
						cnt++;
					}else {
						if(cnt == K) res++;
						cnt = 0;
					}
				}
				if(cnt == K) res++;
				cnt = 0;
			}
			
			cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(arr[j][i] == 1) {
						cnt++;
					}else {
						if(cnt == K) res++;
						cnt = 0;
					}
				}
				if(cnt == K) res++;
				cnt = 0;
			}
			System.out.println("#" + t + " " + res);
		}
	}
}
