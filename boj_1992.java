package com.boj;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* boj 1992번 쿼드 트리 */
public class boj_1992 {

	static int N;
	static int[][] map;
	static StringBuilder sb = new StringBuilder();
 	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			String input = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = input.charAt(j) -'0';
			}
		}
		tree(0, 0, N);
		System.out.println(sb);
	}
 	
 	static void tree(int x, int y, int size) {
 		int tmp = map[x][y]; 
 		for(int i = 0; i< size; i++) {
 			for(int j = 0; j < size; j++) {
 				int dx = x + i;
 				int dy = y + j;
 				// 값이 tmp에 저장된 값과 같지 않을까 분할 정복
 				if(map[dx][dy] != tmp) {
 					sb.append("(");
 					tree(x, y, size/2); // 1구역
 					tree(x, y+size/2, size/2); // 2구역
 					tree(x+size/2, y, size/2); // 3구역
 					tree(x+size/2, y+size/2, size/2); // 4구역
 					sb.append(")");
 					return;
 				}
 			}
 		}
 		sb.append(tmp);

 	}
}
