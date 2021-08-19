package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// boj 1158. 요세푸스 문제
public class boj_1158 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for(int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		
		sb.append("<");
		while(!queue.isEmpty()) {
			for(int i = 1; i <= K; i++) {
				if(i != K) {
					queue.offer(queue.poll());
				}else {
					sb.append(queue.poll()+ ", ");
				}
			}
		}
		
		sb.setLength(sb.length() - 2);
		sb.append(">");
		System.out.println(sb);
	}
}
