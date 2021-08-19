package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* boj 10974번 모든 순열 */
public class boj_10974 {

	static int N;
	static int[] number;
	static boolean[] isSelected;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		number = new int[N];
		isSelected = new boolean[N+1];
	
		Perm(0);
	}
	
	// 순열
	static void Perm(int tgtIdx) {
		if(tgtIdx == N) {
//			System.out.println(Arrays.toString(number));
			for(int i = 0; i < N; i++) {
				System.out.print(number[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			if(isSelected[i]) continue;
			
			isSelected[i] = true; // 선택
			number[tgtIdx] = i; // 1부터 N까지 순열을 중복 없이 순서대로 넣는다.
			Perm(tgtIdx+1);
			isSelected[i] = false; // 선택 해제
		}
	}
}