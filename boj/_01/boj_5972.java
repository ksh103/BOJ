package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/* boj 5972번 택배 배송 */
public class boj_5972 {

	static int N, M;
	static int[] distance;
	
	static ArrayList<Node> [] path;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 개의 헛간
		M = Integer.parseInt(st.nextToken()); // 소들의 길
		
		distance = new int[N+1];
		path = new ArrayList[N+1];
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		for (int i = 1; i <= N; i++) {
			path[i] = new ArrayList<>();
		}
		
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			path[a].add(new Node(b, c));
			path[b].add(new Node(a, c));
		}
		
		System.out.println(dijkstra());
	}
	
	static int dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[N+1];
		
		distance[1] = 0;
		pq.offer(new Node(1, 0));
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			int now = n.index;
			
			if(visited[now]) continue;
			visited[now] = true;
			
			for (Node next : path[now]) {
				if(distance[next.index] > distance[now] + next.cost) {
					distance[next.index] = distance[now] + next.cost;
					pq.offer(new Node(next.index, distance[next.index]));
				}
			}
		}
		return distance[N];
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
