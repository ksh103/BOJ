package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/* boj 9012번 괄호 */
public class boj_9012 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		Stack<Character> stack = new Stack<>();
		
		while(N-->0) {
			String input = br.readLine();
			
			for (int i = 0; i < input.length(); i++) {
				if(input.charAt(i) == ')' && !stack.isEmpty()) {
					if(stack.peek() == '(') {
						stack.pop();
					}else stack.add(input.charAt(i));
				}else stack.add(input.charAt(i));
			}
			
			if(stack.isEmpty()) System.out.println("YES");
			else System.out.println("NO");
			
			stack.clear();
		}
	}
}
