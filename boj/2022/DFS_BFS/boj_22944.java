package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* boj 22944번 죽음의 비 */
public class boj_22944 {

    static int N, H, D, result = -1;
    static char[][] map;
    static int[][] isCheck;
    static boolean[][] visited;

    static Queue<Node> queue = new LinkedList<>();

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 가로, 세로 길이
        H = Integer.parseInt(st.nextToken()); // 현재 체력
        D = Integer.parseInt(st.nextToken()); // 우산의 내구도

        map = new char[N][N];
        isCheck = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j);

                if(map[i][j] == 'S') {
                    isCheck[i][j] = H;
                    queue.offer(new Node(i, j, H, 0, 0));
                }
            }
        }

        Solve();
    }

    private static void Solve() {

        while(!queue.isEmpty()) {
            Node n = queue.poll();

            // 이동한 곳이 안전지대라면 종료
            if(map[n.x][n.y] == 'E') {
                System.out.print(n.count + 1);
                return;
            }

            for(int d = 0; d < 4; d++) {
                int nx = n.x + dx[d];
                int ny = n.y + dy[d];

                if(nx > 0 || nx <= N || ny > 0 || ny <= N) continue;

                // 우산을 얻었을 때
                if(map[nx][ny] == 'U') n.d = D;

                // 우산을 들고 있을 때 우산 내구도 감소
                if(n.d > 0) n.d--;
                // 우산을 들고 있지 않을 때 체력 감소
                else n.h--;

                // 체력이 0이면 죽음
                if(n.h == 0) continue;

                if(isCheck[nx][ny] < n.h) {
                    isCheck[nx][ny] = n.h;
                    queue.offer(new Node(nx, ny, n.h, n.d, n.count + 1));
                }

            }
        }
        System.out.println(-1);

    }

    static class Node {
        int x, y, h, d, count;

        Node(int x, int y, int h, int d, int count) {
            this.x = x;
            this.y = y;
            this.h = h;
            this.d = d;
            this.count = count;
        }
    }
}
