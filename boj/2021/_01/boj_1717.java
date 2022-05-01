package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 1717번 집합의 표현 */
public class boj_1717 {

	static int n, m;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n+1];
		
		for (int i = 1; i <= n; i++) {
			arr[i] = i;
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int op = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			
			// 0이면 a가 포함되어 있는 집합과 b가 포함되어 있는 집합을 합친다는 의미
			if(op == 0) {
				union(a,b);
				
			}
			// 1이면 a와 b가 같은 집합에 포함되어 있는지를 확인하는 연산
			else if(op == 1) {
				if(check(a) == check(b)) System.out.println("YES");
				else System.out.println("NO");
			}
		}
	}
	
	static int check(int number) {
		if(number == arr[number]) {
			return number;
		}
		return arr[number] = check(arr[number]);
	}
	
	static void union(int a, int b) {
		a = check(a);
		b = check(b);
		
		if(a > b) arr[a] = b;
		else arr[b] = a;
		
	}
}
