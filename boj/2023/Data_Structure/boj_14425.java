package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/* boj 14425번 문자열 집합 */
public class boj_14425 {

	static int N, M;
	static Map<String, Integer> map = new HashMap<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			map.put(input, 1);
		}
		
		int count = 0;
		for (int i = 0; i < M; i++) {
			String check = br.readLine();
			
			if (map.containsKey(check)) {
				count++;
			}
		}
		
		System.out.println(count);
		
	}
}
