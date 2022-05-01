package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 11265번 끝나지 않는 파티 */
public class boj_11265 {

	static int N, M;
	static int[][] party, graph;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 파티장의 크기
		M = Integer.parseInt(st.nextToken()); // 서비스를 요청한 손님의 수
		
		party = new int[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				party[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 플로이드-와샬 알고리즘
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				if(k == i) continue;
				for (int j = 1; j <= N; j++) {
					if(k == j || i == j) continue;
					
					if(party[i][j] > party[i][k] + party[k][j]) {
						party[i][j] = party[i][k] + party[k][j];
					}
				}
			}
		}
		
		while(M-->0) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(party[a][b] <= c) System.out.println("Enjoy other party");
			else System.out.println("Stay here");
		}
	}
}
