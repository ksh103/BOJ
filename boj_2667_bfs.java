package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* boj 2267번 단지번호붙이기 */
public class boj_2667_bfs {

	static int N, COUNT;
	static int[][] building; // 단지
	static int[] result; // 단지 내 건물 카운트
	static boolean[][] visited; // 방문 확인
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		building = new int[N][N];
		visited = new boolean[N][N];
		result = new int[N * N];
		
		COUNT = 0;
		for(int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < N; j++) {
				building[i][j] = input.charAt(j) - '0';
				visited[i][j] = false;
			}
		}
		for(int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 건물이 1이고 방문 하지 않았을 때
				if(building[i][j] == 1 && !visited[i][j]) {
					visited[i][j] = true; // 방문 표시
					bfs(i, j); // 탐색
					COUNT++; // 단지 카운트
				}
			}
		}
		
		System.out.println(COUNT); // 단지가 몇개인지
		Arrays.sort(result); // 오름차순 정렬
		for(int i = 0; i < result.length; i++) {
			if(result[i] != 0) {
				System.out.println(result[i]);
			}
		}
		
	}
	
	static int [] dx = {0, 1, 0, -1}; // 우 하 좌 상
	static int [] dy = {1, 0, -1, 0};
	static public void bfs(int i, int j) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(i);
		queue.offer(j);
		
		// 큐가 빌때까지
		while(!queue.isEmpty()) {
			result[COUNT]++; // 단지 내 건물 수 카운트를 result 배열에 담는다.
			i = queue.poll();
			j = queue.poll();
			
			for(int k = 0; k < 4; k++) {
				int nx = i + dx[k];
				int ny = j + dy[k];
				
				if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
					if(building[nx][ny] == 1 && !visited[nx][ny]) {
						visited[nx][ny] = true; // 방문 표시
						queue.offer(nx);
						queue.offer(ny);
					}
				}
			}
		}
	}
}
