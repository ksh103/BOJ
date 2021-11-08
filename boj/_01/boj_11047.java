package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 11047번 동전 0 */
public class boj_11047 {

	static int N, K, count;
	static int[] coin;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 동전 종류
		K = Integer.parseInt(st.nextToken()); // 가치의 합
		
		coin = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			coin[i] = Integer.parseInt(br.readLine()); // 동전 종류 담기
		}
		
		change(coin, K);
		System.out.println(count);

	}
	static void change(int[] coin, int money) {
		count = 0;
		// 가치가 큰 거부터 탐색(가치가 작은거 부터 탐색하니까 1원으로 제일 먼저 동전 개수를 계산함)
		for(int i = N; i >= 1; i--) {
			if(money >= coin[i]) {
				count += money / coin[i];
				money %= coin[i];
			}
		}
	}
}
