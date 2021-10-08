package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* boj 2056번 작업 */
public class boj_2056 {

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
			
			time[i] = Integer.parseInt(st.nextToken());
			int count = Integer.parseInt(st.nextToken());
			
			for (int j = 0; j < count; j++) {
				int workNum = Integer.parseInt(st.nextToken()); // 작업들의 개수
				list[workNum].add(i); // 선행 관계에 있는 작업들
				targetNodeCnt[i]++;
			}
		}
		
		Topological_Sorting();
		
		int ans = 0;
		for (int i = 1; i <= N; i++) {
			ans = Math.max(ans, res[i]);
		}
		System.out.println(ans);
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
				res[next] = Math.max(res[next], res[now] + time[next]);
				--targetNodeCnt[next];
				
				if(targetNodeCnt[next] == 0) queue.add(next);
			}
		}
	}
}
