package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 1956번 상자넣기 */
public class boj_1965 {

	static int n;
	static int[] dp, arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		dp = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			dp[i] = Integer.parseInt(st.nextToken());
		}

		int max = 0;
		for(int i = 0; i < n; i++) {
			
			arr[i] = 1;
			
			for(int j = 0; j < i; j++) {
				if(dp[i] > dp[j] && arr[i] < arr[j] + 1) {
					arr[i] = arr[j] + 1;
				}
			}
			
			if(max < arr[i]) max = arr[i];
		}
		
		System.out.println(max);
		
	}
}
