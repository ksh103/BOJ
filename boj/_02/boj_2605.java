package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/* boj 2605번 줄 세우기 */
public class boj_2605 {

	static int N;
	static List<Integer> list = new LinkedList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if(num == 0) list.add(i);
			list.add(i - num, i);
			
		}
		for (int i = 1; i <= N; i++) {
			System.out.print(list.get(i) + " ");
		}
	}
}
