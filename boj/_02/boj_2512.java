package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* boj 2512번 예산 */
public class boj_2512 {

	static int N, M;
	static int[] num;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		num = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		M = Integer.parseInt(br.readLine());
		
		Arrays.sort(num);
		
		int start = 0, end = num[N-1];
	
		while(start <= end) {
			
			int mid = (start + end) / 2;
			
			int sum = 0;
			
			for (int n : num) {
				sum += Math.min(mid, n);
			}
			
			if(M < sum) end = mid - 1;
			else if(M >= sum) start = mid + 1;
		}
		System.out.println(end);
	}
}
