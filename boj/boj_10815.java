package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* boj 10815번 숫자 카드 */
public class boj_10815 {

	static int N, M, temp;
	static int[] cards, nums;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		cards = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		
		M = Integer.parseInt(br.readLine());
		nums = new int[M];
		
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		// 오름차순 정렬
		Arrays.sort(cards);
		
		for (int i = 0; i < M; i++) {
			sb.append(BinarySearch(nums[i])).append(" ");
		}
		System.out.println(sb.toString().trim());
	}
	
	static int BinarySearch(int temp) {
		int left = 0; // 왼쪽
		int right = N - 1; // 오른쪽
		
		while(left <= right) {
			int mid = (left + right) / 2; // 중간값
			
			if(cards[mid] == temp) return 1; // 같으면 1
			
			if(temp < cards[mid]) right = mid - 1;
			else if (temp > cards[mid]) left = mid + 1;
		}
		return 0; // 다르면 0
	}
}
