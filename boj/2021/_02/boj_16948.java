package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* boj 16948번 데스 나이트 */
public class boj_16948 {

    static int N, r1, c1, r2, c2, cnt = 0;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());
       
        if(solve(r1, c1, r2, c2)) System.out.println(cnt);
        else System.out.println(-1);
    } 

    static int[] dx = {-2, -2, 0, 0, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -1, 1};
    static boolean solve(int r1, int c1, int r2, int c2) {
        
        Queue<Point> queue = new LinkedList<Point>();
        visited = new boolean[N][N];

        queue.offer(new Point(r1, c1, 0));
        visited[r1][c1] = true;

        while(!queue.isEmpty()){

            Point p = queue.poll();

            if(p.r == r2 && p.c == c2){
                cnt = p.d;
                return true;
            }

            for (int d = 0; d < 6; d++) {
                int nr = p.r + dx[d];
                int nc = p.c + dy[d];
            
                if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]) continue;

                visited[nr][nc] = true;
                queue.offer(new Point(nr, nc, p.d + 1));
            }
        }
        return false;
    }

    static class Point{
        int r, c, d;
        public Point(int r, int c, int d){
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }
}
