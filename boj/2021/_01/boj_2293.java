package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 2293번 동전 1 */
public class boj_2293 {

	static int n, k;
	static int[] dp, coin;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		dp = new int[k+1];
		coin = new int[n];
		
		for (int i = 0; i < n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		dp[0] = 1;
		
		for (int i = 0; i < n ; i++) {
			for (int j = 1; j <= k; j++) {
				if(j >= coin[i]) {
					dp[j] += dp[j - coin[i]];
//					System.out.print(dp[j] + " ");
				}
			}
		}
		System.out.println(dp[k]);
	}
}
