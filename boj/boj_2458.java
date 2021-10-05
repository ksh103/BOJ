package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* boj 2458번 키 순서 */
public class boj_2458 {

	static int TC, N, M;
	static int[] count;
	static int[][] distance;
	final static int INF = 999_999;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
			
		distance = new int[N+1][N+1];
			
		for (int[] n : distance) {
			Arrays.fill(n, INF);
		}
			
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
				
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			distance[a][b] = 1; // a < b
		}
			
		// 플로이드 와샬 알고리즘 
		for (int k = 1; k <= N; k++) { // 경유지
			for (int i = 1; i <= N; i++) { // 출발
				if(i == k) continue;
				for (int j = 1; j <= N; j++) { // 도착
					if(j == k || i == j) continue;
						
					distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
				}
			}
		}
			
		count = new int[N+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(distance[i][j] != INF) {
					count[i]++;
					count[j]++;
				}	
			}
					
		}
			
		int result = 0;
		for (int i = 1; i <= N; i++) {
			if(count[i] == N-1) result++;
		}
			
		System.out.println(result);
	}
}
