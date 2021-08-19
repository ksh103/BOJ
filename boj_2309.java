package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* boj 2309번 일곱 난쟁이 */
public class boj_2309 {

	static int[] height = new int[9];
	static int[] num = new int[7];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			height[i] = Integer.parseInt(st.nextToken());
		}
		
		Comb(0, 0);

	}
	
	// 조합
	static void Comb(int cnt, int strIdx) {
		int result = 0;
		// 기저조건
		// 난쟁이 7명 카운트 했을 때
		if(cnt == 7) {
			// 난쟁이 7명의 키 합
			for(int i = 0; i < 7; i++) {
				result += num[i];
			}
			// 난쟁이 7명의 키 합이 100일 때
			if(result == 100) {
				for(int j = 0; j < 7; j++) {
					Arrays.sort(num); // 오름차순 정렬
					System.out.println(num[j]);
				}
			}
			return;
		}
		
		// 진짜 난쟁이를 찾기 (난쟁이 9명 중 7명 뽑기)
		for(int i = strIdx; i < 9; i++) {
			num[cnt] = height[i];
			Comb(cnt+1, i+1);
		}
	}
}
