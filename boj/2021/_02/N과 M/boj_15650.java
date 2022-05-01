package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 15650번 N과 M(2) */
public class boj_15650 {

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
		 * 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
		 * 고른 수열은 오름차순이어야 한다.
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
			if(isSelected[i]) continue; // 사용중인 수면 다음 수로
			
			arr[cnt] = i; // 배열에 저장
			isSelected[i] = true;
			
			perm(i, cnt + 1); // 다음 수로 이동
			isSelected[i] = false;
		}
	}
}
