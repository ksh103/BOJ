package com.boj.im;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* boj 9655번 돌 게임 */
public class boj_9655 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		System.out.println((N % 2 == 1) ? "SK" : "CY");
	}
}
