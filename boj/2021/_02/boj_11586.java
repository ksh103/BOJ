package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* boj 11586번 지영 공주님의 마법 거울 */
public class boj_11586 {
	
	static int N, K;
	static char[][] mirror;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		mirror = new char[N][N];
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < N; j++) {
				mirror[i][j] = input.charAt(j);
			}
		}
		
		K = Integer.parseInt(br.readLine());
		
		switch (K) {
		case 1: // 있는 그대로 표현
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(mirror[i][j]);
				}
				sb.append("\n");
			}
			break;

		case 2: // 좌/우 반전된 모습
			for (int i = 0; i < N; i++) {
				for (int j = N-1; j >= 0; j--) {
					sb.append(mirror[i][j]);
				}
				sb.append("\n");
			}
			break;
			
		case 3: // 상/하 반전된 모습
			for (int i = N-1; i >= 0; i--) {
				for (int j = 0; j < N; j++) {
					sb.append(mirror[i][j]);
				}
				sb.append("\n");
			}
			break;
		}
		
		System.out.println(sb);
	}
}
