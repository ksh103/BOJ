package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

/* boj 11279번 최대 힙 */
public class boj_11279 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
		
		int N = Integer.parseInt(br.readLine());
		
		while(N-->0) {
			int input = Integer.parseInt(br.readLine());
			if(input == 0) {
				System.out.println(queue.isEmpty() ? 0 : queue.poll());
			}else queue.offer(input);
		}
	}
}
