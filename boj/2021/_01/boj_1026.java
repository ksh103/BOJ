package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* boj 1026번 보물 */
public class boj_1026 {

	static int N;
	static int[] A, B;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		A = new int[N];
		B = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(solve());
	}
	
	static int solve() {
		Arrays.sort(A); // 0 1 1 1 6
		Arrays.sort(B); // 1 2 3 7 8
		
		int result = 0;
		for (int i = 0; i < N; i++) {
			// 0 * 8, 1 * 7, 1 * 3, 1 * 2, 6 * 1
			result += A[i] * B[B.length - 1 - i];
		}
		return result;
	}
}
