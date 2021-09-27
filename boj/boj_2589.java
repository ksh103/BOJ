package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* boj 2589번 보물섬 */
public class boj_2589 {

	static int L, W;
	static char[][] map;
	static int[][] count;
	static boolean[][] visited;
	
	static Queue<Node> queue = new LinkedList<>();
	static ArrayList<Integer> list = new ArrayList<>();
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		map = new char[L][W];
	
		for (int i = 0; i < L; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < L; i++) {
			for (int j = 0; j < W; j++) {
				if(map[i][j] == 'L') {
					bfs(i, j);
				}
			}
		}
		
		int result = Integer.MIN_VALUE;
		for (int i = 0; i < list.size(); i++) {
			result = Math.max(result, list.get(i));
		}
		System.out.println(result);
	}
	
	static void bfs(int x, int y) {
		
		visited = new boolean[L][W];
		count = new int[L][W];
		
		queue.offer(new Node(x, y));
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			
			for (int d = 0; d < 4; d++) {
				int nx = n.x + dx[d];
				int ny = n.y + dy[d];
				
				if(nx < 0 || nx >= L || ny < 0 || ny >= W || map[nx][ny] == 'W' || visited[nx][ny]) continue;
				visited[nx][ny] = true;
				count[nx][ny] = count[n.x][n.y] + 1;
				queue.offer(new Node(nx, ny));
			}
		}
		list.add(FindMax(count));
	}
	
	static int FindMax(int[][] arr) {
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < L; i++) {
			for (int j = 0; j < W; j++) {
				if(max <= arr[i][j]) {
					max = arr[i][j];
				}
			}
		}
		return max;
	}
	
	static class Node{
		int x, y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
