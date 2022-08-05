package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 1103번 게임 */
public class boj_1103 {

	static int N, M, result;
	static char[][] map;
	static int[][] memo;
	static boolean[][] visited;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static boolean flag = true;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		memo = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			map[i]= st.nextToken().toCharArray();
		}
		
		visited[0][0] = true;
		solve(0, 0, 1);
		
		if(!flag) {
			System.out.print("-1");
		}else {
			System.out.print(result);
		}
	}
	
	static void solve(int x, int y, int cnt) {
		
		// 메모이제이션
		memo[x][y] = cnt;
		
		result = Math.max(result, cnt);
		
		int move = map[x][y] - '0';
		for(int d = 0; d < 4; d++) {
			int nx = x + dx[d] * move;
			int ny = y + dy[d] * move;
			
			// 범위를 벗어나고 구멍에 빠질 때
			if(nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == 'H') continue;
			
			if(cnt < memo[nx][ny]) continue;
			
			// 사이클 발생하면 -1
			if(visited[nx][ny]) {
				flag = false;
				return;
			}
			
			visited[nx][ny] = true;
			solve(nx, ny, cnt + 1);
			visited[nx][ny] = false;
		}
	}

}
