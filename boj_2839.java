package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* boj 2839번 설탕 배달 */
public class boj_2839 {

	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		int cnt = 0;

		// 설탕 무게가 5kg 봉지에 나누어 질 때까지
		while(N % 5 != 0) {  
			N -= 3; // 설탕무게 3kg뺀다.
			cnt++; // 3kg 설탕 봉지 카운트
			
			// 설탕 봉지가 0미만이면 -1 출력
			if(N < 0) {
				System.out.println("-1");
				return;
			}
		}
		
		// 설탕 봉지 무게가 5kg 봉지로 나누어 질 때
		if(N % 5 == 0) {
			// 나누고 카운트에 봉지 개수 더하기
			cnt += N/5;
		}
		System.out.println(cnt);
	}
}
