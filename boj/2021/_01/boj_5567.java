package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 5567번 결혼식 */
public class boj_5567 {

	static int n, m;
	static int[][] graph;
	static boolean[] visit;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		graph = new int[n+1][n+1];
		visit = new boolean[n+1];
		
		for (int i = 1; i <= m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a][b] = 1;
			graph[b][a] = 1;
		}
		
		System.out.println(solution());
	}
	
	static int solution() {
		int cnt = 0;
		for (int i = 2; i <= n; i++) {
			// 상근이 친구
			if(graph[1][i] == 1) {
				if(!visit[i]) {
					visit[i] = true;
					cnt++;
				}
				// 상근이 친구의 친구
				for (int j = 2; j <= n; j++) {
					if(graph[i][j] == 1 && !visit[j]) {
						visit[j] = true;
						cnt++;
					}
				}
			}
		}
		return cnt;
	}
}
