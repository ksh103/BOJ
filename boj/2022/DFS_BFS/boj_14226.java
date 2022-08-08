package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/* boj 14226번 이모티콘 */
public class boj_14226 {

	static int S;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		S = Integer.parseInt(br.readLine());
		
		solve();
		
	}
	
	static void solve() {
		Queue<Point> queue = new LinkedList<>();
		boolean[][] flag = new boolean[2001][2001];
		
		queue.offer(new Point(1, 0, 0));
		flag[1][0] = true;
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			// 이모티콘 S개를 만들었으면 종료
			if(p.screen == S) {
				System.out.println(p.count);
				break;
			}
			
			// 1. 화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장
			if(!flag[p.screen][p.screen]) {
				queue.offer(new Point(p.screen, p.screen, p.count + 1));
				flag[p.screen][p.screen] = true;
			}
			
			// 2. 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기
			if(!flag[p.screen + p.clipboard][p.clipboard] && p.screen + p.clipboard < 1001 && p.clipboard > 0) {
				queue.offer(new Point(p.screen + p.clipboard, p.clipboard, p.count + 1));
				flag[p.screen + p.clipboard][p.clipboard] = true;
			}
			
			// 3. 화면에 있는 이모티콘 중 하나를 삭제
			if(!flag[p.screen - 1][p.clipboard] && p.screen - 1 > 0 ) {
				queue.offer(new Point(p.screen - 1, p.clipboard, p.count + 1));
				flag[p.screen - 1][p.clipboard] = true;
			}
		}
	}

	static class Point {
		int screen, clipboard, count;
		
		public Point(int screen, int clipboard, int count) {
			this.screen = screen;
			this.clipboard = clipboard;
			this.count = count;
		}
	}
}
