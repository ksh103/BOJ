package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_14248 {

	static int N, S, count;
	static int[] map;
	static boolean[] visited;
	static Queue<Integer> queue = new LinkedList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N + 1];
		visited = new boolean[N + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}

		S = Integer.parseInt(br.readLine());
		
		count = 1;
		System.out.print(Solve(S));
		
	}
	
	static int Solve(int index) {
		
		queue.offer(index);
		visited[index] = true;
		
		while(!queue.isEmpty()) {
			int nowIdx = queue.poll();
			int amount = map[nowIdx];
			
			int next = 0;
			
			// 오른쪽
			next = nowIdx + amount;
			if(next <= N && !visited[next]) {
				queue.offer(next);
				visited[next] = true;
				count++;
			}
			
			// 왼쪽
			next = nowIdx - amount;
			if(next > 0 && !visited[next]) {
				queue.offer(next);
				visited[next] = true;
				count++;
			}
		}
		return count;
	}
}
