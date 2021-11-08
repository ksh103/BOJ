package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* boj 11728번 배열 합치기 */
public class boj_11728 {

	static int N, M;
	static int[] result;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		result = new int[N+M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			result[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = N; i < N + M; i++) {
			result[i] = Integer.parseInt(st.nextToken());
 		}
		
		Arrays.sort(result);
		
		for (int i = 0; i < N+M; i++) {
			sb.append(result[i]).append(" ");
		}
		System.out.println(sb.toString().trim());
	}
}
