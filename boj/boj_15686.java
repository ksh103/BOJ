package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/* boj 15686번 치킨 배달 */
public class boj_15686 {

	static int N, M, result = Integer.MAX_VALUE;
	static int[][] map;
	
	static ArrayList<Node> house = new ArrayList<>();
	static ArrayList<Node> chicken = new ArrayList<>();
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					house.add(new Node(i, j));
				}
				if(map[i][j] == 2) {
					chicken.add(new Node(i, j));
				}
			}
		}
		
		for(int i = 1; i <= M; i++) {
			Comb(0, i, new Node[i]);
		}
		System.out.println(result);
	}
	
	static void Comb(int strIdx, int cnt, Node[] node) {
		if(cnt == 0) {
			Distance(node);
			return;
		}
		
		if(strIdx == chicken.size()) return;
		
		for(int i = strIdx; i < chicken.size(); i++) {
			node[cnt-1] = chicken.get(i);
			Comb(i+1, cnt-1, node);
		}
	}
	
	static void Distance(Node[] node) {
		int[] distance = new int[house.size()];
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		for (int i = 0; i < node.length; i++) {
			for (int j = 0; j < house.size(); j++) {
				int temp = Math.abs(node[i].x - house.get(j).x) + Math.abs(node[i].y - house.get(j).y);
				distance[j] = Math.min(distance[j], temp);
			}
		}
		int sum = 0;
		for (int d : distance) {
			sum += d;
		}
		result = Math.min(result, sum);
	}
	
	static class Node{
		int x, y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
