package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/* boj 4386번 별자리 만들기 */
public class boj_4386 {

	static int n;
	static double[][] stars;
	static int[] parent;
	
	static ArrayList<Node> list = new ArrayList<Node>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		stars = new double[n+1][2];
		parent = new int[n+1];

		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			stars[i][0] = Double.parseDouble(st.nextToken());
			stars[i][1] = Double.parseDouble(st.nextToken());
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				double distance = Math.sqrt(Math.pow(stars[i][0] - stars[j][0], 2) + Math.pow(stars[i][1] - stars[j][1], 2));
				list.add(new Node(i, j, distance));
			}
		}
		
		Collections.sort(list);
		
		makeSet();
		
		int cnt = 0; double res = 0;
		
		for (Node s : list) {
			if(unionFind(s.from, s.to)) {
				cnt++;
				res += s.w;
				if(cnt == n-1) break;
			}
		}
		System.out.printf("%.2f", res);
	}
	
	static void makeSet() {
		for (int i = 1; i <= n; i++) {
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
		int from, to;
		double w;
		public Node(int from, int to, double w) {
			this.from = from;
			this.to = to;
			this.w = w;
		}
		
		@Override
		public int compareTo(Node o) {
			return Double.compare(this.w, o.w);
		}
	}
}
