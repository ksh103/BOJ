package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 1145번 적어도 대부분의 배수 */
public class boj_1145 {
	
	static int res = Integer.MAX_VALUE;
	static int[] numbers, select;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		numbers = new int[5];
		
		for (int i = 0; i < 5; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		select = new int[3];

		Comb(0, 0, select);
		
		System.out.println(res);
	}
	
	// 조합
	static void Comb(int strIdx, int cnt, int[] select) {
		// 기저조건
		if(cnt == 3) {
			int lcm = select[0];
			
			// 최소공배수
			for (int i = 1; i < 3; i++) {
				lcm = ((lcm * select[i]) / GCD(lcm, select[i]));
			}
			// 세 개로 나누어 지는 가장 작은 자연수
			res = Math.min(res, lcm);
			return;
		}
		
		for (int i = strIdx; i < 5; i++) {
			select[cnt] = numbers[i];
			Comb(i + 1, cnt + 1, select);
		}
	}
	
	// 최대공약수 --> 최소공배수를 구하기 위함
	static int GCD(int a, int b) {
		if(b == 0) return a;
		
		return GCD(b, a%b);
	}
}
