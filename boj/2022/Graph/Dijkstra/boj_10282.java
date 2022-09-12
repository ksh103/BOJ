package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/* boj 10282번 해킹 */
public class boj_10282 {

   static int T, INF = 10_000 * 1_000;
   static int[] graph;
   static boolean[] visited;
   
   static ArrayList<Node>[] list;
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;
      
      T = Integer.parseInt(br.readLine()); // 테스트케이스
      
      while(T --> 0) {
         st = new StringTokenizer(br.readLine());
         
         int n = Integer.parseInt(st.nextToken()); // 컴퓨터 개수
         int d = Integer.parseInt(st.nextToken()); // 의존성 개수
         int c = Integer.parseInt(st.nextToken()); // 해킹당한 컴퓨터의 번호
         
         list = new ArrayList[n + 1];
         graph = new int[n + 1];
         visited = new boolean[n + 1];
         
         Arrays.fill(graph, INF);
         
         for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
         }

         
         for(int i = 0; i < d; i++) {
            st = new StringTokenizer(br.readLine());
            
            // 컴퓨터 a가 컴퓨터 b를 의존
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            
            // 컴퓨터 b가 감염되면 s초 후 컴퓨터 a도 감염됨
            list[b].add(new Node(a, s));
         }
         
         solve(c);
         
         int count = 0, answer = 0;
         for(int a : graph) {
  		   if(a != INF) {
  			   count++;
  			   answer = Math.max(answer, a);
  		   }
         }
         
         System.out.println(count + " " + answer);
      
      }
   }
   
	private static void solve(int c) {
	   PriorityQueue<Node> pq = new PriorityQueue<>();
	   
	   pq.offer(new Node(c, 0));
	   graph[c] = 0;
	   
	   while(!pq.isEmpty()) {
		   Node n = pq.poll();
		   
		   for(Node next : list[n.a]) {

			   if(graph[next.a] > graph[n.a] + next.s) {
				   graph[next.a] = graph[n.a] + next.s;
				   pq.offer(new Node(next.a, graph[next.a]));
			   }
		   }
	   }
   }
   
   
   static class Node implements Comparable<Node>{
      int a, s;
      
      public Node(int a, int s) {
         this.a = a;
         this.s = s;
      }

	@Override
	public int compareTo(Node o) {
		return Integer.compare(this.s, o.s);
	}
   }
}