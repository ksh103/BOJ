package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 20055번 컨베이어 벨트 위의 로봇 */
public class boj_20055 {

	static int N, K;
	static int[] belt;
	static boolean[] robot;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		belt = new int[2 * N];
		robot = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 2 * N; i++) {
			belt[i] = Integer.parseInt(st.nextToken());
		}
		
		int move = 0;
		while(endCheck()) {
			move++;
			
			beltMove();
			robotMove();
		}
		
		System.out.print(move);
	}
	
	private static void beltMove() {
		
		int temp = belt[2 * N - 1];
		
		// 벨트 이동 (순환)
		for(int i = 2 * N - 1; i > 0; i--) {
			belt[i] = belt[i - 1];
		}
		
		belt[0] = temp;
		
	}
	
	private static void robotMove() {
		// 로봇 이동
		for(int i = N - 1; i > 0; i--) {
			robot[i] = robot[i - 1];
		}
				
		robot[N - 1] = false; // N - 1위치에서 로봇을 내림
		robot[0] = false; // N 위치에서 로봇이 내렸으므로 올리는 위치로 돌아왔을 때 로봇 없음
		
		
		for(int i = N - 1; i > 0; i--) {
			
			// 이동하고 하는 곳에 i번째 컨베이어 벨트에 내구도가 있을 때
			// robot[i] 위치에 로봇이 없을 때
			// robot[i - 1] 위치에 로봇이 존재할 때
			if(belt[i] > 0 && !robot[i] && robot[i - 1]) {
				robot[i - 1] = false; // 로봇 없음
				robot[i] = true; // 로봇 있음
				
				belt[i]--; // 로봇이 지나갈 때 이전 벨트 내구도 1만큼 감소
			}
		}
		
		// 로봇 올리기
		// 올리는 위치에 있는 칸의 내구도가 0이 아니면 로봇 올리기
		// robot[0]에 현재 로봇이 없고 belt[0] 내구도가 0이 아니면 올리기
		if(belt[0] > 0) {
			robot[0] = true; // 로봇 올림
			belt[0]--; // 로봇을 올렸으므로 내구도 감소
		}
	}
	
	private static boolean endCheck() {
		int count = 0;
		
		for(int i = 0; i < 2 * N; i++) {
			// 내구도가 0인 칸의 개수
			if(belt[i] == 0) count++;
			// 내구도 >= K 이면 종료
			else if(count >= K) return false;
		}
		
		return true;
	}
}
