package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* boj 2110번 공유기 설치 */
public class boj_2110 {

	static int N, C;
	static int[] wifi, hp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		wifi = new int[N];
		
		for (int i = 0; i < N; i++) {
			wifi[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(wifi);
		
		binarySearch(wifi);
	}
	
	static void binarySearch(int[] wifi) {
		int start = 1;
		int end = wifi[N-1] - wifi[0];
		
		int result = 0;
		
		while(start <= end) {
			int mid = (start + end) / 2;
			
			// C개 이상 설치 가능하면 간격 늘리고 아니면 줄인다.
			if(check(mid)) { 
				result = Math.max(result, mid);
				start = mid + 1;
			}else end = mid - 1;
			
		}
		System.out.println(result);
	}
	
	static boolean check(int d) {
		int tmp = wifi[0];
		int cnt = 1;
		
		for (int i = 0; i < N; i++) {
			// 간격이 mid보다 크거나 같으면 공유기 설치
			if(wifi[i] - tmp >= d) {
				cnt++;
				tmp = wifi[i];
			}
		}
		// C개 이상 설치 가능하면 true
		if(cnt >= C) return true;
		return false;
	}
}
