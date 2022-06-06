package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* boj 13335번 트럭 */
public class boj_13335 {

	static Queue<Integer> truck = new LinkedList<>();
	static Queue<Integer> bridge = new LinkedList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 트럭 개수
		int w = Integer.parseInt(st.nextToken()); // 다리 길이
		int l = Integer.parseInt(st.nextToken()); // 다리 최대하중
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			truck.offer(Integer.parseInt(st.nextToken()));
		}
		
		// w개 만큼 bridge에 0을 채운다.
		for(int i = 0; i < w; i++) {
			bridge.offer(0);
		}
		
		int time = 0, currentL = 0;
		
		while(!bridge.isEmpty()) {
			currentL -= bridge.poll(); // 지나간 트럭의 무게는 뺀다.
			
			if(!truck.isEmpty()) {
				
				// 지나가는 트럭의 무게가 최대하중(l)을 넘지 않을 때
				if(currentL + truck.peek() <= l) {
					int truckL = truck.poll(); // 현재 지나가는 트럭
					
					currentL += truckL;
					bridge.offer(truckL);
				}
				// 최대하중(l)을 넘으면 0으로 채운다.
				else bridge.offer(0);
			}
			time++;
		}
		
		System.out.println(time);
	}
}
