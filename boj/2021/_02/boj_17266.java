package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* boj 17266번 어두운 굴다리 */
public class boj_17266 {

	static int N, M;
	static int[] bridge;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		bridge = new int[M];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			bridge[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(bridge);
		
		System.out.println(BinarySearch());	
	}
	
	static int BinarySearch() {
		int start = 0, end = N;
		
		while(start <= end) {
			int mid = (start + end) / 2;
			
			int point = 0;
			for (int i = 0; i < M; i++) {
				if(bridge[i] - point <= mid) {
					point = bridge[i] +  mid;
				}
			}
			if(point >= N) {
				end = mid - 1;
			}else {
				start = mid + 1;
			}
		}
		return start;
	}
}
