package com.boj.im;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* boj 8320번 직사각형을 만드는 법 */
public class boj_8320 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = i; j <= N; j++) {
				if(i * j <= N) {
//					System.out.println(i + " * " + j);
					cnt++;
				}
			}
		} 
		System.out.println(cnt);
	}
}
