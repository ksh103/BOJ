package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/* boj 18258번 큐 2 */
public class boj_18258 {

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> queue = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		
		while(N-->0) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			String op = st.nextToken();
			
			switch (op) {
			case "push":
				queue.offer(Integer.parseInt(st.nextToken()));
				break;
				
			case "pop":
				if(queue.isEmpty()) sb.append(-1).append("\n");
				else sb.append(queue.poll()).append("\n");
				break;
			
			case "size":
				sb.append(queue.size()).append("\n");
				break;
			
			case "empty":
				if(queue.isEmpty()) sb.append(1).append("\n");
				else sb.append(0).append("\n");
				break;
			
			case "front":
				if(!queue.isEmpty()) sb.append(queue.getFirst()).append("\n");
				else sb.append(-1).append("\n");
				break;
				
			case "back":
				if(!queue.isEmpty()) sb.append(queue.getLast()).append("\n");
				else sb.append(-1).append("\n");
				break;
			}
			
		}
		System.out.print(sb);
	}
}
