package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* boj 15886번 내 선물을 받아줘 2 */
public class boj_15886 {

	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		String input = br.readLine();
		
		int cnt = 0;
		for(int i = 0; i < N - 1; i++) {
			if(input.charAt(i) == 'E' && input.charAt(i + 1) == 'W') {
				cnt++;
			}
		}
		System.out.print(cnt);
	}
}
