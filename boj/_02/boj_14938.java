package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 14938번 서강그라운드 */
public class boj_14938 {

	static int n, m, r;
	static final int INF = 15 * 100 * 30;
	static int[][] graph;
	static int[] t;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		t = new int[n + 1];
		graph = new int[n+1][n+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			t[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if(i == j) graph[i][j] = 0;
				else graph[i][j] = INF;
			}
		}
		
		while(r-->0) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph[a][b] = graph[b][a] = c; // 양방향
		}
		
		// 플로이드-와샬 알고리즘
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				if(k == i) continue;
				for (int j = 1; j <= n; j++) {
					if(k == j || i == j) continue;
					
					if(graph[i][j] > graph[i][k] + graph[k][j]) {
						graph[i][j] = graph[i][k] + graph[k][j];
					}
				}
			}
		}
		
		int max = 0;
		for (int i = 1; i <= n; i++) {
			int item = 0;
			for (int j = 1; j <= n; j++) {
				if(graph[i][j] <= m) item += t[j]; // 수색 범위 내에서 가질 수 있는 아이템 수 누적 합
			}
			max = Math.max(max, item);
		}
		System.out.println(max);
	}
}
