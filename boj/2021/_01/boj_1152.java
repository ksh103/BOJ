package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* boj 1152번 단어의 개수 */
public class boj_1152 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine().trim();
		String[] result = input.split(" ");
		
		if(input.isEmpty()) {
			System.out.println(0);
		}else {
			System.out.println(result.length);
		}
	}
}
