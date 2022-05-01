package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* boj 13413번 오셀로 재배치 */
public class boj_13413 {

	static int T, N;
	static char[] arr, goal;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			N = Integer.parseInt(br.readLine());
			
			arr = new char[N]; // 초기상태
			goal = new char[N]; // 목표상태
			
			arr = br.readLine().toCharArray();
			goal = br.readLine().toCharArray();
			
			int wCnt = 0, bCnt = 0;
			for (int i = 0; i < N; i++) {
				if(arr[i] != goal[i]) {
					if(arr[i] == 'W' && goal[i] == 'B') wCnt++;
					if(arr[i] == 'B' && goal[i] == 'W') bCnt++;
				}
//				System.out.println(wCnt + " " + bCnt);
			}
			System.out.println(Math.max(wCnt, bCnt));
		}
	}
}
