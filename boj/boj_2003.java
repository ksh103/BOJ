package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 2003번 수들의 합 2 */
public class boj_2003 {

	static int N, M, ans;
	static int[] A;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		A = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		ans = 0;
		twoPointer();
		System.out.println(ans);
	}
	
	static void twoPointer() {
		int start = 0, end = 0, sum = 0;
		
		while(true) {
			if(sum < M) {
				if(end == N) break;
				sum += A[end++];
			}
			else sum -= A[start++];

			if(sum == M) ans++;
		}
	}
}
/*
 * 1. sum == 찾고자 하는 값
 * 2. sum < 찾고자 하는 값
 * 3. sum > 찾고자 하는 값
 */
