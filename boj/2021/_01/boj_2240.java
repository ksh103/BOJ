package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 2240번 자두나무 */
public class boj_2240 {

	static int T, W, result = 0;
	static int[] tree;
	static int[][][] dp;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken()); // T초
		W = Integer.parseInt(st.nextToken()); // 움직이는 횟수
		
		dp = new int[3][T+1][W+2];
		tree = new int[T+1];

		for (int i = 1; i <= T; i++) {
			tree[i] = Integer.parseInt(br.readLine());
			
			for (int j = 1; j <= W + 1; j++) {
				if(tree[i] == 1) {
					dp[1][i][j] = Math.max(dp[1][i-1][j], dp[2][i-1][j-1]) + 1; // 1번 나무에 있을 때, 1번 나무에 있는 자두를 받을 수 있으므로 + 1
					dp[2][i][j] = Math.max(dp[1][i-1][j-1], dp[2][i-1][j]);
				}else {
					if(i == 1 && j == 1) continue; // 처음에는 1번 나무에 서있어서 2번 나무에서 떨어지는 자두를 못 받음
					dp[1][i][j] = Math.max(dp[1][i-1][j], dp[2][i-1][j-1]); 
					dp[2][i][j] = Math.max(dp[1][i-1][j-1], dp[2][i-1][j]) + 1; // 2번 나무에 있을 때, 2번 나무에 있는 자두를 받을 수 있으므로 + 1
				}
			}
		}
		
		for (int i = 0; i <= W + 1; i++) {
			result = Math.max(result, Math.max(dp[1][T][i], dp[2][T][i]));
		}
		
		System.out.println(result);
	}
}
