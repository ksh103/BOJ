package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 1987번 알파벳 */
public class boj_1987 {

	static int R, C, max; // 세로 R칸, 가로 C칸
	static char[][] map; // 보드
	static boolean[] selected; // 선택 여부
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][];
		selected = new boolean[26];
		max = Integer.MIN_VALUE;
		
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		// 0행 0열부터 시작(문제에서는 1행 1열이지만, 0 인덱스부터 배열을 넣었기대문에 0, 0)
		check(0, 0, 1);
		System.out.println(max);
	}
	
	static int[] dx = {-1, 1, 0, 0}; // 상 하 좌 우
	static int[] dy = {0, 0, -1, 1};
	static void check(int y, int x, int cnt) {
		
		// 방문처리 (0, 0도 처리됨)
		selected[map[y][x] - 'A'] = true;
		
		// 기저조건
		if(max == 26) return;
	
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || nx >= C || ny < 0 || ny >= R || selected[map[ny][nx] - 'A']) continue;
			check(ny, nx, cnt+1);
			
			// 방문처리 해제
			selected[map[ny][nx] - 'A'] = false;
		}
		// 최대길이 구하기
		max = Math.max(max, cnt);
	}

}
