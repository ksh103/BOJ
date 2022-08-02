package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/* boj 13023번 ABCDE */
public class boj_13023 {

	static int N, M;
	static boolean check = false;
	static boolean[] flag;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		flag = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			list.add(new ArrayList<>());
		}
	
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		for(int i = 0; i < N; i++) {
			solve(i, 0);
			
			if(check) break;
		}
		
		if(check) System.out.println("1");
		else System.out.println("0");
	}
	
	static void solve(int start, int cnt) {
		// 기저조건
		if(cnt == 4) {
			check = true;
			return;
		}
		
		flag[start] = true;
		
		for(int i = 0; i < list.get(start).size(); i++) {
			int next = list.get(start).get(i);
			
			if(!flag[next]) {
				solve(next, cnt + 1);
			}
		}
		
		flag[start] = false;
	}
}
