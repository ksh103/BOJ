package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* boj 1920번 수 찾기 */
public class boj_1920 {

	static int N, M;
	static int[] A; 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		A = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A);
		
		M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		while(M-->0) {
			int findNum = Integer.parseInt(st.nextToken());
			
			int start = 0, end = N-1, result = 0;
			
			while(start <= end) {
				int mid = (start + end) / 2; // 중간값
				
				if(A[mid] == findNum) {
					result = 1;
					break;
				}
				if(findNum < A[mid]) end = mid - 1;
				else if(findNum > A[mid]) start = mid + 1;
			}
			System.out.println(result);
		}
	}
}
