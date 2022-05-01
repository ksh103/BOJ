package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* boj 1058번 친구 */
public class boj_1058 {

	static int N;
	static char[][] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		arr = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = input.charAt(j);
			}
		}
		
		int max = 0;
		
		// 플로이드-와샬 알고리즘
		for (int k = 0; k < N; k++) {
			int ff = 0;
			for (int i = 0; i < N; i++) {
				if(k == i) continue;
				if(arr[k][i] == 'Y' || arr[i][k] == 'Y') {
					ff++;
					continue;
				}
				for (int j = 0; j < N; j++) {
					if(k == j || i == j) continue;
					if((arr[k][j] == 'Y' || arr[j][k] == 'Y') && (arr[i][j] == 'Y' || arr[j][i] == 'Y')) {
						ff++;
						break; // 무한루트 돈다.
					}
				}
			}
			max = Math.max(max, ff);
		}
		System.out.println(max);
	}
}
