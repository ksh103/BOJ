package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

/* boj 10546번 배부른 마라토너 */
public class boj_10546 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Integer> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine()); // 참가자

        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            map.put(input, map.getOrDefault(input, 1) + 1);
        }

        for (int i = 0; i < N - 1; i++) {
            String input = br.readLine();

            map.put(input, map.get(input) - 1);
        }

        for (String key : map.keySet()) {
            if (map.get(key) == 1) {
                System.out.println(key);
            }
        }
    }
}
