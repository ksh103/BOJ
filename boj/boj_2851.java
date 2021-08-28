package com.boj.im;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* boj 2851번 슈퍼 마리오 */
public class boj_2851 {

	static int[] mushroom = new int[10];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i < 10; i++) {
			mushroom[i] = Integer.parseInt(br.readLine());	
			
		}
		
		int sum = 0;
		int ans = 0;
		
		for(int i = 0; i < 10; i++) {
			sum += mushroom[i];
			
			int a = Math.abs(100 - sum);
			int b = Math.abs(100 - sum + mushroom[i]);
			
			// 합이 100일 때
			if(sum == 100) {
				ans = sum;
				break;
			}
			// 합이 100보다 클 때
			if(sum > 100) {
				// 현재 합의 차이와 그 다음 합 차이가 같으면
				if(a == b) {
					// 합이 큰 값을 선택
					ans = Math.max(sum, sum+mushroom[i]);
				}
				// 현재 합이 차이가 그 다음 합 차이보다 크면
				if(a > b) {
					ans = sum - mushroom[i];
				}else {
					ans = sum;
				}
				break;
			}
			else {
				ans = sum;
			}
		}
		
		System.out.println(ans);
	}
}
