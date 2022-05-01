package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* boj 2954번 창영이의 일기장 */
public class boj_2954 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		for(int i = 0; i < input.length; i++) {
			input[i] = input[i].replaceAll("apa", "a");
			input[i] = input[i].replaceAll("epe", "e");
			input[i] = input[i].replaceAll("ipi", "i");
			input[i] = input[i].replaceAll("opo", "o");
			input[i] = input[i].replaceAll("upu", "u");
		}
		
		for(int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
	}
}
