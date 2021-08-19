package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 2875번 대회 or 인턴 */
public class boj_2875 {

	static int N, M, K, cnt, team = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken()); // 여학생 수
		M = Integer.parseInt(st.nextToken()); // 남학생 수
		K = Integer.parseInt(st.nextToken()); // 인턴쉽 참여 인원
		
		team = N + M - K; // = 대회 나가는 진짜 인원
		cnt = 0;
		
		// 여학생 수는 2보다 크거나 같을때, 남학생 수는 1보다 크거나 같을 때, 대회나가는 인원은 3보다 크거나 같을때까지
		while(N >= 2 && M >= 1 && team >= 3) {
			N -= 2;
			M -= 1;
			team -=3;
			cnt++;
		}
		System.out.println(cnt);
	}
}
