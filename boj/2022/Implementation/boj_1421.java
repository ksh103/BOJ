package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 1421번 나무꾼 이다솜 */
public class boj_1421 {

	static int N, C, W;
	static int[] wood;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 나무의 개수
		C = Integer.parseInt(st.nextToken()); // 나무를 자를 때 드는 비용
		W = Integer.parseInt(st.nextToken()); // 나무 한 단위의 가격
		
		wood = new int[N];
		
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i < N; i++) {
			wood[i] = Integer.parseInt(br.readLine());
			
			max = Math.max(max, wood[i]);
		}
		
		
		long result = 0;
		for(int i = 1; i <= max; i++) {
			
			long sum = 0;
			long cost = 0;
			
			for(int j = 0; j < N; j++) {
				int piece = wood[j] / i; // 나무를 자름.
				int count = (wood[j] % i == 0) ? 1 : 0;
				
				// (자른 나무 개수 * 나무 길이 * 가격) - (자른 횟수 * 나무를 자를 때 드는 비용)
				cost = (piece * i * W) - (piece - count) * C;
				
				if(cost > 0) {
					sum += cost;
				}
			}
			result = Math.max(result, sum);
		}
		System.out.print(result);
	}
}
