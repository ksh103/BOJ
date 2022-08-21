package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 16987번 계란으로 계란치기 */
public class boj_16987 {

	static int N, result;
	static int[][] egg;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		egg = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			egg[i][0] = Integer.parseInt(st.nextToken()); // 계란 내구도
			egg[i][1] = Integer.parseInt(st.nextToken()); // 계란 무게
		}
		
		result = 0;
		dfs(0, 0);
		
		System.out.print(result);
	}
	
	private static void dfs(int index, int count) {
		
		if(index == N) {
			// 깰 수 있는 계란의 최대 개수 구하기
			result = Math.max(result, count);

			return;
		}
		
		// 현재 계란의 내구도가 0일 경우와 마지막 계란이 깨지지 않았을 경우를 위해 조건 처리
		if(egg[index][0] <= 0 || count == N - 1) {
			dfs(index + 1, count);
			return;
		}
		
		int crackEggCount = count; // 깨진 계란 개수 백트래킹
		for(int i = 0; i < N; i++) {
			
			// 같은 계란은 칠 수 없음.
			// 계란 내구도가 0이하면 계란을 칠 수 없으므로 다음 계란 확인
			if(i == index || egg[i][0] <= 0) continue;
			
			
			egg[i][0] -= egg[index][1]; // 현재 계란 내구도 - 다음 계란 무게
			egg[index][0] -= egg[i][1]; // 다음 계란 내구도 - 현재 계란 무게

			
			// 계란 내구도 확인 
			// 내구도가 0이하이면 깨진 계란이므로 개수 카운트
			crackEggCount = egg[i][0] <= 0 ? crackEggCount + 1 : crackEggCount;
			crackEggCount = egg[index][0] <= 0 ? crackEggCount + 1 : crackEggCount;
			
			
			dfs(index + 1, crackEggCount); // 재귀 호출
			
			egg[i][0] += egg[index][1]; // 초기화
			egg[index][0] += egg[i][1]; // 초기화
			crackEggCount = count; // 초기화
		}
	}
}
