package com.jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* jungol 1037번 오류교정 */
public class jungol_1037 {

	static int N;
	static int[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		
		// 행렬 저장
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 행과 열의 합
		int x = 0, y = 0;
		int cnt1 = 0, cnt2 = 0;
		for (int i = 1; i <= N; i++) {
			int sum1 = 0;
			int sum2 = 0;
			for (int j = 1; j <= N; j++) {
				sum1 += map[i][j]; // 행의 합
				sum2 += map[j][i]; // 열의 합
			}
				
			if(sum1 % 2 != 0) {
				y = i;
				cnt1++;
			}
			
			if(sum2 % 2 != 0) {
				x = i;
				cnt2++;
			}
		}
		
		// 출력
		if(cnt1 == 0 && cnt2 == 0) { // 행렬이 패리티 성질을 가질 경우
			System.out.println("OK");
		}else if(cnt1 == 1 && cnt2 == 1) { // 하나의 비트만 변경해서 패리티 성질을 가지는 경우
			System.out.println("Change bit ("+ y +","+ x +")");
		}else { // 두 경우에 해당하지 않은 경우
			System.out.println("Corrupt");
		}
	}
}
