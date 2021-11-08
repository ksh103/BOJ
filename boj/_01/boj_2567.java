package com.boj.im;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 2567번 색종이 - 2 */
// 색종이 둘레 구하기
public class boj_2567 {

	static int N, cnt = 0, SIZE = 100;
	static int[][] paper;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		paper = new int[SIZE][SIZE];
		
		for(int t = 1; t <= N; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			
			check(X, Y);
			
		}
		count();
		System.out.println(cnt);
	}
	
	static void check(int x, int y) {
		for(int a = x; a < x+10; a++) {
			for (int b = y; b < y+10; b++) {
				paper[a][b] = 1;
			}
		}
	}
	
	static int[] dx = {-1, 1, 0, 0}; // 상 하 좌 우
	static int[] dy = {0, 0, -1, 1};
	static void count() {
		for(int i = 0; i < SIZE; i++) {
			for(int j = 0; j < SIZE; j++) {
				if(paper[i][j] == 1) {
					for(int k = 0; k < 4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						
						if(nx < 0 || nx >= SIZE || ny < 0 || ny >= SIZE || paper[nx][ny] == 0) {
							cnt++;
						}
					}
				}
			}
		}
	}	
}
