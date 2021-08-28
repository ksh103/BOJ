package com.boj.im;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 2578번 빙고 */
public class boj_2578 {

	static int call, count;
	static boolean[] visit;
	static int[][] bingo = new int[5][5]; 
	
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 5; j++) {
				bingo[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < 25; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 5; j++) {
				call = Integer.parseInt(st.nextToken());
				count++;
				check(call);
				
				if(Bingo()) {
					System.out.println(count);
					return;
				}
			}
		}
	}
	
	static boolean Bingo() {
		int cnt = 0, bingoCnt = 0;
		// 가로
		for(int i = 0; i < 5; i++) {
			cnt = 0;
			for(int j = 0; j < 5; j++) {
				if(bingo[i][j] == 0) cnt++;
				else break;
			}
			if(cnt == 5) {
				bingoCnt++;
			}
		}
		
		// 세로
		for (int i = 0; i < 5; i++) {
			cnt = 0;
			for (int j = 0; j < 5; j++) {
				if(bingo[j][i] == 0) cnt++;
				else break;
			}
			if(cnt == 5) {
				bingoCnt++;
			}
		}
		// 대각선 (왼 -> 오)
		cnt = 0;
		for(int i = 0; i < 5; i++) {
			if(bingo[i][i] == 0) cnt++;
			else break;
		}
		if(cnt == 5) {
			bingoCnt++;
		}
		
		// 대각선 (오 -> 왼)
		cnt = 0;
		for(int i = 0; i < 5; i++) {
			if(bingo[i][4-i] == 0) cnt++;
			else break;
		}
		if(cnt == 5) {
			bingoCnt++;
		}
		
		if(bingoCnt >= 3) return true;
		return false;
	}
	
	static void check(int n) {
		// 불러주는 숫자랑 같으면 0처리
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if(bingo[i][j] == n) {
					bingo[i][j] = 0;
				}
			}
		}
	}
}
