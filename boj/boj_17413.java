package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/* boj 17413번 단어 뒤집기 2 */
public class boj_17413 {

	static Stack<Character> st = new Stack<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine() + "\n";
		boolean check = false;
		
		for (int i = 0; i < input.length(); i++) {
			if(input.charAt(i) == '<'){
				while(!st.isEmpty()) {
					sb.append(st.pop());
				}
				sb.append(input.charAt(i));
				check = true;
				
			}else if(input.charAt(i) == '>') {
				sb.append(input.charAt(i));
				check = false;
			}else {
				if(check == true) sb.append(input.charAt(i));
				else {
					if(input.charAt(i) == ' ' || input.charAt(i) == '\n') {
						while(!st.isEmpty()) {
							sb.append(st.pop());
						}
						if(input.charAt(i) == ' ') sb.append(' ');
					}else st.push(input.charAt(i));
				}
			}
		}
		System.out.println(sb.toString());
	}
}
