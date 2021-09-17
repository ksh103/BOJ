package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/* boj 2493번 탑 */
public class boj_2493 {

	static int N;
	static Stack<Top> stack = new Stack<Top>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int h = Integer.parseInt(st.nextToken());
			
			// 스택이 비어있지 않을 경우
			while(!stack.isEmpty()) {
				// 스택에 들어 있는 탑의 높이가 입력으로 들어오는 탑보다 높을 경우
				if(stack.peek().height > h) {
					sb.append(stack.peek().index).append(" "); // 스택에 들어 있는 탑의 인덱스 값 저장
					stack.push(new Top (i, h)); // 입력 받은 탑의 높이와 탑의 인덱스 값 스택에 저장
					break;
				}else { 			// 스택에 들어 있는 탑의 높이가 입력으로 들어오는 탑 보다 낮을 경우 
					stack.pop(); 	// pop 시키고 재탐색
				}
			}
			
			// 스택이 비어있을 경우
			if(stack.isEmpty()) {
				sb.append(0).append(" "); 	// 비교할 탑이 없으므로  0
				stack.push(new Top(i, h));	// 현재  
			}
			
		}
		System.out.println(sb);

	}
	
	static class Top{
		int index, height;
		public Top(int index, int height) {
			this.index = index;
			this.height = height;
		}
	}
}


