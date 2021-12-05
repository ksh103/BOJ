package com.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* swea 5431번 민석이의 과제 체크하기 (D3) */
public class swea_5431 {

	static int N, K;
	static int[] student, finish;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			student = new int[N + 1];
			finish = new int[N + 1];
			
			for (int i = 1; i <= N; i++) {
				student[i] = i;
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= K; i++) {
				finish[Integer.parseInt(st.nextToken())]++;
			}
			
			sb.append("#" + t + " ");
			for (int i = 1; i <= N; i++) {
				if(finish[i] == 0) {
					sb.append(i).append(" ");
				}
			}
			System.out.println(sb);
			sb.setLength(0);
		}
	}
}
