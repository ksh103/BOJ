package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* boj 10974번 모든 순열 */
public class boj_10974_np {

	static int N;
	static int[] number;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		number = new int[N];

		for(int i = 0; i < N; i++) {
			number[i] = i+1;
		}
		
		do {
			for(int i = 0; i < N; i++) {
				System.out.print(number[i] + " ");
			}
			System.out.println();
		}while(np(number));
	}
	
	// 순열
	static boolean np(int[] number) {
		
		int i = N - 1;
		while(i > 0 && number[i-1] >= number[i]) --i;
		
		if(i == 0) return false;
		
		int j = N - 1;
		while(number[i - 1] >= number[j]) --j;
		
		swap(number, i-1, j);
		
		int k = N - 1;
		while(i < k) {
			swap(number, i++, k--);
		}
		
		return true;
	}
	
	static void swap(int[] number, int i, int j) {
		int temp = number[i];
		number[i] = number[j];
		number[j] = temp;
	}
}