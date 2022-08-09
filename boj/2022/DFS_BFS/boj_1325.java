package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/* boj 1325번 효율적인 해킹 */
public class boj_1325 {

	static int N, M;
	static int[] count;
	static boolean[] visited;
	static ArrayList<Integer>[] list;
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N + 1];
		count = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
		}
		
		for(int i = 1; i <= N; i++) {
			visited = new boolean[N + 1];
			DFS(i);
		}
		
		int max = Integer.MIN_VALUE;
		for(int i = 1; i <= N; i++) {
			max = max < count[i] ? count[i] : max; 
		}
		
		for(int i = 1; i <= N; i++) {
			if(count[i] == max) {
				sb.append(i).append(" ");
			}
		}
		System.out.print(sb);
	}
	
	static void DFS(int x) {
		visited[x] = true;
		
		for(int next : list[x]) {
			if(visited[next]) continue;
			count[next]++;
			DFS(next);
		}
	}
}
