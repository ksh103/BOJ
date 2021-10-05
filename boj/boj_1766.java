package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/* boj 1766번 문제집 */
public class boj_1766 {

	static int N, M;
	static int[] targetNodeCnt;
	
	static ArrayList<Integer>[] list;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		targetNodeCnt = new int[N+1];
		list = new ArrayList[N+1];
		
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			targetNodeCnt[b]++;
		}
		System.out.println(Topological_Sorting());
	}
	
	static String Topological_Sorting() {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		
		for (int i = 1; i <= N; i++) {
			if(targetNodeCnt[i] == 0) {
				queue.add(i);
			}
		} 
		
		while(!queue.isEmpty()) {
			int a = queue.poll();
			
			sb.append(a).append(" ");
			
			while(!list[a].isEmpty()) {
				int b = list[a].remove(0);
				--targetNodeCnt[b];
				
				if(targetNodeCnt[b] == 0) {
					queue.add(b);
				}
			}
		}
		return sb.toString();
	}
}
