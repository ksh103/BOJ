package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* boj 1475번 방 번호 */
public class boj_1475 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] number = br.readLine().toCharArray();
		int[] set = new int[10];
		int size = number.length;
		int max = 0;
		
		for (int i = 0; i < size; i++) {
			if(number[i] == '6' || number[i] == '9') {
				if(set[6] < set[9]) {
					max = Math.max(++set[6], max);
				}else {
					max = Math.max(++set[9], max);
				}
			}else {
				max = Math.max(++set[number[i] - '0'], max);
			}
		}
		System.out.println(max);
	}
}
