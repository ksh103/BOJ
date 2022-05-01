package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* boj 1697번 숨바꼭질 */
public class boj_1697 {

	static int N, K;
	static int[] check;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		check = new int[100001];
		
		if(N == K) {
			System.out.println(0);
		}else {
			BFS(N);
		}
	}
	
	static void BFS(int N) {
		Queue<Integer> queue = new LinkedList<>();
		
		queue.offer(N);
		check[N] = 1;
		
		while(!queue.isEmpty()) {
			int loc = queue.poll();
			
			for(int i = 0; i < 3; i++) {
				int next;
				// x-1
				if(i == 0) {
					next = loc - 1;
				}else if(i == 1) { // x+1
					next = loc + 1;
				}else { // 2*x
					next = 2 * loc;
				}
				
				// 동생 위치에 도착했을 때
				if(next == K) {
					System.out.println(check[loc]);
					return;
				}
				
				// 범위 체크
				if(next < 0 || next >= check.length || check[next] != 0) continue;
				
				queue.offer(next);
				check[next] = check[loc] + 1;
				
			}
		}
	}
}
