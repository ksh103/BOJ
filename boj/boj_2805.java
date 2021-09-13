package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* boj 2805번 나무 자르기 */
public class boj_2805 {

	static int N, M;
	static long[] tree;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		tree = new long[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			tree[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(tree);
		binarySearch(tree);
	}

	static void binarySearch(long[] tree) {
		
		long start = 1;
		long end = tree[N-1];
		
		long result = 0;
		
		while(start <= end) {
			long mid = (start + end) / 2;
			
			if(check(mid, tree)) {
				result = Math.max(result, mid);
				start = mid + 1;
			}else {
				end = mid - 1;
			}
			
		}
		System.out.println(result);
	}
	
	static boolean check(long mid, long[] tree) {
		long cnt = 0;
		for (int i = 0; i < N; i++) {
			if(tree[i] >= mid) {
				cnt += (tree[i] - mid);
			}
		}
		return cnt >= M;
	}
}
