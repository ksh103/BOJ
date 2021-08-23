package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* boj 1260번 DFS와 BFS */
public class boj_1260 {

	static int N, M, V;
	static int[][] node;
	static boolean[] visit;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 정점의 개수
		M = Integer.parseInt(st.nextToken()); // 간선의 개수
		V = Integer.parseInt(st.nextToken()); // 시작 정점
		
		node = new int[N + 1][N + 1];
		visit = new boolean[N + 1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			node[a][b] = node[b][a] = 1;
		}
		
		DFS(V);
		System.out.println();
		Arrays.fill(visit, false);
		BFS(V);
		
	}
	
	static void DFS(int v) {
		visit[v] = true;
		
		System.out.print(v + " ");
		for(int i = 1; i <= N; i++) {
			if(!visit[i] && node[v][i] == 1) {
				DFS(i);
			}
		}
	}
	
	static void BFS(int v) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(v);
		visit[v] = true;
		
		while(!q.isEmpty()) {
			int num = q.poll();
			System.out.print(num + " ");
			
			for(int i = 1; i <= N; i++) {
				if(!visit[i] && node[num][i] == 1) {
					q.offer(i);
					visit[i] = true;
				}
			}
		}
	}
}
