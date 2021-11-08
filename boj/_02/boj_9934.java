package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

/* boj 9934번 완전 이진 트리 */
public class boj_9934 {

	static int K, N;
	static int[] tree;
	static StringBuilder[] res;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		K = Integer.parseInt(br.readLine()); // 깊이
		N = (int) Math.pow(2, K) - 1; // 완전 이진 트리 총 노드 개수
		
		tree = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
		}
		
		res = new StringBuilder[K];
		
		for (int i = 0; i < K; i++) {
			res[i] = new StringBuilder();
		}
		
		solve(0, N-1, 0);
		
		for (int i = 0; i < K; i++) {
			System.out.println(res[i]);
		}
		
	}
	
	static void solve(int start, int end, int depth) {
		if(depth == K) return;
		
		int middle = (start + end) / 2;
		
		res[depth].append(tree[middle] + " ");
		
		solve(start, middle - 1, depth + 1);
		solve(middle + 1, end, depth + 1);
	}

}
