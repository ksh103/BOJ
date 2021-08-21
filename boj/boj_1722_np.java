package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/* boj 1722번 순열의 순서 */
// np --> 시간 초과 난다.
public class boj_1722_np {

	static int N, K, I;
	static int[] numbers;
	
	static StringBuilder sb = new StringBuilder();
	static ArrayList<String> list = new ArrayList<String>();
	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		
		numbers = new int[N];
		// 순열을 만들 배열 생성
		for(int i = 0; i < N; i++) {
			numbers[i] = i+1;
		}
		
		switch (K) {
		// I번째 순열 찾기
		case 1:
			I = Integer.parseInt(st.nextToken());
			
			while(true) {
				check(0);
				if(!np()) break;
			}
			
			System.out.println(list.get(I-1));
			break;

		// 입력 한 순열이 몇번째 순열인지
		case 2:
			for(int i = 0; i < N; i++) {
				sb.append(st.nextToken()).append(" ");
			}
			sb.substring(0, sb.length()-1);
			String input = sb.toString();
			
			while(true) {
				check(0);
				if(!np()) break;
			}
			
			for(int i = 0; i < N; i++) {
				if(input.equals(list.get(i))) {
					System.out.println(i+1);
				}
			}
			break;
		}
	}
	
	static void check(int strIdx) {
		if(strIdx == N) {
			sb = new StringBuilder();
			for(int i = 0; i < N; i++) {
				sb.append(numbers[i]).append(" ");
			}
			list.add(sb.toString());
			return;
		}
		
		check(strIdx + 1);
	}
	
	static boolean np() {
		// 꼭대기 찾기
		int i = N - 1;
		while(i > 0 && numbers[i-1] >= numbers[i]) --i;
		
		if(i == 0) return false;
		
		int j = N - 1;
		while(numbers[i-1] >= numbers[j]) --j;
		
		swap(numbers, i-1, j);
		
		int k = N - 1;
		while(i < k) {
			swap(numbers, i++, k--);
		}
		
		return true;
	}
	
	static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
}
