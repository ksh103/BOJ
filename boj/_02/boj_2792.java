package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* boj 2792번 보석 상자 */
public class boj_2792 {

	static int N, M;
	static int[] color;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 아이들 수
		M = Integer.parseInt(st.nextToken()); // 색상의 수
		
		color = new int[M];
		
		for (int i = 0; i < M; i++) {
			color[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(color);
		
		int start = 1, end = color[M-1];

		int result = 0;
		while(start <= end) {
			int mid = (start + end) / 2;
			
			int sum = 0;
			
			for (int i = 0; i < M; i++) {
				if(color[i] % mid == 0) sum += (color[i] / mid);
				else sum += (color[i] / mid) + 1;
			}
			if(N < sum) start = mid + 1;
			else {
				result = mid;
				end = mid - 1;
			}
		}
		System.out.println(result);
	}
}
