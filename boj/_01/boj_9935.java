package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* boj 9935번 문자열 폭발 */
public class boj_9935 {

	static String input, bomb;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		input = br.readLine();
		bomb = br.readLine();
		
		
		// 문자열이 폭발 문자열을 포함하고 있는 경우 --> 모두 문자열 폭발 (FRULA)
		// 폭발 시키고 남은 문자열을 순서대로 이어붙여 새로운 문자열을 만든다.
		// 폭발은 폭발 문자열이 문자열에 없을 때까지 계속된다.
		solve(input, bomb);

	}
	
	static void solve(String input, String bomb) {
		for (int i = 0; i < input.length(); i++) {
			sb.append(input.charAt(i));
			
			if(sb.length() < bomb.length()) continue;
			
			if(bomb.equals(sb.substring(sb.length() - bomb.length(), sb.length()))) {
				sb.delete(sb.length() - bomb.length(), sb.length());
			}
		}
		if(sb.length() > 0) {
			System.out.println(sb);
		}else {
			System.out.println("FRULA");
		}
		
	}
}
