package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* boj 1094번 막대기 */
public class boj_1094 {

	static int X;
	static int[] sticks = new int[7]; // 1, 2, 4, 8, 16, 24, 48, 64
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		X = Integer.parseInt(br.readLine());
		sticks[0] = 64;
		
		for (int i = 1; i < 7; i++) {
			sticks[i] = sticks[i-1] / 2;
		}
		
		int cnt = 0;
		
		while(X > 0) {
			for (int i = 0; i < 7; i++) {
				if(X >= sticks[i]) {
					X -= sticks[i];
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}
