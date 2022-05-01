package com.boj;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* boj 2252번 줄 세우기 */
public class boj_2252 {

	static int N, M;
	static int[][] graph;
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
			list[i] = new ArrayList<Integer>();
		}
		
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b); // a -> b
			targetNodeCnt[b]++; // a -> b를 가리키므로  b는 자신을 가리키는 정점 1개 추가
		}
		System.out.println(Topological_Sorting());
	}
	
	static String Topological_Sorting() {
		Queue<Integer> queue = new LinkedList<>();
		
		for (int i = 1; i <= N; i++) {
			if(targetNodeCnt[i] == 0) {
				queue.add(i); // 자기 자신을 가리키는 정점이 없는 정점만 큐에 넣음.
			}
		}
		
		while(!queue.isEmpty()) {
			int a = queue.poll();
			
			sb.append(a).append(" "); // 처리한 노드는 순서대로 저장
			
			while(!list[a].isEmpty()) {
				int b = list[a].remove(0);
				--targetNodeCnt[b]; // 자신이 가리키는 여러개의 노드들에 대해 가리키고 있는 개수를 하나 제거
				
				if(targetNodeCnt[b] == 0) {
					queue.add(b);
				}
			}
		}
		return sb.toString();
	}
}
