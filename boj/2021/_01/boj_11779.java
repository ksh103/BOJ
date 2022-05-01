package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/* boj 11779번 최소비용 구하기2 */
public class boj_11779 {

	static int N, M;
	static int[] distance, pre;
	final static int INF = 987654321;
	
	static ArrayList<Integer> path = new ArrayList<>();
	static ArrayList<Node>[] list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 도시의 개수
		M = Integer.parseInt(br.readLine()); // 버스의 개수
		
		distance = new int[N+1];
		pre = new int[N+1];
		list = new ArrayList[N+1];
	
		Arrays.fill(distance, INF);
		
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		StringTokenizer st;
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken()); // 버스의 출발 도시의 번호
			int end = Integer.parseInt(st.nextToken()); // 도착지의 도시 번호
			int cost = Integer.parseInt(st.nextToken()); // 버스 비용
			
			list[start].add(new Node(end, cost));
		}
		
		st = new StringTokenizer(br.readLine());
		
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		dijkstra(s);
		restorePath(s, e);
		
		Collections.reverse(path);
		System.out.println(distance[e] + "\n" + path.size());
		
		for (int p : path) {
			System.out.print(p + " ");
		}
	}
	
	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visit = new boolean[N + 1];
		
		pq.offer(new Node(start, 0));
		distance[start] = 0;
		pre[start] = start;
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			int now = n.index;
			
			if(visit[now]) continue;
			visit[now] = true;
			
			for (Node next : list[now]) {
				if(distance[next.index] > distance[now] + next.weight) {
					distance[next.index] = distance[now] + next.weight;
					pre[next.index] = now; // 다음 인덱스 값에 현재 인덱스 값을 넣어준다.
					pq.offer(new Node(next.index, distance[next.index]));
				}
			}
		}
	}
	
	// 경로 복구
	static void restorePath(int start, int end) {
		// 도착지점 -> 출발지점까지 탐색
		while(end != start) {
			path.add(end);
			end = pre[end];
		}
		path.add(end);
	}
	
	static class Node implements Comparable<Node>{
		int index, weight;
		public Node(int index, int weight) {
			this.index = index;
			this.weight = weight;
		}
		 
		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}
}

