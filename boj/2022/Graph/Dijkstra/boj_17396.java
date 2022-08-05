package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/* boj 17396번 백도어 */
public class boj_17396 {

	static int N, M;
	static long[] graph;
	static boolean[] sight;
	static final Long INF = Long.MAX_VALUE;
	
	static ArrayList<Node>[] list;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		sight = new boolean[N]; // 적의 시야
		graph = new long[N];
		list = new ArrayList[N];
		
		Arrays.fill(graph, INF);
		
		for(int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int s = Integer.parseInt(st.nextToken());
			
			if(s == 1) sight[i] = true;
			else sight[i] = false;
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			// 양방향
			list[start].add(new Node(end, cost));
			list[end].add(new Node(start, cost));
		}
		
		System.out.println(solve(0));
		
	}
	
	static long solve(int v) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		// 시작 정점
		pq.add(new Node(v, 0));
		graph[v] = 0;
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			
			// 넥서스 : N - 1
			if(n.v == N - 1) return graph[N - 1];
			
			if(sight[n.v]) continue; // 적의 시야가 보이는 곳이면 지나가지 않음
			
			sight[n.v] = true; // 지나가면 적의 시야에서 보임.
			
			for(Node next : list[n.v]) {
				if(graph[next.v] > graph[n.v] + next.w) {
					graph[next.v] = graph[n.v] + next.w;
					pq.offer(new Node(next.v, graph[next.v]));
				}
			}
		}
		return -1;
	}

	static class Node implements Comparable<Node>{
		int v;
		long w;
		public Node(int v, long w) {
			this.v = v;
			this.w = w;
		}
		
		@Override
		public int compareTo(Node o) {
			return Long.compare(this.w, o.w);
		}
	}
}