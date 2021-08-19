package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* boj 11399번 ATM */
public class boj_11399 {

	static int N, sum, total;
	static int[] P;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		N = Integer.parseInt(br.readLine()); 
		P = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(P);
		
		sum = 0;
		total = 0;
		for(int i = 0; i < N; i++) {
			sum+=P[i];
			total+=sum; // 중첩 덧셈
		}
		System.out.println(total);
	}
}
