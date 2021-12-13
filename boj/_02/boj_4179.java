package com.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* boj 4179번 불! */
public class boj_4179 {

    static int R, C, time;
    static char[][] map;
    static boolean[][] visit;
    static Queue<Point> jQueue = new LinkedList<>();
    static Queue<Point> fQueue = new LinkedList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visit = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = input.charAt(j);

                if(map[i][j] == 'J') jQueue.offer(new Point(i, j)); // 지훈이 위치
                if(map[i][j] == 'F') fQueue.offer(new Point(i, j)); // 불 위치
            }
        }
        solve();
        System.out.println(time == 0 ? "IMPOSSIBLE" : time);
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static void solve(){

    	int cnt = 0;
        
    	// 지훈이가 탈출할 때 까지
        while(!jQueue.isEmpty()){
        	// 지훈이 위치
            int jSize = jQueue.size();
            
            while(jSize-->0) {
            	Point p = jQueue.poll();
            	
            	if(map[p.x][p.y] == 'F') continue; // 지나가는 곳이 불이면 못 감.

            	for (int d = 0; d < 4; d++) {
                    int nx = p.x + dx[d];
                    int ny = p.y + dy[d];
                    
                    // 미로의 가장자리에 접한 공간에서 탈출
                    if(nx < 0 || nx >= R || ny < 0 || ny >= C) {
                    	time = cnt + 1;
                    	return;
                    }
                    if(map[nx][ny] == 'F' || map[nx][ny] == '#' || visit[nx][ny]) continue;
                    
                    visit[nx][ny] = true;
                    jQueue.offer(new Point(nx, ny));
                }
            }
            // 불 위치
            int fSize = fQueue.size();
            
            while(fSize-->0) {
            	Point p = fQueue.poll();
            	
            	for (int d = 0; d < 4; d++) {
                    int nx = p.x + dx[d];
                    int ny = p.y + dy[d];

                    if(nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny] == '#' || map[nx][ny] == 'F') continue;
                    
                    fQueue.offer(new Point(nx, ny));
                    map[nx][ny] = 'F';
                }
            }
            cnt++;
        }
    }
    static class Point{
        int x, y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}