package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/* boj 1744번 수묶기 */
public class boj_1744 {

	static int N, result, n1, n2;
	static int[] num;

	// 우선 순위 큐를 사용하여 양수를 내림차순으로 정렬
	static Queue<Integer> pos = new PriorityQueue<>(Collections.reverseOrder()); //양수 
    static Queue<Integer> neg = new PriorityQueue<>(); // 음수
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		num = new int[N];
		
		for(int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(br.readLine());
			  if(num[i] > 0) pos.offer(num[i]); // 양수
			  else neg.offer(num[i]); // 음수
        }

        result = 0;
        
        // 양수 계산
        while (!pos.isEmpty()) {
            n1 = pos.poll(); // 기본적으로 양수 하나 먼저 poll

            // 양수 큐가 비어있지 않으면 그 다음수를 poll하고 두 수를 연산
            if(!pos.isEmpty()) {
                n2 = pos.poll();

                int mul = n1 * n2;
                int sum = n1 + n2;

                // 곱한 값이 클 때 곱한 값을 반환
                result += mul > sum ? mul : sum;
                continue;
            }
            // 값이 하나일 때 더함
            result += n1;
        }
        
        // 음수 계산
        while (!neg.isEmpty()) {
            n1 = neg.poll(); // 음수 하나 먼저 poll

            // 음수 큐가 비어있지 않으면 그 다음수를 poll하고 두 수를 연산
            if(!neg.isEmpty()) {
                n2 = neg.poll();
                
                // 음수는 곱한 값이 최댓값
                result += (n1 * n2);
                continue;
            }
            // 값이 하나일 때 더함
            result += n1;
        }
        System.out.println(result);
    }
}