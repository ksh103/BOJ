package com.boj;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 3109번 빵집 */
public class boj_3109 {

	static int R, C, cnt = 0;
	static char[][] pipe;
 	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		pipe = new char[R][C];
		
		for(int i = 0; i < R; i++) {
			String input = br.readLine();
			for(int j = 0; j < C; j++) {
				pipe[i][j] = input.charAt(j);
			}
		}
		
		for(int r = 0; r < R; r++) {
			DFS(r, 0);
		}
		System.out.println(cnt);
	}
	
	static int[] dy = {-1, 0, 1};
//	static int[] dx = {1, 1, 1};
	static boolean DFS(int y, int x) {
		// 끝에 왔을 때 파이프가 설치 됐으니 카운트
		// C - 1 성공판단
		if(x == C - 1) {
			cnt++;
			return true;
		}
		
		for(int i = 0; i < 3; i++) {
			int ny = y + dy[i];
			int nx = x + 1;
			
			if(ny < 0 || nx < 0 || ny >= R || nx >= C || pipe[ny][nx] != '.') continue;

			// 지나간 길은 0으로 표시
			pipe[ny][nx] = '0';
			// true면 올바른 방향으로 왔으므로 더 이상 탐색 x
			if(DFS(ny, nx)) return true;
		}
		return false;
	}
}
