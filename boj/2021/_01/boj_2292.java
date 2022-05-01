package com.boj.im;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* boj 2292번 벌집 */
public class boj_2292 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		int index = 1, count = 1;
		while(true) {
			// 기저조건
			if(count >= N) break;
		
			count += (6 * index);
			index++;
		}
		
		System.out.println(index);
	}
}
