package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/* boj 1197번 최소 스패닝 트리 */
public class boj_1197 {
	
	static int V, E;
	static ArrayList<Node> list; // 내부정렬
	static int[] parent;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<Node>();
		parent = new int[V+1];
		
		for (int i = 1; i <= E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list.add(new Node(from, to, w));
		}
		
		Collections.sort(list);
		
		makeSet();
		
		int cnt = 0, res = 0;
		for (Node n : list) {
			if(unionFind(n.from, n.to)) {
				res += n.w;
				cnt++;
				
				if(cnt == V-1) break;
			}
		}
		System.out.println(res);
	}
	
	static void makeSet() {
		// 자기 자신이 자신만을 집합으로 표현하기 위한 작업
		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}
	}
	
	static int findSet(int x) {
		if(x == parent[x]) return x;
		
		return parent[x] = findSet(parent[x]);
	}
	
	
	static boolean unionFind(int x, int y) {
		int from = findSet(x);
		int to = findSet(y);
		
		if(from == to) return false; // 사이클 발생
		
		parent[to] = from;
		return true;
	}
	
	// 크루스칼 MST 간선중심 정렬
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
