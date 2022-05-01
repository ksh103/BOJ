package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/* boj 10866번 덱 */
public class boj_10866 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> dq = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		
		while(N-->0) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			String op = st.nextToken();
			
			switch (op) {
			case "push_front":
				dq.offerFirst(Integer.parseInt(st.nextToken()));
				break;
				
			case "push_back":
				dq.offerLast(Integer.parseInt(st.nextToken()));
				break;
				
			case "pop_front":
				if(dq.isEmpty()) sb.append(-1).append("\n");
				else sb.append(dq.pollFirst()).append("\n");
				break;
				
			case "pop_back":
				if(dq.isEmpty()) sb.append(-1).append("\n");
				else sb.append(dq.pollLast()).append("\n");
				break;
			
			case "size":
				sb.append(dq.size()).append("\n");
				break;
			
			case "empty":
				if(dq.isEmpty()) sb.append(1).append("\n");
				else sb.append(0).append("\n");
				break;
			
			case "front":
				if(dq.isEmpty()) sb.append(-1).append("\n");
				else sb.append(dq.getFirst()).append("\n");
				break;
				
			case "back":
				if(dq.isEmpty()) sb.append(-1).append("\n");
				else sb.append(dq.getLast()).append("\n");
				break;
			}
			
		}
		System.out.print(sb);
	}
}
