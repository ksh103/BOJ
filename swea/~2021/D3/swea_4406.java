package com.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* swea 4406번  모음이 보이지 않는 사람 (D3) */
public class swea_4406 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= testCase; t++) {
			String input = br.readLine();
			input = input.replaceAll("a|e|i|o|u", "");
			
			System.out.println("#" + t + " " + input);
		}
	}
}