package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/* boj 1753번 최단경로 */
public class boj_1753 {

	static int V, E, K;
	static final int INF = 10 * 20_000;
	static int[] graph;
	static ArrayList<Node>[] list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken()); // 정점의 개수
		E = Integer.parseInt(st.nextToken()); // 간선의 개수
		K = Integer.parseInt(br.readLine()); // 시작 정점의 번호
		
		graph = new int[V + 1];
		list = new ArrayList[V + 1];
		
		Arrays.fill(graph, INF);
		
		for(int i = 1; i <= V; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken()); // 가중치
			
			list[u].add(new Node(v, w));
		}
		
		solve(K);
		
		for(int i = 1; i <= V; i++) {
			if(graph[i] == INF) System.out.println("INF");
			else System.out.println(graph[i]);
		}
		
	}
	
	static void solve(int v) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[V + 1];
		
		pq.offer(new Node(v, 0)); // 출발 정점과 출발 정점의 가중치 큐에 넣기
		graph[v] = 0; // 출발 정점은 0으로 초기화
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			
			if(visited[n.v]) continue;
			visited[n.v] = true;
			
			for(Node next : list[n.v]) {
				// 현재 정점까지 거리 + 현재 정점에서 꺼낸 정점까지의 거리 (다음 정점의 가중치 값)
				if(graph[next.v] > graph[n.v] + next.w) {
					graph[next.v] = graph[n.v] + next.w;
					pq.offer(new Node(next.v, graph[next.v]));
				}
			}
		}
	}

	static class Node implements Comparable<Node>{
		int v, w;
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}
}
