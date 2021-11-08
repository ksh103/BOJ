package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/* boj 2075번 N번째 큰 수 */
public class boj_2075 {

	static int N;
	static PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		// 우선순위 큐 내림차순으로 정렬
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}
		}
		
		// 내림차순 정렬 된 숫자를 N-1까지 poll하기.
		for (int j = 0; j < N-1; j++) {
			queue.poll();
		}
		
		// 조회
		System.out.println(queue.peek());
	}
}
