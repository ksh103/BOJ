package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* boj 1719번 택배 */
public class boj_1719 {

	static int n, m;
	static int[][] graph, delivery;
	static final int INF = 10000 * 200;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		graph = new int[n+1][n+1];
		delivery = new int[n+1][n+1];
		
		for (int i = 1; i <= n; i++) {
			Arrays.fill(graph[i], INF);
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph[a][b] = c;
			graph[b][a] = c;
		}
		
		
		// 플로이드-와샬 알고리즘
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				if(k == i) continue;
				for (int j = 1; j <= n; j++) {
					if(i == j) continue;
					
					if(graph[i][j] > graph[i][k] + graph[k][j]) {
						graph[i][j] = graph[i][k] + graph[k][j];
						delivery[i][j] = k;
						
						int d = j;
						while(delivery[i][d] != 0) {
							delivery[i][j] = delivery[i][d];
							d = delivery[i][d];
						}
					}
				}
			}
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if(i == j) System.out.print("-" + " ");
				else if(delivery[i][j] == 0) System.out.print(j + " ");
				else System.out.print(delivery[i][j] + " ");
			}
			System.out.println();
		}
	}
}
