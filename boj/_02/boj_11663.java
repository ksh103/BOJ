package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* boj 11663번 선분 위의 점 */
public class boj_11663 {

	static int N, M;
	static int[] point;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		point = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			point[i] = Integer.parseInt(st.nextToken()); // 점의 좌표
		}
		
		Arrays.sort(point);
		
		while(M-->0) {
			st = new StringTokenizer(br.readLine());
			
			int startPoint = Integer.parseInt(st.nextToken()); // 시작점
			int endPoint = Integer.parseInt(st.nextToken()); // 끝점
			
			sb.append(end(endPoint) - start(startPoint)).append('\n');
		}
		System.out.println(sb);
	}
	
	static int start(int startPoint) {
		int start = 0, end = N-1;
		
		while(start <= end) {
			int mid = (start + end) / 2;
			
			if(point[mid] < startPoint) {
				start = mid + 1;
			}else {
				end = mid - 1;
			}
			
		}
		return start;
	}
	
	static int end(int endPoint) {
		int start = 0, end = N-1;

		while(start <= end) {
			int mid = (start + end) / 2; 
			
			if(point[mid] > endPoint) {
				end = mid - 1;
			}else {
				start = mid + 1;
			}
		}
		return end + 1;
	}
}
