package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 7568번 덩치 */
public class boj_7568 {

	static int N;
	static int[] weight, height, rank;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		weight = new int[N];
		height = new int[N];
		rank = new int[N];
		
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			weight[i] = Integer.parseInt(st.nextToken());
			height[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(i == j) continue;
				if(weight[i] < weight[j] && height[i] < height[j]) {
					rank[i]++;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			System.out.print((rank[i] + 1) + " ");
		}
	}
}
