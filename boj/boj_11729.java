package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* boj 11729번 하노이 탑 이동 순서 */
public class boj_11729 {

	static int N, cnt = 0;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		hanoi(N, 1, 2, 3);
		System.out.println(cnt);
		System.out.println(sb);
	}
	
	static void hanoi(int N, int a, int b, int c) {
		// 종료
		if(N == 1) {
			cnt++; // 이동 횟수
			sb.append(a + " " + c + "\n");
			return;
		}
		// a -> b
		hanoi(N - 1, a, c, b);
		
		// a -> c
		sb.append(a + " " + c + "\n");
		cnt++; // 이동 횟수
		
		// b -> c;
		hanoi(N - 1, b, a, c);
	}
}
