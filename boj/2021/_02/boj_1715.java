package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/* boj 1715번 카드 정렬하기 */
public class boj_1715 {

	static int N;
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			pq.offer(Integer.parseInt(br.readLine()));
		}
	
		int sum = 0, res = 0;
		while(pq.size() > 1) {
			int num1 = pq.poll();
			int num2 = pq.poll();
			sum = (num1 + num2);
			res += sum;
			pq.offer(sum);
		}
		System.out.println(res);
	}
}
