package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* boj 15664번 N과 M(10) */
public class boj_15664 {
	
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
		 * 고른 수열은 비내림차순이어야 한다.
			- 길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.
		 */
		
		Arrays.sort(arr);
		perm(0, 0);
		System.out.println(sb);
	}
	
	static void perm(int strIdx, int cnt) {
		if(cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(result[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		int lastNum = 0;
		for (int i = strIdx; i < N; i++) {
			if(isSelected[i]) continue;
			if(lastNum == arr[i]) continue; // 같은 숫자가 있으면 중복되지 않게
			
			lastNum = arr[i];
			result[cnt] = arr[i];
			isSelected[i] = true;
			
			perm(i, cnt + 1);
			isSelected[i] = false;
		}
	}
}
