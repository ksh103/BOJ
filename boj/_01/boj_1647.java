package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/* boj 1647번 도시 분할 계획 */
public class boj_1647 {

	static int N, M;
	static int[] parent;
	static ArrayList<Node> list = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 집의 개수
		M = Integer.parseInt(st.nextToken()); // 길의 개수
		
		parent = new int[N+1];
	
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
		
			list.add(new Node(from, to, w));
		}
		
		Collections.sort(list);
		
		makeSet();
		int cnt = 0, sum = 0, max = 0;
		
		for (Node n : list) {
			if(unionFind(n.from, n.to)) {
//				max = Math.max(max, n.w); // 가장 큰 가중치 값 
				sum += n.w;
				cnt++;
				if(cnt == N-2) break;
			}
		}
//		sum -= max;
		System.out.println(sum);
	}
	
	static void makeSet() {
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
	}
	
	static int findSet(int x) {
		if(parent[x] == x) return x;
		
		return parent[x] = findSet(parent[x]);
	}
	
	static boolean unionFind(int from, int to) {
		from = findSet(from);
		to = findSet(to);
		
		if(from == to) return false;
		
		parent[to] = from;
		return true;
	}
	
	static class Node implements Comparable<Node>{
		int from, to, w;
		public Node(int from, int to, int w) {
			this.from = from;
			this.to = to;
			this.w = w;
		}
		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}
}

/*
 * MST에서 추가된 조건 --> 도시가 두 개로 분할된다는 것
 * 노드 개수가 N인 그래프에서 MST는 N-1개의 간선을 선택
 * 크루스칼 알고리즘으로 풀 때는 N-2개의 간선을 선택해주면 도시는 두 개로 분할 
 * 프림 알고리즘으로 풀 때는 한 정점을 기준으로 N-1개의 간선을 골라주면서 그 중 max 간선을 뺀다.
*/
 