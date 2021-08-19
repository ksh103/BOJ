package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/* boj 1931번 회의실 배정 */
public class boj_1931 {

	static int N, count, last;
	static int[][] meeting;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		meeting = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			meeting[i][0] = Integer.parseInt(st.nextToken()); // 시작시간
			meeting[i][1] = Integer.parseInt(st.nextToken()); // 종료시간
		}
		
		/*
		 * 1. 첫번째 파라미터 객체 < 두번째 파라미터 객체 : 음수 return
		 * 2. 첫번째 파라미터 객체 = 두번째 파라미터 객체 : 0 return
		 * 3. 첫번째 파라미터 객체 > 두번째 파라미터 객체 : 양수 return
		 * 음수 또는 0이면 객체 자리 유지되며, 양수인 경우 두 객체의 자리가 변경된다. 
		 */
		Arrays.sort(meeting, new Comparator<int[]>() {
			@Override
			public int compare(int[] t1, int[] t2) {
				// 종료시간이 같을 경우 시작시간이 빠른 순으로 정렬
				if(t1[1] == t2[1]) {
					// t1의 시작하는 시간이 더 빠르면 음수 -> 위치 바뀌지 않음
					// t1의 시작하는 시간이 더 크면 양수 -> 둘의 위치 바뀜
					return t1[0] - t2[0];
				}
				// 두 개의 끝나는 시간 비교해서 t1이 더 빨리 끝나는 경우 자리 변경 없고 더 늦게 끝날 경우 t2와 자리 바뀜
				return t1[1] - t2[1];
			}
		});

		int count = 0;
		int endTime = 0;
		for(int i = 0; i < N; i++) {
			// 회의 종료 시간이 시작 시간과 같거나 작을 경우 다음 회의 시작 시간의 종료 시간을 넣어주고 count
			if(endTime <= meeting[i][0]) {
				endTime = meeting[i][1];
				count++;
			}
		}
		System.out.println(count);
		
	}
}
