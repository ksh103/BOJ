package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* boj 5014번 스타트링크 */
public class boj_5014 {

	static int F, S, G, U, D;
	static int[] visit;
	static Queue<Integer> queue = new LinkedList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		F = Integer.parseInt(st.nextToken()); // 건물 층 수
		S = Integer.parseInt(st.nextToken()); // 현재 층
		G = Integer.parseInt(st.nextToken()); // 스타트링크 사무실 층
		U = Integer.parseInt(st.nextToken()); // 위 
		D = Integer.parseInt(st.nextToken()); // 아래
		
		visit = new int[1000001];
		BFS(S);	
	}
	
	static void BFS(int S) {
		
		queue.offer(S);
		visit[S] = 1; // 0으로 하면 다시 방문 할 때 깊이가 꼬임.
		
		while(!queue.isEmpty()) {
			int loc = queue.poll();
			
			if(G == loc) { // 도착했을 때
				System.out.println(visit[loc] - 1);
				return;
			}

			// 위층으로 올라갈 때
			int up = loc + U;
			if(up <= F && visit[up] == 0) {
				queue.offer(up);
				visit[up] = visit[loc] + 1;
			}
			
			// 아래층으로 내려갈 때
			int down = loc - D;
			if(down > 0 && visit[down] == 0) {
				queue.offer(down);
				visit[down] = visit[loc] + 1;
			}
		}
		
		// 엘리베이터를 사용할 수 없을 때
		System.out.println("use the stairs");
	}

}
