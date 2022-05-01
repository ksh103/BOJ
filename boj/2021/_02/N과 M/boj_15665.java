package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* boj 15665번 N과 M(11) */
public class boj_15665 {
	
	static int N, M;
	static int[] arr, result;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		result = new int[N]; // 결과를 담을 배열

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		/*
		 * N개의 자연수 중에서 M개를 고른 수열
		 * 같은 수를 여러 번 골라도 된다.
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
			if(lastNum == arr[i]) continue; // 같은 숫자가 있으면 중복되지 않게
			
			lastNum = arr[i];
			result[cnt] = arr[i];
			perm(cnt + 1);
		}
	}
}
