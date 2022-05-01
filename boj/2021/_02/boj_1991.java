package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/* boj 1991번 트리 순회 */
public class boj_1991 {

	static int N;
	static Map<String, List<String>> map = new HashMap<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			List<String> list = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String node = st.nextToken();
			String left = st.nextToken();
			String right = st.nextToken();
			
			list.add(left);
			list.add(right);
			
			map.put(node, list);
		}
		
		preorder("A");
		System.out.println();
		inorder("A");
		System.out.println();
		postorder("A");
		System.out.println();
	}
	
	static void preorder(String v) {
		if(v.equals(".")) return;
		
		System.out.print(v);
		preorder(map.get(v).get(0));
		preorder(map.get(v).get(1));
	}
	
	static void inorder(String v) {
		if(v.equals(".")) return;
		
		inorder(map.get(v).get(0));
		System.out.print(v);
		inorder(map.get(v).get(1));
	}
	static void postorder(String v) {
		if(v.equals(".")) return;
		
		postorder(map.get(v).get(0));
		postorder(map.get(v).get(1));
		System.out.print(v);
	}
}
