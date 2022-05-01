package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 9489번 사촌 */
public class boj_9489 {

	static int n, k, target, cnt;
	static int[] node, parent;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			if(n == 0 && k == 0) break;
			
			node = new int[n + 1]; // 숫자 배열 
			parent = new int[n + 1]; // 부모 배열
			
			node[0] = parent[0] = -1;
			cnt = -1;
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				node[i] = Integer.parseInt(st.nextToken());
				
				if(node[i] == k) target = i; // k의 사촌 구하기 위해 k의 인덱스 값 넣기
				if(node[i] != node[i-1] + 1) cnt++; // 숫자가 연속되지 않으면 depth값 + 1
				
				parent[i] = cnt;
			}
			
			int ans = 0;
			for (int i = 1; i <= n; i++) {
				// 부모가 다르면서 두 부모가 형제일 때 사촌
				if(parent[i] != parent[target] && parent[parent[i]] == parent[parent[target]]) ans++;
			}
			System.out.println(ans);
		}
	}
}
