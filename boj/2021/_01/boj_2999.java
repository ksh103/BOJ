package com.boj.im;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* boj 2999번 비밀 이메일 */
public class boj_2999 {

	static char[][] map;
	static int N, R, C;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		char[] arr = input.toCharArray();
		N = arr.length; // 문자열 길이
		
		
		/* R, C의 조건 : R <= C, R*C = N */
		for(int i = 1; i <= N; i++) {
			if(N % i == 0 && i <= N / i) {
				R = Math.max(i, R);
				C = N / R;
			}
		}
		
		int inx = 0;
		map = new char[R][C];
		for(int i = 0; i < C; i++) {
			for(int j = 0; j < R; j++) {
				map[j][i] = arr[inx++];
			}
		}

		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				System.out.print(map[i][j]);
			}
		}
	}
}
