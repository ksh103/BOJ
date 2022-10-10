package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* boj 11508번 2+1 세일 */
public class boj_11508 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 유제품 수

        Integer[] products = new Integer[N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            products[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(products, (x, y) -> y - x); // 내림차순 정렬

        int sum = 0;
        for(int i = 0; i < N; i++) {
            // 인덱스 값을 나눴을 때 나머지가 2인 인덱스만 담지 않으면 됨.
            if(i % 3 == 2) continue;

            sum += products[i];
        }

        System.out.println(sum);
    }
}
