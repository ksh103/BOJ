package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/* boj 6118번 숨바꼭질 */
public class boj_6118 {

	static int N, M, n, d, cnt;
	static boolean[] visit;
	static List<Integer>[] list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 헛간의 개수
		M = Integer.parseInt(st.nextToken()); // 양방향 길 개수
		
		visit = new boolean[N+1];
		list = new ArrayList[N+1];
		
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		while(M-->0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			// 양방향
			list[a].add(b);
			list[b].add(a);
		}
		
		bfs();
		System.out.println(n + " " + d + " " + cnt);
	}
	
	static void bfs() {
		Queue<Node> queue = new LinkedList<>();
		
		visit[1] = true;
		queue.offer(new Node(1, 0));
		
		while(!queue.isEmpty()) {
			Node now = queue.poll();
			
			if(now.distance > d) {
				d = now.distance;
				n = now.node;
				cnt = 1;
			}else if(now.distance == d) {
				if(n > now.node) {
					n = now.node;
				}
				cnt++;
			}
			
			for (int i = 0; i < list[now.node].size(); i++) {
				int next = (int) list[now.node].get(i);
				if(visit[next]) continue;
				visit[next] = true;
				queue.offer(new Node(next, now.distance + 1));
			}
		}
	}
	
	static class Node{
		int node, distance;
		public Node(int node, int distance) {
			this.node = node;
			this.distance = distance;
		}
	}

}
