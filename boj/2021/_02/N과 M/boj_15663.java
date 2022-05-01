package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* boj 15663번 N과 M(9) */
public class boj_15663 {
	
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
		
		Arrays.sort(arr);
		perm(0);
		System.out.println(sb);
	}
	
	static void perm(int cnt) {
		if(cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(result[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		int lastNum = 0;
		for (int i = 0; i < N; i++) {
			if(isSelected[i]) continue;
			if(lastNum == arr[i]) continue; // 입력에서 중복되는 숫자가 있으면 중복되지 않게 한다!
			
			lastNum = arr[i];
			result[cnt] = arr[i];
			isSelected[i] = true;
			
			perm(cnt + 1);
			isSelected[i] = false;
		}
	}
}
