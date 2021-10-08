package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 1507번 궁금한 민호 */
public class boj_1507 {

	static int N, res;
	static int[][] map, copyMap;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N+1][N+1];
		copyMap = new int[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = copyMap[i][j] =Integer.parseInt(st.nextToken());
			}
		}
		
		floyd();
		
		if(res == -1) {
			System.out.println(res);
			return;
		}
		for (int i = 1; i <= N; i++) {
			for (int j = i+1; j <= N; j++) {
				if(copyMap[i][j] != 0) {
					res += copyMap[i][j];
				}
			}
		}
		System.out.println(res);
		
	}
	
	static void floyd() {
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					
					if(i == k || i == j || j == k) continue;
					
					// 이미 플로이드 와샬이 적용된 상태인데 다시 최단 거리가 생기는 건 모순
					if(map[i][j] > map[i][k] + map[k][j]) {
						res = -1;
						return;
					}
					
					if(map[i][j] == map[i][k] + map[k][j]) {
						copyMap[i][j] = 0;
					}
				}
			}
		}
	}
}
