package com.boj.im;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 1592번 영식이와 친구들 */
public class boj_1592 {

	static int N, M, L;
	static int[] count;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 명 수
		M = Integer.parseInt(st.nextToken()); // 공 받은 횟수
		L = Integer.parseInt(st.nextToken()); // 순서
		
		count = new int[N];
		
		// 1번 자리에 앉은 사람이 공을 받음.
		count[0] = 1;
		int idx = 0;
		
		while(true) {
			// 한 사람이 공을 M번 받으면 게임 끝
			if(count[idx] == M) break;
			
			// 현재 공을 받은 횟수가 홀수번이면 
			if(count[idx] % 2 != 0) {
				// 자기의 현재 위치에서 시계방향으로 L번째 있는 사람에게 공을 던진다.
				idx = (idx + L) % N;
				count[idx]++;
			}
				// 짝수번이면 
			else if(count[idx] % 2 == 0) {
				// 자기의 현재 위치에서 반시계 방향으로 L번째 있는 사람에게 공을 던진다.
				if(idx - L < 0) idx = idx - L + N;
				else idx = idx - L;

				count[idx]++;
			}
		}
		
		int sum = 0;
		for(int i = 0; i< N; i++) {
			sum += count[i];
		}

		System.out.println(sum - 1);
	}
}
