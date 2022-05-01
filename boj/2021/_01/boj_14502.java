package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* boj 14502번 연구소 */
public class boj_14502 {

	static int N, M;
	static int safe = Integer.MIN_VALUE;
	static int[][] map, temp;
	static Queue<Node> queue = new LinkedList<Node>();
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 가로
		
		map = new int[N][M];
		temp = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		makewall(0);
		System.out.println(safe);
	}
	
	// 벽 세우기
	static void makewall(int cnt) {
		// 벽은 3개 세울 수 있다.
		if(cnt == 3) {
			bfs();
			safe = Math.max(safe, safeZone());
			return;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					makewall(cnt+1);
					map[i][j] = 0;
				}
			}
		}
	}
	
	// 바이러스 퍼뜨리기
	static void bfs() {
		// 배열 복사
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[i][j] = map[i][j];
				if(temp[i][j] == 2) {
					queue.add(new Node(i, j));
				}
			}
		}
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
			
				if(nx < 0 || nx >= N || ny < 0 || ny >= M || temp[nx][ny] != 0) continue;
				
				temp[nx][ny] = 2;
				queue.add(new Node(nx, ny));
			}
		}
	}
	
	// 안전지대
	static int safeZone() {
		
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(temp[i][j] == 0) {
					cnt++;
				}
			}
		}
		
		return cnt;
	}
	
	static class Node{
		int x, y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}

// 벽 3개를 세우는 모든 경우 조합
// 위 모든 경우 벽 3개가 고정된 상태 virus가 퍼진다.