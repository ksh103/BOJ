package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/* boj 1874번 스택 수열 */
public class boj_1874 {

	static int N;
	static Stack<Integer> stack = new Stack<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		int start = 0;
		while(N-->0) {
			int num = Integer.parseInt(br.readLine());
			
			if(num > start) {
				for (int i = start + 1; i <= num; i++) {
					stack.push(i);
					sb.append("+").append("\n");
				}
				start = num;
			}
			
			int top = stack.peek();
			if(top == num) {
				stack.pop();
				sb.append("-").append("\n");
			}else {
				System.out.println("NO");
				return;
			}
		}
		System.out.println(sb);
	}
}
