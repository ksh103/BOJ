package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 2422번 한윤정이 이탈리아에 가서 아이스크림을 사먹는데 */
public class boj_2422 {

	static int N, M, result;
	static int[] icecream = new int[3];
	static boolean[][] graph;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new boolean[N][N];
		visited = new boolean[N];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			
			graph[a][b] = graph[b][a] = true;
		}
		
		result = 0;
		solve(0, 0);
		
		System.out.print(result);

	}
	
	private static void solve(int index, int count) {
		if(count == 3) {
			if(check()) {
				result++;
			}
			
			return;
		}
		
		for(int i = index; i < N; i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			icecream[count] = i;
			
			solve(i + 1, count + 1);
			
			visited[i] = false;
			
		}
	}
	
	private static boolean check() {
		for(int i = 0; i < 3; i++) {
			for(int j = i; j < 3; j++) {
				if(graph[icecream[i]][icecream[j]]) return false;
			}
		}
		return true;
	}

}
