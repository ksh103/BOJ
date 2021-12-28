package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 15652번 N과 M(4) */
public class boj_15652 {

	static int N, M;
	static int[] arr;
	static boolean[] isSelected;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	
		arr = new int[M];
		isSelected = new boolean[N+1];
		
		/*
		 * 1부터 N까지 자연수 중에서 M개를 고른 수열
		 * 같은 수를 여러 번 골라도 된다.
		 * 고른 수열은 비내림차순이어야 한다.
			- 길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.
		 */
		
		perm(1, 0);
		
		System.out.println(sb);
	}
	
	static void perm(int strIdx, int cnt) {
		// 기저 조건
		if(cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = strIdx; i <= N; i++) {
			arr[cnt] = i;
			perm(i, cnt + 1);
		}
	}
}
