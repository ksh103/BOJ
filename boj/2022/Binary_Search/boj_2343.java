package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 2343번 기타 레슨 */
public class boj_2343 {

	static int N, M;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		int start = 0, end = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
			start = Math.max(start, arr[i]); // 블루레이 중 가장 큰 값
			end += arr[i]; // 블루레이 크기 합
		}
		
		
		System.out.println(binarySearch(arr, start, end));
	}
	
	static int binarySearch(int[] arr, int start, int end) {
		
		while(start <= end) {
			int mid = (start + end) / 2;
			int sum = 0, count = 0;
			
			for(int i = 0; i < N; i++) {
				
				// 블루레이 크기를 더했을 때, mid 값 보다 클 때
				if(sum + arr[i] > mid) {
					count++; // 블루레이 개수
					sum = 0; // sum 초기화
				}
				sum += arr[i];
			}
			
			if(sum != 0) count++;
			
			// 블루레이 개수가 M개보다 적거나 같을 때
			if(count <= M) end = mid - 1;
			else start = mid + 1;
		}
		
		return start;
	}
}
