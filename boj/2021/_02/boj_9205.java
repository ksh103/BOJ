package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 9205번 맥주 마시면서 걸어가기 */
public class boj_9205 {

	static int n, v;
	static final int INF = 101 * 32767 * 2; 
	static int[] tmpX, tmpY;
	static int[][] graph;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			n = Integer.parseInt(br.readLine()); // 맥주를 파는 편의점의 개수
			v = n + 2;
			
			graph = new int[v][v];
			tmpX = new int[v];
			tmpY = new int[v];
			
			for (int i = 0; i < v; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				tmpX[i] = Integer.parseInt(st.nextToken());
				tmpY[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < v; i++) {
				for (int j = 0; j < v; j++) {
					if(i == j) continue;
					
					int distance = Math.abs(tmpX[i] - tmpX[j]) + Math.abs(tmpY[i] - tmpY[j]);
					
					if(distance <= 1000) graph[i][j] = 1;
					else graph[i][j] = INF;
				}
			}
			
			
			// 플로이드- 와샬 알고리즘
			for (int k = 0; k < v; k++) {
				for (int i = 0; i < v; i++) {
					if(i == k) continue;
					for (int j = 0; j < v; j++) {
						if(i == j || k == j) continue;
						
						if(graph[i][j] > graph[i][k] + graph[k][j]) {
							graph[i][j] = graph[i][k] + graph[k][j];
						}
					}
				}
			}
			System.out.println(graph[0][v-1] < INF ? "happy" : "sad");
		}
	}
}
