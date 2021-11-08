package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 3040번 백설공주와 일곱난쟁이 */
public class boj_3040 {

	static int[] cap = new int[9];
	static int[] num = new int[7];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			cap[i] = Integer.parseInt(st.nextToken());
		}
		
		Comb(0,0);
	}

	// 조합 
	static void Comb(int cnt, int strIdx) {
		int result = 0;
		// 기저조건
		// 난쟁이 7명 탐색 했을 때
		if(cnt == 7) {
			// 난쟁이 모자 합이 100일때 난쟁이 모자 합 담기
			for(int i = 0; i < 7; i++) {
				result+=num[i];
			}
			// 난쟁이 모자 합이 100일 때 진짜 난쟁이들 번호 출력
			if(result == 100) {
				for(int j = 0; j < 7; j++) {
					System.out.println(num[j]);
				}
			}
			return;
		}
		// 난쟁이 모자 번호 카운트
		for(int i = strIdx; i < 9; i++) {
			num[cnt] = cap[i];
			Comb(cnt+1, i+1);
		}
	}
}