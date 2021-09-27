package com.boj.im;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 2559번 수열 */
public class boj_2559 {

	static int N, K, sum, max;
	static int[] temp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		temp = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			temp[i] = Integer.parseInt(st.nextToken());
		}
		
		max = Integer.MIN_VALUE;
		for (int i = 0; i <= N - K; i++) { 
			sum = 0;
			for (int j = 0; j < K; j++) { // K개만큼 더한다.
				sum += temp[i+j];
			}
			max = Math.max(max, sum);
		}
		System.out.println(max);
	}
}
