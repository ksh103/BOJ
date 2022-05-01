package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 10159번 저울 */
public class boj_10159 {

	static int N, M;
	static final int INF = 2_000 * 100;
	static int[][] thing, rething;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		thing = new int[N+1][N+1];
		rething = new int[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(i == j) thing[i][j] = rething[i][j] = 0;
				thing[i][j] = rething[i][j] = INF;
			}
		}
		
		while(M-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			thing[a][b] = rething[b][a] = 1; // thing 큰 값 rething 작은 값
		}
	
		// 플로이드-와샬 알고리즘
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if(thing[i][j] > thing[i][k] + thing[k][j]) {
						thing[i][j] = thing[i][k] + thing[k][j];
					}
					
					if(rething[i][j] > rething[i][k] + rething[k][j]) {
						rething[i][j] = rething[i][k] + rething[k][j];
					}
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			int w = 0;
			for (int j = 1; j <= N; j++) {
				thing[i][j] = Math.min(thing[i][j], rething[i][j]);
				if(thing[i][j] == INF) w++;
			} 
			System.out.println(w - 1);
		}
	}
}
