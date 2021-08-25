package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 10971번 외판원 순회 2 */
public class boj_10971 {

	static int N, min;
	static int[][] W;
	static boolean[] visit;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		W = new int[N][N];
		visit = new boolean[N];
		min = Integer.MAX_VALUE;
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			DFS(i, i, 0, 0);
		}
		
		System.out.println(min);
	}
	
	static void DFS(int strIdx, int now, int cnt, int sum) {
		// 기저 조건
		// N개의 도시를 모두 순회하고 다시 처음 도시로 돌아왔을 때
		if(cnt == N && strIdx == now) {
			// 최소 비용 출력
			min = Math.min(min, sum);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			// 이미 지나간 곳은 다시 갈 수 없다 
			// w[i][j] = 0일 경우, 갈 수 없다.
			if(!visit[i] && W[now][i] != 0) {
				visit[i] = true; // 방문 처리
				DFS(strIdx, i, cnt + 1, sum + W[now][i]);
				visit[i] = false;
			}
		}
	}
}
