package com.swea.im;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* swea 1859번 백만장자 (D2) */
public class swea_1859 {
	
	static int T, N;
	static int[] cost;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			
			cost = new int[N + 1];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= N; i++) {
				cost[i] = Integer.parseInt(st.nextToken());
			}
			
			// 뒤에서부터 탐색하면서 최댓값 갱신
			int max = cost[N]; // 뒤에서부터 탐색할거기 때문에 맨 마지막 날 매매가를 넣어주면서 비교
			long result = 0; // long으로 해야 오류가 안 남.
			for(int i = N - 1; i > 0; i--) {
				if(cost[i] < max) {
					result += (max - cost[i]); // 이익 본 비용 더하기
				}else {
					max = cost[i]; // 최댓값 갱신
				}
			}
			sb.append("#" + t + " " + result + "\n");
		}
		System.out.println(sb.toString());
	}
}
