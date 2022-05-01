package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 2920번 음계 */
public class boj_2920 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] input = new int[9];
		
		for (int i = 1; i <= 8; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		String output = "";
		for (int i = 1; i < 8; i++) {
			if(input[i] == input[i+1] - 1) {
				output = "ascending";
			}else if(input[i] == input[i+1] + 1) {
				output = "descending";
			}else {
				output = "mixed";
				break;
			}
		}
		System.out.println(output);

	}

}
