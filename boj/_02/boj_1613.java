package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 1613번 역사  */
public class boj_1613 {

	static int n, k, s;
	static final int INF = 50_000 * 400;
	static int[][] history;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		history = new int[n+1][n+1];
			
		while(k-->0) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			history[a][b] = -1;
			history[b][a] = 1;
			
		}
	
		// 플로이드-와샬 알고리즘
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				if(k == i) continue;
				for (int j = 1; j <= n; j++) {
					if(k == j || i == j) continue;
					
					if(history[i][k] == -1 && history[k][j] == -1) {
						history[i][j] = -1;
					}
					
					if(history[i][k] == 1 && history[k][j] == 1) {
						history[i][j] = 1;
					}
				}
			}
		}
		
		s = Integer.parseInt(br.readLine());
		
		while(s-->0) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			System.out.println(history[a][b]);
		}
	}
}
