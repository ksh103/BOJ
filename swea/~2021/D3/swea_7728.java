package com.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* swea 7728번 다양성 측정 (D3) */
public class swea_7728 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= testCase; t++) {
			
			String str = br.readLine();
			
			int[] numbers = new int[10];

			for (int i = 0; i < str.length(); i++) {
				numbers[str.charAt(i) - '0']++;
			}
			
			int cnt = 0;
			for (int i = 0; i < 10; i++) {
				if(numbers[i] > 0) cnt++;
			}
			
			System.out.println("#" + t + " " + cnt);
		}
	}
}
