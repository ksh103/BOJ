package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 16507번 어두운 건 무서워 */
public class boj_16507 {

	static int R, C, Q;
	static int[][] picture;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken()); // 사진 크기
		C = Integer.parseInt(st.nextToken()); // 사진 크기
		Q = Integer.parseInt(st.nextToken()); // 사진 일부분의 밝기 평균을 알아볼 개수
		
		picture = new int[R + 1][C + 1]; // 사진
		
		for(int i = 1; i <= R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= C; j++) {
				picture[i][j] = Integer.parseInt(st.nextToken()) + picture[i][j - 1] + picture[i - 1][j] - picture[i - 1][j - 1]; 
			}
		}
		
		long sum = 0;
		long area = 1;
		
		for(int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			
			int r1 = Integer.parseInt(st.nextToken());
			int c1 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			
			sum = picture[r2][c2] - (picture[r1 - 1][c2] + picture[r2][c1 - 1] - picture[r1 - 1][c1 - 1]);
			area = (r2 - r1 + 1) * (c2 - c1 + 1);
			
			System.out.println(sum / area);
		}
		
		
	}
}
