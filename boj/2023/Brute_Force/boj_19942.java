package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/* boj 19942번 다이어트 */
public class boj_19942 {

    static int N, min;
    static int[] minCost, result;
    static int[][] arr;
    static boolean[] visited;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // 식재료의 개수

        minCost = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++) {
            minCost[i] = Integer.parseInt(st.nextToken());
        }

        arr = new int[N][5];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N];
        min = Integer.MAX_VALUE;
        solve(0, 0, 0, 0, 0, 0);

        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {

            System.out.println(min);

            for (int i = 0; i < result.length; i++) {
                System.out.print((result[i] + 1) + " ");
            }
        }
    }

    private static void solve(int index, int mp, int mf, int ms, int mv, int cost) {

        // 단백질, 지방, 탄수화물, 비타민
        // 최소 영양성분 확인
        if (minCost[0] <= mp && minCost[1] <= mf && minCost[2] <= ms && minCost[3] <= mv) {
            // 최소 비용 갱신
            if (min > cost) {
                min = cost;

                result = list.stream().mapToInt(Integer::intValue).toArray();
            }
            return;
        }

        for (int i = index; i < N; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            list.add(i);

            solve(i + 1, mp + arr[i][0], mf + arr[i][1], ms + arr[i][2], mv + arr[i][3], cost + arr[i][4]);

            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
