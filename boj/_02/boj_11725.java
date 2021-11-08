package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/* boj 11725번 트리의 부모 찾기 */
public class boj_11725 {

	static int N;
	static int[] parent;
	static boolean[] visit;
	static List<Integer>[] list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		parent = new int[N+1];
		visit = new boolean[N+1];
		
		list = new ArrayList[N+1];
		for (int i = 1; i <= N ; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			// 방향성이 없는 그래프
			list[start].add(end);
			list[end].add(start);
		}
		
		bfs(1);
		
		for (int i = 2; i <= N; i++) {
			System.out.println(parent[i]);
		}
	}
	
	static void bfs(int str) {
		Queue<Integer> queue = new LinkedList<>();
		visit[str] = true;
		
		queue.add(str);
		
		while(!queue.isEmpty()) {
			int node = queue.poll();
			
			for (int next : list[node]) {
				if(!visit[next]) {
					visit[next] = true;
					queue.add(next);
					parent[next] = node;
				}
			}
		}
	}
}
