package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 1182번 부분수열의 합 */
public class boj_1182 {

	static int N, S, count = 0;
	static int[] number;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		number = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			
			number[i] = Integer.parseInt(st.nextToken());
		}
		
		Subset(0, 0);
		// 합이 0일 때는 공집합이 포함되므로 1을 빼줘야한다.
		if(S == 0) {
			count-=1;
		}
		System.out.println(count);
	}
	
	// 부분 집합
	static void Subset(int strIdx, int sum) {
		// 기저조건
		// 합에 만족할때
		int crrSum = 0;
		if(strIdx == N) {
			if(sum == S) count++;
			return;
		}
		crrSum = sum + number[strIdx];
		Subset(strIdx + 1, crrSum); // 선택 O
		Subset(strIdx + 1, sum); // 선택 X
	}
}
