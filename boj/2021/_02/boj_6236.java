package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* boj 6236번 용돈 관리 */
public class boj_6236 {

	static int N, M;
	static int[] cost;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		cost = new int[N];
		
		int max = 0, sum = 0;
		for (int i = 0; i < N; i++) {
			cost[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, cost[i]);
			sum += cost[i];
		}
		
		int start = max, end = sum, mid = 0;
		
		while(start <= end) {
			mid = (start + end) / 2;
			
			int money = mid, cnt = 1;
			
			for (int i = 0; i < N; i++) {
				money -= cost[i];
				
				if(money <= 0) {
					cnt++; // 인출횟수
					money = mid - cost[i];
				}
			}
			
			if(cnt <= M) end = mid - 1;
			else start = mid + 1;
		}
		
		System.out.println(mid);
	}
}
