package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* boj 2775번 부녀회장이 될테야 */
public class boj_2775 {

	static int T;
	static int[][] apt = new int[15][15];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 15; i++) {
			apt[i][1] = 1;
			apt[0][i] = i;
		}
		
		for (int i = 1; i < 15; i++) {
			for (int j = 2; j < 15; j++) {
				apt[i][j] = apt[i][j - 1] + apt[i - 1][j];
			}
		}
		
		T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			int n = Integer.parseInt(br.readLine());
			int k = Integer.parseInt(br.readLine());
			
			System.out.println(apt[n][k]);
		}
	}

}
