package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* boj 15654번 N과 M(5) */
public class boj_15654 {

	static int N, M;
	static int[] arr, result;
	static boolean[] isSelected;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		result = new int[N]; // 결과를 담을 배열
		isSelected = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		/*
		 * N개의 자연수 중에서 M개를 고른 수열
		 */
		
		Arrays.sort(arr); // 오름차순 정렬
		perm(0);
		
		System.out.println(sb);
	}
	
	static void perm(int cnt) {
		// 기저 조건
		if(cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(result[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(isSelected[i]) continue;
			
			result[cnt] = arr[i]; // 결과를 담을 배열에 수 담기
			isSelected[i] = true; 
			
			perm(cnt + 1); // 다음 수로 이동
			isSelected[i] = false;
		}
	}
}
