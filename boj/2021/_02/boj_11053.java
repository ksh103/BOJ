package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 11053번 가장 긴 증가하는 부분 수열 */

public class boj_11053 {

	static int N;
	static int[] A, LTS;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		A = new int[N];
		LTS = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		for (int i = 0; i < N; i++) {
			LTS[i] = 1;
			
			for (int j = 0; j < N; j++) {
				if(A[j] < A[i] && LTS[i] < LTS[j] + 1) {
					LTS[i] = LTS[j] + 1;
				}
			}
			if(max < LTS[i]) max = LTS[i];
		}
		System.out.println(max);
	}
}
