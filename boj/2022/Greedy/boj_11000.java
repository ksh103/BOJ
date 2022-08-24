package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/* boj 11000번 강의실 배정 */
public class boj_11000 {

	static int N;
	static Lecture[] lectures;
	
	static PriorityQueue<Integer> queue = new PriorityQueue<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		lectures = new Lecture[N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken()); // 강의 시작 시간
			int end = Integer.parseInt(st.nextToken()); // 강의 종료 시간
			
			lectures[i] = new Lecture(start, end);
		}
		
		Arrays.sort(lectures, new Comparator<Lecture>() {

			@Override
			public int compare(Lecture o1, Lecture o2) {
				// 강의 시작 기준으로 정렬
				return o1.start == o2.start ? o1.end - o2.end : o1.start - o2.start;
			}
		});
		
		queue.offer(lectures[0].end);
		
		for(int i = 1; i < N; i++) {
			// 강의 종료 시간이 다음 강의 시작 시간보다 일찍 끝나거나 같게 끝날 때
			if(queue.peek() <= lectures[i].start) queue.poll();
	
			queue.offer(lectures[i].end);
		}
		
		System.out.print(queue.size());
	}
	
	static class Lecture {
		int start, end;
		
		public Lecture(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
}
