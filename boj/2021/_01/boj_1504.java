package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/* boj 1504번 특정한 최단 경로 */
public class boj_1504 {

	static int N, E;
	final static int INF = 800 * 200_000;
	static int[] distance;
	
	static ArrayList<Node>[] list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 정점의 개수
		E = Integer.parseInt(st.nextToken()); // 간선의 개수
		
		distance = new int[N+1];
		list = new ArrayList[N+1];
				
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 1; i <= E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken()); 
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			// 방향성이 없는 그래프
			list[a].add(new Node(b, c));
			list[b].add(new Node(a, c));
		}
		
		st = new StringTokenizer(br.readLine());
		
		// 반드시 거쳐야 하는 두 개의 서로 다른 정점
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		System.out.println(path(v1, v2, N));
	}
	
	static int path(int v1, int v2, int N) {
		int p1 = 0, p2 = 0;
		
		// 시작 정점 -> v1 -> v2 -> 도착 정점
		p1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N);
		
		// 시작 정점 -> v2 -> v1 -> 도착 정점
		p2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N);
		
		// 두 개의 정점을 지나는 최단 경로 길이
		if(p1 >= INF && p2 >= INF) return -1;
		return Math.min(p1, p2);
	}
	
	static int dijkstra(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[N + 1];
		
		Arrays.fill(distance, INF);
		Arrays.fill(visited, false);
		
		pq.offer(new Node(start, 0));
		distance[start] = 0;
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			int now = n.index;
			
//			if(n.cost > distance[now]) continue;
			if(visited[now]) continue;
			visited[now] = true;
			
			for (Node next : list[now]) {
				if(distance[next.index] > distance[now] + next.cost) {
					distance[next.index] = distance[now] + next.cost;
					pq.offer(new Node(next.index, distance[next.index]));
				}
			}
		}
		return distance[end];
	}
	
	static class Node implements Comparable<Node>{
		int index, cost;
		public Node(int index, int cost) {
			this.index = index;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
}
