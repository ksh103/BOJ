package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* boj 1789번 수들의 합 */
public class boj_1789 {
	
	static long S;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		S = Long.parseLong(br.readLine());
		
		long cnt = 0, sum = 0;
		
		while(sum <= S) {
			if(sum <= S) {
				cnt++;
				sum += cnt;
			}
		}
		System.out.println(cnt-1);
	}
}
