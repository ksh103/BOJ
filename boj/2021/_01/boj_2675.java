package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 2675번 문자열 반복 */
public class boj_2675 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int R = Integer.parseInt(st.nextToken());
			String S = st.nextToken();
		
			for (int i = 0; i< S.length(); i++) {
				for (int j = 0; j < R; j++) {
					System.out.print(S.charAt(i));
				}
				
			}
			System.out.println();
		}
	}
}
