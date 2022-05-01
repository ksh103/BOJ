package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 15651번 N과 M(3) */
public class boj_15651 {

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
		 */
		
		perm(0);
		
		System.out.println(sb);
	}
	
	static void perm(int cnt) {
		// 기저 조건
		if(cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			// 같은 수를 여러 번 골라도 되므로 중복 체크 x
			arr[cnt] = i;
			perm(cnt + 1);
		}
	}
}
