package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/* boj 1922번 네트워크 연결 */
public class boj_1922 {
	
	static int N, M;
	static int[] parent;
	static ArrayList<Node> list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 컴퓨터의 수
		M = Integer.parseInt(br.readLine()); // 연결할 수 있는 선의 수
		
		parent = new int[N+1];
		list = new ArrayList<Node>();
		
		for (int i = 1; i <= M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list.add(new Node(from, to, w));
		}
		Collections.sort(list);
		
		makeSet();
		int cnt = 0, sum = 0;
		for (Node n : list) {
			if(unionSet(n.from, n.to)) {
				sum += n.w;
				cnt++;
				
				if(cnt == N-1) break;
			}
		}
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
	
	static boolean unionSet(int x, int y) {
		x = findSet(x);
		y = findSet(y);
		
		if(x == y) return false;
		
		parent[y] = x;
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
