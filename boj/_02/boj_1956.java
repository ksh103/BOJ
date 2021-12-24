package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 1956번 운동 */
public class boj_1956 {

	static int V, E;
	static int[][] graph;
	static final int INF = 10000 * 400;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		graph = new int[V+1][V+1];
		
		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++) {
				graph[i][j] = INF;
				if(i == j) graph[i][j] = 0;
			}
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph[a][b] = Math.min(graph[a][b], c);
		}
		
		// 플로이드-와샬 알고리즘
		for (int k = 1; k <= V ; k++) {
			for (int i = 1; i <= V; i++) {
				for (int j = 1; j <= V; j++) {
					if(graph[i][j] > graph[i][k] + graph[k][j]) {
						graph[i][j] = graph[i][k] + graph[k][j];
					}
				}
			}
		}
		
		// 출력
		int min = INF;
		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++) {
				if(i != j) {
					min = Math.min(min, graph[i][j] + graph[j][i]);
				}
			}
		}
		
		System.out.println(min == INF ? -1 : min);
	}
}
