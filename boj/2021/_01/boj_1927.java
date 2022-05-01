package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/* boj 1927번 최소 힙 */
public class boj_1927 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		
		while(N-->0) {
			int input = Integer.parseInt(br.readLine());
			if(input == 0) {
				System.out.println(queue.isEmpty() ? 0 : queue.poll());
			}else queue.offer(input);
		}
	}
}
