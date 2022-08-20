package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 14620번 꽃길 */
public class boj_14620 {

	static int N, min = Integer.MAX_VALUE;
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		map = new int[N + 1][N + 1];
		visited = new boolean[N + 1][N + 1];
		
		// 씨앗을 (1,1)~(N,N)의 지점 중 한곳에 심을 수 있다. 
		
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0);
		
		System.out.print(min);
	}
	
	static void dfs(int count, int cost) {
		// 3개의 씨앗을 선택했을 때
		if(count == 3) {
			
			min = Math.min(min, cost); // 최소 비용 구하기
			
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				
				if(!checkFlower(i, j)) continue;
				
				visitFlower(i, j, true); // 방문 처리
				dfs(count + 1, cost + sumFlower(i, j));
				visitFlower(i, j, false); // 초기화
			}
		}
	}
	
	// 꽃을 심을 수 있는 지 확인
	private static boolean checkFlower(int x, int y) {
		for(int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(nx < 1 || nx > N || ny < 1 || ny > N || visited[nx][ny]) return false;
		}
		return true;
	}
	
	// 꽃 가중치 계산
	private static int sumFlower(int x, int y) {
		int sum = map[x][y];
		
		for(int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			sum += map[nx][ny];
		}
		return sum;
	}
	
	// 방문 처리
	private static void visitFlower(int x, int y, boolean flag) {
		visited[x][y] = flag;
		
		for(int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			visited[nx][ny] = flag;
		}
	}
}