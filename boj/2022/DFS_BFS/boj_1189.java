package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* boj 1189번 컴백홈 */
public class boj_1189 {

    static int R, C, K, result = 0;
    static char[][] map;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken()); // 가로
        C = Integer.parseInt(st.nextToken()); // 세로
        K = Integer.parseInt(st.nextToken()); // 거리

        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        visited[R - 1][0] = true;
        Solve(R - 1, 0, 1);

        System.out.println(result);

    }

    private static void Solve(int x, int y, int count) {

        if (count > K) {
            return;
        }

        if (count == K && x == 0 && y == C - 1) {
            result++;
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || nx >= R || ny < 0 || ny >= C || visited[nx][ny] || map[nx][ny] == 'T') continue;

            visited[nx][ny] = true;
            Solve(nx, ny, count + 1);
            visited[nx][ny] = false;
        }
    }
}
