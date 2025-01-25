package com.swea.im;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* swea 7964번 부먹왕국의 차원 관문 (D3) */
public class swea_7964 {

	static int N, D;
	static int[] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken()); // 부먹 왕국의 도시 수
			D = Integer.parseInt(st.nextToken()); // 제한 거리
			
			map = new int[N+1]; // 지도 정보
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				map[i] = Integer.parseInt(st.nextToken());
			}
			
			int gate = 0;
			int cnt = 0;
			for (int i = 1; i <= N; i++) {
				if(map[i] == 1) { // 1(차원 관문)이 존재하면 그 위치 인덱스를 저장.
					gate = i;
				}
				// 현재 위치에 차원 관문이 없고 (차원 관문 위치  -> 현재 위치까지) 최소 거리를 만족할 때 차원의 문 설치
				else if(map[i] == 0 && i - gate == D) { 
					cnt++;
					gate = i;
				}
			}
			System.out.println("#" + t + " " + cnt);
		}
	}
}
