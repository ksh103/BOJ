package com.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* swea 1240번 1일차 - 단순 2진 암호코드 (D3) */
public class swea_1240 {

	static int N, M;
	static int[][] map;
	static int[] code;

	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
		
			map = new int[N][M];
			
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < M; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}
			
			for (int i = N - 1; i >= 0; i--) {
				for (int j = M - 1; j >= 0; j--) {
					if(map[i][j] == 1) {
						for (int k = 55; k >= 0; k--) {
							sb.append(map[i][j-k]);
						}
						break;
					}
				}
			}
			
			code = new int[8];
			
			int count = 0;
			int index = 0;
			
			while(index < 8) {
				
				StringBuilder cd = new StringBuilder();
				
				for (int i = count; i < count+7; i++) {
					cd.append(sb.charAt(i));
				}
				
				if(cd.toString().equals("0001101")) code[index] = 0;
				else if(cd.toString().equals("0011001")) code[index] = 1;
				else if(cd.toString().equals("0010011")) code[index] = 2;
				else if(cd.toString().equals("0111101")) code[index] = 3;
				else if(cd.toString().equals("0100011")) code[index] = 4;
				else if(cd.toString().equals("0110001")) code[index] = 5;
				else if(cd.toString().equals("0101111")) code[index] = 6;
				else if(cd.toString().equals("0111011")) code[index] = 7;
				else if(cd.toString().equals("0110111")) code[index] = 8;
				else if(cd.toString().equals("0001011")) code[index] = 9;
				
				index++;
				count+=7;
				
				cd.setLength(0);
			}
			
			int check = 0, result = 0;
			int odd = 0, even = 0, sum = 0;

			// (홀수 자리의 합 x 3) + 짝수 자리의 합 + 검증 코드
			for (int i = 0; i < 8; i++) {
				sum += code[i];
				
				if((i + 1) % 2 == 1) odd += code[i];
				else if((i + 1) % 2 == 0) even += code[i];
			}
			
			check = (odd * 3) + even;

			if(check % 10 == 0) result = sum;
			else result = 0;
			
			System.out.println("#" + t + " " + result);
			sb.setLength(0);
		}
	}
}
