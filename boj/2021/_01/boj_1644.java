package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* boj 1644번 소수의 연속합 */
public class boj_1644 {

    static int N, cnt;
    static boolean[] primes = new boolean[4000001];
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

       prime();

       N = Integer.parseInt(br.readLine());

       cnt = 0;
       solution();
       System.out.println(cnt);

    }
    static void solution() {
        int start = 0, end = 0, sum = 0;
        while(true){
            if(sum < N){
                if(end == list.size()) break;
                sum += list.get(end++);
            }else sum -= list.get(start++);

            if(sum == N) cnt++;
        }
    }

    // 소수 구하기 (에라스토테네스의 체)
    static void prime() {

        // 1. 0과 1은 소수가 아니므로 false
        primes[0] = primes[1] = false;

        // 2. 0,1 제외 모든 수를 true로 한다.
        for (int i = 2; i <= 4000000; i++) {
            primes[i] = true;
        }

        // 소수가 아니면 false
        for (int i = 2; i*i <= 4000000; i++) {
            for (int j = i*i; j <= 4000000; j+=i) {
                primes[j] = false;
            }
        }

        // 소수이면 list에 담는다.
        for (int i = 2; i <= 4000000; i++) {
            if(primes[i]){
                list.add(i);
            }
        }
    }
}
