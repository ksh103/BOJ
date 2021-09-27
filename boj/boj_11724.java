package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 11724번 연결 요소의 개수 */
public class boj_11724 {

	static int N, M, U, V, cnt;
	static int[][] graph;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			U = Integer.parseInt(st.nextToken());
			V = Integer.parseInt(st.nextToken());
			
			graph[U][V] = graph[V][U] = 1;
		}
		
		cnt = 0;
		for (int i = 1; i <= N; i++) {
			if(!visited[i]) {
				dfs(i);
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	
	static void dfs(int node) {
		for (int i = 1; i <= N; i++) {
			if(graph[node][i] == 1 && !visited[i]) {
				visited[i] = true;
				dfs(i);
			}
		}
	}
}
