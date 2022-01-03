package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 2660번 회장뽑기 */
public class boj_2660 {

	static int N, score;
	static final int INF = 50;
	static int[] scoreMax;
	static int[][] graph;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		graph = new int[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(i == j) graph[i][j] = 0;
				graph[i][j] = INF;
			}
		}
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(a == -1 && b == -1) break;
			
			graph[a][b] = graph[b][a] = 1; // 친구 관계
		}
		
		// 플로이드-와샬 알고리즘
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				if(k == i) continue;
				for (int j = 1; j <= N; j++) {	
					if(k == j || i == j) continue;
					
					if(graph[i][j] > graph[i][k] + graph[k][j]) {
						graph[i][j] = graph[i][k] + graph[k][j];
					}
				}
			}
		}
		
		scoreMax = new int[N+1];
		int min = INF;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(graph[i][j] != INF) scoreMax[i] = Math.max(scoreMax[i], graph[i][j]);
			}
			min = Math.min(min, scoreMax[i]); // 회장 후보 점수
		}
		
		int count = 0;
		for (int i = 1; i <= N; i++) {
			if(min == scoreMax[i]) {
				sb.append(i).append(" ");
				count++;
			}
		}
		
		System.out.println(min + " " + count);
		System.out.println(sb.toString().trim());
	}
}
