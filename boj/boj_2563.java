package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 2563번 - 색종이 */
public class boj_2563 {

	static int N, X, Y, sum, SIZE = 100;
	static int[][] paper;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		N = Integer.parseInt(br.readLine());
		
		paper = new int[SIZE][SIZE];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			X = Integer.parseInt(st.nextToken()); // x좌표
			Y = Integer.parseInt(st.nextToken()); // y좌표
			
			// 색종이 가로 세로 길이가 10
			for(int a = X; a < X+10; a++) {
				for (int b = Y; b < Y+10; b++) {
					if(paper[a][b] == 1) continue;
					paper[a][b] = 1;
				}
			}
		}
		
		for(int i = 0; i < SIZE; i++) {
			for(int j = 0; j < SIZE; j++) {
				if(paper[i][j] == 1) sum+=paper[i][j];
			}
		}
		System.out.println(sum);
	}
}
