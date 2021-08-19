package com.boj;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 1080번 행렬 */
public class boj_1080 {

	static int N, M, cnt;
	static int[][] intArr1, intArr2;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		intArr1 = new int[N][M];
		intArr2 = new int[N][M];
		
		// 첫번째 행렬
		for(int i = 0; i < N; i++) {
			String input = br.readLine();
			for(int j = 0; j < M; j++) {
				intArr1[i][j] = input.charAt(j) - '0';
			}
		}
		
		// 두번째 행렬
		for(int i = 0; i < N; i++) {
			String input = br.readLine();
			for(int j = 0; j < M; j++) {
				intArr2[i][j] = input.charAt(j) - '0';
			}
		}
		
		cnt = 0;
		check(intArr1, intArr2);
	}
	
	static void check(int[][] A, int[][] B) {
		// 범위를 왜 N-3,M-3으로 하는지 모르겠음. N-2, M-2가 맞다고 생각했는데 백준 에서는 런타임 에러 뜸.
		for(int i = 0; i <= N-3; i++) {
			for(int j = 0; j <= M-3; j++) {
				// A행렬과 B행렬이 다를 때
				if(A[i][j] != B[i][j]) {
					for(int x = 0; x < 3; x++) {
						for(int y = 0; y < 3; y++) {
							// XOR 연산 사용하면 됨.
							A[i+x][j+y] ^= 1;
						}
					}
					cnt++;
				}
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				// A행렬과 B행렬이 바꾼 후에도 같이 않을 때
				if(intArr1[i][j] != intArr2[i][j]) {
					System.out.println("-1");
					return;
				}
			}
		}
		System.out.println(cnt);
	}
}
