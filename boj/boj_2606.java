package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* boj 2606번 바이러스 */
public class boj_2606 {

	static int N, line, cnt = 0;
	static int[][] node;
	static boolean[] selected;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 정점의 개수
		line = Integer.parseInt(br.readLine()); // 간선의 개수
		
		node = new int[N+1][N+1]; 
		selected = new boolean[N+1]; 
		
		for (int i = 0; i < line; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			node[a][b] = 1;
			node[b][a] = 1;
		}
		
		bfs(node, selected, 1);
		System.out.println(cnt);
	}
	
	static void bfs(int[][] node, boolean[] selected, int v) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(v);
		selected[v] = true;
		
		while(!queue.isEmpty()) {
			int num = queue.poll();
			
			for (int i = 0; i < node[num].length; i++) {
				if(!selected[i] && node[num][i] == 1) {
					queue.offer(i);
					selected[i] = true;
					cnt++;
				}
			}
		}
	}
}
