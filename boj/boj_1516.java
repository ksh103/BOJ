package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* boj 1516번 게임 개발 */
public class boj_1516 {

	static int N;
	static int[] time, res, targetNodeCnt;
	static ArrayList<Integer>[] list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		time = new int[N+1];
		res = new int[N+1];
		targetNodeCnt = new int[N+1];
		list = new ArrayList[N+1];
		
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			time[i] = Integer.parseInt(st.nextToken()); // 각 건물을 짓는데 걸리는 시간
			
			while(true) {
				int num = Integer.parseInt(st.nextToken()); // 먼저 지어져야 하는 건물들의 번호
				
				if(num == -1) break;
				
				list[num].add(i);
				targetNodeCnt[i]++;
			}
		}
		
		Topological_Sorting();
		
		int ans = 0;
		for (int i = 1; i <= N; i++) {
			System.out.println(res[i]);
		}
	}
	
	static void Topological_Sorting() {
		Queue<Integer> queue = new LinkedList<>();
		
		for (int i = 1; i <= N; i++) {
			if(targetNodeCnt[i] == 0) {
				queue.add(i);
				res[i] = time[i];
			}
		}
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			
			while(!list[now].isEmpty()) {
				int next = list[now].remove(0);
				
				--targetNodeCnt[next];
				
				res[next] = Math.max(res[next], res[now] + time[next]);
				
				if(targetNodeCnt[next] == 0) queue.add(next);
			}
		}
	}
}
