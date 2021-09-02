package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 1780번 종이의 개수 */
public class boj_1780 {

	static int N;
	static int[] cnt = new int[3];
	static int[][] paper;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		paper = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		divide(0, 0, N);
		sb.append(cnt[2] + "\n").append(cnt[0] + "\n").append(cnt[1]);
		
		System.out.println(sb);
	}
	
	static void divide(int x, int y, int size) {
		if(checkNum(x, y, size, paper)) {
			if(paper[x][y] == -1) {
				cnt[2]++;
			}else if(paper[x][y] == 1){
				cnt[1]++;
			}else {
				cnt[0]++;
			}
			return;
		}
		
		int resize = size/3;
		
		divide(x, y, resize); // 1
		divide(x+resize, y, resize); // 2
		divide(x+(resize * 2), y, resize); // 3
		
		divide(x, y + resize, resize); // 4
		divide(x + resize, y + resize, resize); // 5
		divide(x + (resize * 2), y + resize, resize);
		
		divide(x, y + (resize * 2), resize); // 6
		divide(x + resize, y + (resize * 2), resize); // 7
		divide(x + (resize * 2), y + (resize * 2), resize); // 8
		
	}
	static boolean checkNum(int x, int y, int size, int[][] temp) {
		for (int i = x; i < x+size; i++) {
			for (int j = y; j < y+size; j++) {
				if(paper[i][j] != temp[x][y]) return false;
			}
		}
		return true;
	}
}
