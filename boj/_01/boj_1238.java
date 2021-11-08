package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/* boj 1238번 파티 */
public class boj_1238 {
	
	static int N, M, X;
	final static int INF = 1_000 * 10_000;
	static int[] r1, r2;
	
	static ArrayList<Node>[] go;
	static ArrayList<Node>[] come;
	
	public static void main(String[] args) throws Exception	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 학생 수
		M = Integer.parseInt(st.nextToken()); // 도로 수
		X = Integer.parseInt(st.nextToken()); // 목적지
		
		go = new ArrayList[N+1];
		come = new ArrayList[N+1];
		
		r1 = new int[N+1];
		r2 = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			go[i] = new ArrayList<>();
			come[i] = new ArrayList<>();
		}
		
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			go[a].add(new Node(b, c)); // 출발
			come[b].add(new Node(a, c)); // 귀가
		}
		
		dijkstra(go, r1);
		dijkstra(come, r2);
		
		int result = 0;
		for (int i = 1; i <= N; i++) {
			result = Math.max(result, r1[i] + r2[i]);
		}
		System.out.println(result);
	}
	
	static int[] dijkstra(ArrayList<Node>[] party, int[] distance) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[N+1];
		
		Arrays.fill(distance, INF);
		Arrays.fill(visited, false);
		
		pq.offer(new Node(X, 0));
		distance[X] = 0;
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			int now = n.index;
			
			if(visited[now]) continue;
			visited[now] = true;
			
			for (Node next : party[now]) {
				if(distance[next.index] > distance[now] + next.cost) {
					distance[next.index] = distance[now] + next.cost;
					pq.offer(new Node(next.index, distance[next.index]));
				}
			}
		}
		return distance;
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
