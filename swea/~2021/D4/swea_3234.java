package com.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* swea 3234번 양팔 저울 (D4) */
public class swea_3234 {

	static int T, N, cnt;
	static int[] weight, temp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			
			weight = new int[N];
			temp = new int[N];
			cnt = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				weight[i] = Integer.parseInt(st.nextToken());
				temp[i] = i;
			}
			
			while(true) {
				check(0, 0, 0);
				if(!np()) break;
			}
			System.out.println("#" + t + " " + cnt);
		}
	}
	
	static void check(int strIdx, int left, int right) {
		if(strIdx == N) {
			cnt++;
			return;
		}

		int tmp = weight[temp[strIdx]]; 
		
		/* (조건) 오른쪽 위에 올라가 있는 무게의 총합이 왼쪽에 올라가 있는 무게의 총합보다 더 커져서는 안 된다. */
		check(strIdx + 1, tmp + left, right); // 왼쪽은 무조건 추를 올릴 수 있음.
		
		if(right + tmp <= left) { // 오른쪽의 추 무게가 왼쪽의 추 무게보다 작으면
			check(strIdx + 1, left, right + tmp); // 오른쪽 추 올리기
		}
	}
	
	static boolean np() {
		
		// 꼭대기 탐색
		int i = N - 1;
		while(i > 0 && temp[i - 1] >= temp[i]) --i;
		
		if(i == 0) return false;
		
		int j = N - 1;
		while(temp[i - 1] >= temp[j]) --j;
		
		swap(temp, i - 1, j);
		
		int k = N - 1;
		while(i < k) {
			swap(temp, i++, k--);
		}
		
		return true;
	}
	
	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
