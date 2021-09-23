package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* boj 1157번 단어 공부 */
public class boj_1157 {

	public static void main(String[] args) throws Exception {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		 int[] alpha = new int[26];
		 String input = br.readLine().toUpperCase(); // 대상 문자열을 대문자로 변환
		 int max = 0, idx = 0;
		 boolean check = false;
		 
		 for (int i = 0; i < input.length(); i++) {
			 alpha[input.charAt(i) - 'A']++; 
		 }
		 
		 for (int i = 0; i < alpha.length; i++) {
			if(max < alpha[i]) {
				max = alpha[i];
				check = false;
				idx = i;		
			}else if(max == alpha[i]) {
				check = true;
			}
		 }
		 if(check) {
			 System.out.println("?");
		 }else {
			 System.out.println((char)(idx + 'A'));
		 }
	}
}
