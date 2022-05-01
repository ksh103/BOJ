package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 2228번 구간 나누기 */
public class boj_2228 {

	static int N, M;
	static int[] sum;
	static int[][] dp;
	static boolean[][] selected;
	static final int MIN = -32768 * 101;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		sum = new int[N+1];
		dp = new int[N+1][M+1];
		selected = new boolean[N+1][M+1];
		
		for (int i = 1; i <= N; i++) {
			sum[i] = sum[i-1] + Integer.parseInt(br.readLine());
		}
		
		System.out.println(go(N, M));
	}
	
	static int go(int idx, int section) {
		if(section == 0) return 0; // 나눌 구간이 없을 때
		if(idx <= 0) return MIN;
		if(selected[idx][section]) return dp[idx][section];
		
		selected[idx][section] = true;
		
		int tmp = go(idx - 1, section); // 구간에 수가 포함되지 않는 경우
		
		for (int i = 1; i <= idx; i++) {
			int numSum = go(i-2, section-1) + sum[idx] - sum[i-1];
			tmp = Math.max(tmp, numSum);
		}
		return dp[idx][section] = tmp;
	}
}
