package com.jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* jungol 2074번 홀수 마방진 */
public class jungol_2074 {

	static int N;
	static int[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		int nx = 0;
		int ny = N/2;
		for (int i = 1; i <= N*N; i++) {
			map[nx][ny] = i;
			// 배수이면 바로 아래의 행으로 이동하여 다음 수를 넣는다.
			if(map[nx][ny] % N == 0) {
				nx++;
			}else {
				nx--;
				ny--;
					
				if(nx < 0) nx = N-1;
				if(ny < 0) ny = N-1;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
