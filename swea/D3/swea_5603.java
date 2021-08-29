package com.swea.im;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* swea 5603번 건초더미 (D3) */
public class swea_5603 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int testCase = Integer.parseInt(br.readLine());
		
		
		for (int t = 1; t <= testCase; t++) {
			
			int N = Integer.parseInt(br.readLine());
			int[] s = new int[N];
			
			int sum = 0;
			for(int i = 0; i < N; i++) {
				s[i] = Integer.parseInt(br.readLine());
				sum += s[i];
			}
			
			int avg = sum / N; // 평균을 구함
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				// 절대값(평균 건초더미의 수 - 현재 건초더미의 수)를 빼서 전부 더함
				cnt += Math.abs(avg - s[i]); 
//				System.out.println(cnt);
			}
			System.out.println("#" + t + " " + cnt / 2);
		}
	}
}
