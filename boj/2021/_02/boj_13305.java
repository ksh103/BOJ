package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 13305번 주유소 */
public class boj_13305 {

	static int N;
	static long sum, minCost;
	static long[] dist, cost;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine()); // 도시의 개수
		
		dist = new long[N-1];
		cost = new long[N];
		
		// 도로의 길이
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N-1; i++) {
			dist[i] = Long.parseLong(st.nextToken());
		}
		
		// 주유소의 리터당 가격
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cost[i] = Long.parseLong(st.nextToken());
		} 
		
		sum = 0;
		minCost = Long.MAX_VALUE;
		
		for (int i = 0; i < N-1; i++) {
			
			if(cost[i] < minCost) minCost = cost[i];
			sum += (minCost * dist[i]);
		}
		System.out.println(sum);
	}
}
