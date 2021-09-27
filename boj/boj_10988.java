package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* boj 10988번 팰린드롬인지 확인하기 */
public class boj_10988 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		
		int half = input.length() / 2;
		int length = input.length() - 1;
		
		for (int i = 0; i < half; i++, length--) {
			if(input.charAt(i) != input.charAt(length)) {
				System.out.println(0);
				return;
			}
		}
		System.out.println(1);
	}
}
