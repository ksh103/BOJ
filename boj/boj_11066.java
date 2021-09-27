package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 11066번 파일 합치기 */
public class boj_11066 {

	static int T, K;
	static int[][] dp;
	static int[] sum;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			K = Integer.parseInt(br.readLine());
			
			sum = new int[K+1];
			dp = new int[502][502];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= K; i++) {
				sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
			}
			
			for (int i = 2; i <= K; i++) {
				for (int j = i-1; j > 0; j--) {
					dp[j][i] = Integer.MAX_VALUE;
					for (int k = j; k <= i; k++) {
						dp[j][i] = Math.min(dp[j][i], dp[j][k] + dp[k+1][i]);
					}
					dp[j][i] += sum[i] - sum[j-1];
				}
			}
			System.out.println(dp[1][K]);
		}
	}
}

/* 
 * dp[1][4] = 최소 비용
 * 			  dp[1][1] + dp[2][4] + cost[1][4] 
 * 			  dp[1][2] + dp[3][4] + cost[1][4]
 * 			  dp[1][3] + do[4][4] + cost[1][4]
*/
