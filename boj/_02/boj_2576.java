package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* boj 2576번 홀수 */
public class boj_2576 {

	static int sum = 0, cnt = 0, min = Integer.MAX_VALUE;
	static int[] oddNum = new int[7];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 7; i++) {
			oddNum[i] = Integer.parseInt(br.readLine());
			
			if(oddNum[i] % 2 != 0) {
				cnt++;
				sum += oddNum[i];
				if(oddNum[i] < min) {
					min = oddNum[i];
				}
			}
		}
		if(cnt == 0) System.out.println(-1);
		else System.out.println(sum + "\n" + min);
	}
}
