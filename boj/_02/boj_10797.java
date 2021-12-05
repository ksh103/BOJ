package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 10797번 10부제 */
public class boj_10797 {

	static int day;
	static int[] car = new int[5];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		day = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int count = 0;
		for (int i = 0; i < 5; i++) {
			car[i] = Integer.parseInt(st.nextToken());
			
			if(car[i] == day) {
				count++;
			}
		}
		System.out.println(count);
	}
}
