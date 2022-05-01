package com.boj.im;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 2798번 블랙잭 */
public class boj_2798 {

	static int N, M, result;
	static int[] card, select;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		card = new int[N];
		select = new int[3];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		
		result = Integer.MIN_VALUE;
		check(0, 0);
		System.out.println(result);

	}
	
	static void check(int strIdx, int cnt) {
		// 카드 3장 뽑았을 때
		if(cnt == 3) {
			int sum = 0;
			for (int i = 0; i < 3; i++) sum += select[i];

			// 합이 M을 넘지 않으면서 M에 가장 가까운 합 구하기
			if(sum <= M) result = Math.max(result, sum);
			return;
		}
		
		for(int i = strIdx; i < N; i++) {
			select[cnt] = card[i];
			check(i+1, cnt+1);
		}
	}
}
