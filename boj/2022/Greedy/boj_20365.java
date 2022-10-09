package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* boj 20365번 블로그2 */
public class boj_20365 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 색을 칠해야하는 문제의 수
        String str = br.readLine();

        int blueCount = 0, redCount = 0;

        if(str.charAt(0) == 'B') blueCount = 1;
        else redCount = 1;

        char c = str.charAt(0);

        for(int i = 1; i < str.length(); i++) {
            // 이전 문자와 현재 문자 비교했을 때 같으면 카운트 하지 않음
            if(str.charAt(i) == c) continue;
            else {
                if(str.charAt(i) == 'B') {
                    // 현재 문자열이 B이면 blue 카운트
                    blueCount++;
                } else {
                    // 현재 문자열이 R이면 red 카운트
                    redCount++;
                }
            }
            // 갱신
            c = str.charAt(i);
        }

        // blue, red 중 가장 적게 칠한 색 + 전체 칠하기 1
        int answer = Math.min(blueCount, redCount) + 1;

        System.out.println(answer);
    }
}
