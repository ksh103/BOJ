package com.swea.im;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* swea 5356번 의석이의 세로로 말해요 (D3) */
public class swea_5356 {

	static String[][] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= testCase; t++) {
			// 문자열 길이는 1~15
			arr = new String[5][];
			
			for (int i = 0; i < 5; i++) {
				arr[i] = br.readLine().split("");
			}
			
			sb.append("#" + t + " ");
			for (int i = 0; i < 15; i++) {
				for (int j = 0; j < 5; j++) {
					if(i < arr[j].length) {
						sb.append(arr[j][i]);
					}
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}
