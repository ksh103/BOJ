package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/* boj 2164번 카드2 */
public class boj_2164 {

	static int N;
	static Queue<Integer> queue = new LinkedList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}

		int idx = 1; // 인덱스
		
		while(queue.size() > 1) {
			
			if(idx % 2 == 1) queue.poll();	// 홀수번 차례에 카드를 버림
			else queue.offer(queue.poll());	// 짝수번 차례에 카드를 빼고 밑으로 옮김
			
			idx++;
		}
		System.out.println(queue.peek());
	}
}
