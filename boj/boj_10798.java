package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* boj 10798번 세로 읽기 */
public class boj_10798 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		char[][] str = new char[5][15];
		
		for (int i = 0; i < 5; i++) {
			String input = br.readLine().trim();
			for (int j = 0; j < input.length(); j++) {
				str[i][j] = input.charAt(j);
			}
		}
		
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 5; j++) {
				if(str[j][i] == '\0') continue;
				sb.append(str[j][i]);
			}
		}
		System.out.println(sb);
	}
}

/* https://blog.shovelman.dev/468 */
