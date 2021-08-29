package com.swea.im;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* swea 3499번 퍼펙트 셔플 (D3) */
public class swea_3499 {

	static int N;
	static String[] left, right;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= testCase; t++) {
			N = Integer.parseInt(br.readLine());
			
			left = new String[(N / 2) + (N % 2)];
			right = new String[N / 2];
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			for (int i = 0; i < (N / 2) + (N % 2); i++) {
				left[i] = st.nextToken();
			}
			
			for (int i = 0; i < N / 2; i++) {
				right[i] = st.nextToken();
			}
			
			sb.append("#" + t + " ");
			for (int i = 0; i < N / 2; i++) {
				sb.append(left[i] + " ").append(right[i] + " ");
			}
			
			if(N % 2 == 1) {
				sb.append(left[N/2]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
