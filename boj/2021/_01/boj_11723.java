package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 11723번 집합 */
public class boj_11723 {

	static int M;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		M = Integer.parseInt(br.readLine());
		int S = 0;
		
		while(M-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String input = st.nextToken();
			int x = 0;
			
			switch (input) {
				// 1 << x와 or 연산
				case "add":
					x = Integer.parseInt(st.nextToken()) - 1;
					S = S | (1 << x);
					break;
				// 1 << x를 ~(not) 연산을 사용해 비트를 뒤집어 and 연산
				case "remove":
					x = Integer.parseInt(st.nextToken()) - 1;
					S = S & ~(1 << x);
					break;
				// 1 << x와 마스킹한 값을 and 연산 -> 0이 아니라면 값 존재
				case "check":
					x = Integer.parseInt(st.nextToken()) - 1;
	                int temp = S & (1 << x);
	                sb.append(((temp == 0) ? 0 : 1) + "\n");
					break;
				// 1 << x와 xor 연산
				case "toggle":
					x = Integer.parseInt(st.nextToken()) - 1;
					S = S^(1 << x);
					break;
				// (1 << 21) - 1로 값 변경	
				case "all":
					S = (1 << 21) - 1;
					break;
				// 공집합 : 0으로 변경
				case "empty":
					S = 0;
					break;
			}

		}
		System.out.println(sb.toString());

	}

}
