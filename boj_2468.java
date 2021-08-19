package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 2468번 안전 영역 */
public class boj_2468 {

	static int N;
	static int[][] map, temp;
	static boolean[][] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
	
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// 입력 받은 배열 중 가장 큰 수를 구한다.
				max = Math.max(max, map[i][j]);
			}
		}
		
		int result = 1; // 안전 영역이 없는 것을 생각하여 초기화를 1로 지정
		// 입력 받은 수 중 1 ~ 큰값까지의 숫자들을 탐색해서 안전영역 찾기
		for(int m = 1; m <= max; m++) {
			// 카운트랑 방문처리는 for문 안에 초기화를 해야 됨.
			int cnt = 0;
			visited = new boolean[N][N];
			
			for(int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// m이하의 건물들은 물에 잠긴다 -> 잠김 처리
					if(map[i][j] <= m) visited[i][j] = true; 
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					// 물에 잠기지 않고(안전영역) m보다 높은 건물일 때
					if(!visited[i][j] && map[i][j] > m) {
						// 영역별로 카운트
						cnt++;
						DFS(i, j);
					}
				}
			}
			result = Math.max(result, cnt);
		}
		System.out.println(result);
	}
	
	static int[] dx = {-1, 1, 0, 0}; // 상 하 좌 우
	static int[] dy = {0, 0, -1, 1};
	// DFS로 구현
	static void DFS(int y, int x) {
		visited[y][x] = true;
		
		for(int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(nx < 0 || ny < 0|| nx >= N || ny >= N || visited[ny][nx]) continue;
			
			DFS(ny, nx);
		}
	}
}
