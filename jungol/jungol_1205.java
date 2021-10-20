package com.jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* jungol 1205번 조커 */
public class jungol_1205 {

	static int N;
	static int[] card;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		card = new int[N];
		
		int jokerCnt = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
			
			// 조커 개수 세기
			if(card[i] == 0) jokerCnt++;
		}
		// 카드 오름차순 정렬
		Arrays.sort(card);
		if(jokerCnt == N) {
			System.out.println(N);
			return;
		}
		
		int result = 0;
		for (int i = jokerCnt; i < N; i++) {
			
			int straight = 1;
			int re = jokerCnt;
			
			for (int j = i; j < N - 1; j++) {
				int gap = card[j + 1] - card[j];
				
				// 카드의 차가 1일 때 --> 스트레이트
				if (gap == 1) straight++;
				// 카드의 차가 1이상일 때
				else if(gap > 1) {
					// 카드의 차가 jokerCnt 개수보다 크면 straight가 되기 위해 joker를 사이에 넣는다.
					// 조커 개수 초기화
					// 종료
					if((gap - 1) > re) {
						straight += re;
						re = 0;
						break;
					}else {
						// 카드의 차가 jokerCnt 개수보다 작으면
						straight += (gap); // 카드의 차 == 카드 길이를 넣고
						re -= (gap - 1); // 조커 개수 갱신
					}
				}
			}
			straight += re; // 남은 조커 개수는 뒤에 붙여주기
			result = Math.max(result, straight);
		}
		System.out.println(result);
	}
}
