package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/* boj 9093번 단어 뒤집기 */
public class boj_9093 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<String> st = new Stack<>();
		StringBuilder sb= new StringBuilder();
		
		int testCase = Integer.parseInt(br.readLine());
		
		while(testCase --> 0) {
			String input = br.readLine() + " ";
			for (int i = 0; i < input.length(); i++) {
				if(input.charAt(i) == ' ') {
					while(!st.isEmpty()) {
						sb.append(st.pop());
					}
					sb.append(" ");
				}else {
					st.push(input.charAt(i) + "");
				}
			}
			System.out.println(sb);
			sb.setLength(0);
		}
	}
}
