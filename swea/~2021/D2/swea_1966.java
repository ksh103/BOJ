package com.swea.im;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* swea 1966번 숫자를 정렬하자 (D2) */
public class swea_1966 {

	static int testCase, N;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		testCase = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= testCase; t++) {
			
			N = Integer.parseInt(br.readLine());
			
			arr = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			
			System.out.print("#" + t + " ");
			for(int i = 0; i <N; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}
	}

}
