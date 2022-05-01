package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 11404번 플로이드 */
public class boj_11404 {
	
	static int n, m;
	static int[][] bus;
	static final int INF = 100000 * 100;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		bus = new int[n+1][n+1];
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				bus[i][j] = INF;
				if(i == j) bus[i][j] = 0;
			}
		}
		
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			bus[a][b] = Math.min(bus[a][b], c);
		}
		
		// 플로이드 와샬 알고리즘
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if(bus[i][j] > bus[i][k] + bus[k][j]) {
						bus[i][j] = bus[i][k] + bus[k][j];
					}
				}
			}
		}
		
		// 출력
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if(bus[i][j] == INF) {
					bus[i][j] = 0;
				}
				sb.append(bus[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
