package com.swea;

import java.util.Scanner;

/* swea 1247번 최적 경로 */
public class swea_1247 {

	static int  N, min;
	static Point office;
	static Point house;
	static Point[] map;
	static boolean[] visited;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		
		for(int t = 1; t <= testCase; t++) {
			
			N = sc.nextInt();
			
			office = new Point(sc.nextInt(), sc.nextInt());
			house = new Point(sc.nextInt(), sc.nextInt());
			
			map = new Point[N];
			visited = new boolean[N];
			min = Integer.MAX_VALUE;
			
			for(int i = 0; i < N; i++) {
				map[i] = new Point(sc.nextInt(), sc.nextInt());
			}
			
			Perm(office, 0, 0); // 회사 위치부터 시작
			System.out.println("#" + t + " " + min);
		}
	}
	
	static void Perm (Point p, int strIdx, int sum) {
		// 거리 합이 최소 거리 값보다 크면 return
		if(sum >= min) {
			return;
		}

		if(strIdx == N) {
			sum += Math.abs(p.x - house.x) + Math.abs(p.y - house.y);
			min = Math.min(min, sum); // 고객 집 - 본인 집
			return;
		}

		 for (int i = 0; i < N; i++) {
			 if (!visited[i]) {
				 visited[i] = true; // 방문 표시
	             int dist = Math.abs(p.x - map[i].x) + Math.abs(p.y - map[i].y); // 회사 - 고객 집
	             Perm(map[i],strIdx + 1, sum + dist); // 현재 위치 , 인덱스, 거리값 합
	             visited[i] = false;
			 }
		 }
	}
	
	static class Point {
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
