package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 10972번 이전 순열 */
public class boj_10973 {

	static int N;
	static int[] number;
	static boolean[] isSelected;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		number = new int[N];
		isSelected = new boolean[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
			
		}
		if(np(N, number)) {
			for(int i = 0; i < N; i++) {
				sb.append(number[i]).append(" ");
			}
			System.out.println(sb);
		}else {
			System.out.println("-1");
		}
	}
	
	static boolean np(int N, int[] number) {
		// 꼭대기 찾기
		int i = N - 1;
		while(i > 0 && number[i-1] <= number[i]) --i;
		
		// 기저 조건 (이미 내림차순 정렬 일 때)
		if(i <= 0) return false;
		
		// i-1과 교환할 다음 큰 수 찾기
		int j = N - 1;
		while(number[i-1] <= number[j]) --j;
		
		// i-1과 j교환
		swap (number, i-1, j);
		
		// i-1 뒤쪽(i부터)에 있는 원소를 오름차순
		int k = N - 1;
		while(i < k) {
			swap(number, i++, k--);
		}
		return true;
	}
	
	static void swap(int[] num, int i, int j) {
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}
}
