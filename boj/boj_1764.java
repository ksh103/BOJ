package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

/* boj 1764번 듣보잡 */
public class boj_1764 {

	static int N, M;
	static HashMap<String, Integer> map = new HashMap<>();
	static ArrayList<String> list = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			map.put(br.readLine(), 1);
		}
		
		for (int i = 0; i < M; i++) {
			String input = br.readLine();
			
			if(map.containsKey(input)) {
				list.add(input);
			}
		}
		
		Collections.sort(list);
		System.out.println(list.size());
		for (String tmp : list) {
			System.out.println(tmp);
		}
	}
}
