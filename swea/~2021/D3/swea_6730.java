package com.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* swea 6730번 장애물 경주 난이도 (D3) */
public class swea_6730 {

	static int N;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= testCase; t++) {
			N = Integer.parseInt(br.readLine());
			
			arr = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int up = 0, down = 0;
			for (int i = 0; i < N-1; i++) {
				if(arr[i] < arr[i+1]) up = Math.max(up, arr[i+1] - arr[i]);	
				else if(arr[i] > arr[i+1]) down = Math.max(down, arr[i] - arr[i+1]);
			}

			System.out.println("#" + t + " " + up + " " + down);
		}
	}
}
