package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/* boj 2307번 도로검문 */
public class boj_2307 {

	static int N, M;
	static final int INF = 1_000 * 5_000;
	
	static int[] graph, path;
	static boolean[] visited;
	
	static ArrayList<Node>[] list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N + 1];
		path = new int[N + 1];
		
		list = new ArrayList[N + 1];
		
		Arrays.fill(graph, INF);
		
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken()); // 통과 시간
			
			// 양방향
			list[a].add(new Node(b, t));
			list[b].add(new Node(a, t));
		}
		
		// 검문할 도로 체크
		findRoad(1);
		
	}
	
	private static int cityEscape(int v, int from, int to) {

		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		// 용의자가 도시에 진입하는 지점은 항상 1
		graph[v] = 0;
		pq.offer(new Node(v, 0));
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			
			if(visited[n.to]) continue;
			
			visited[n.to] = true;
			
			for(Node next : list[n.to]) {
				
				// 경찰이 도로 검문중이므로 피해간다.
				if(n.to == from && next.to == to) continue;
				
				if(!visited[next.to] && graph[next.to] > graph[n.to] + next.time) {
					graph[next.to] = graph[n.to] + next.time;
				}
			}
		}
		// 도시를 빠져나가기 위해 최종적으로 도달해야하는 지점 항상 N
		return graph[N];
	}
	
	private static void findRoad(int v) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		graph[v] = 0;
		pq.offer(new Node(v, 0));
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			
			for(Node next : list[n.to]) {
				if(graph[next.to] > graph[n.to] + next.time) {
					graph[next.to] = graph[n.to] + next.time;
					
					// 용의자가 빠져나가지 못하게 최단 거리로 연결된 길을 막는다.
					// 경로 업데이트
					path[next.to] = n.to;
					pq.offer(new Node(next.to, graph[next.to]));
				}
			}
		}
	}
	
	static class Node implements Comparable<Node>{
		int to, time;
		
		public Node(int to, int time) {
			this.to = to;
			this.time = time;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.time, o.time);
		}
	}
}
