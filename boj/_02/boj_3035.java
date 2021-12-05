package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 3035번 스캐너 */
public class boj_3035 {

	static int R, C, ZR, ZC;
	static char[][] scan;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		ZR = Integer.parseInt(st.nextToken());
		ZC = Integer.parseInt(st.nextToken());
		
		scan = new char[R * ZR][C * ZC];
		
		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0; j < C; j++) {
				for (int k = 0; k < ZR; k++) {
					for (int l = 0; l < ZC; l++) {
						scan[i * ZR + k][j * ZC + l] = input.charAt(j);
					}
				}
			}
		}
		
		for (int i = 0; i < R * ZR; i++) {
			for (int j = 0; j < C * ZC; j++) {
				System.out.print(scan[i][j]);
			}
			System.out.println();
		}
	}
}
