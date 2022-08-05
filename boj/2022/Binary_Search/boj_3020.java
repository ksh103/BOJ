package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* boj 3020번 개똥벌레 */
public class boj_3020 {

	static int N, H;
	static int[] up, down, cave;
	public static void main(String[] args) throws Exception {
	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	      StringTokenizer st = new StringTokenizer(br.readLine());
	      
	      N = Integer.parseInt(st.nextToken()); // 동굴 길이
	      H = Integer.parseInt(st.nextToken()); // 동굴 높이
	      
	      up = new int[N / 2];
	      down = new int[N / 2];
	      
	      cave = new int[H];
	      
	      for(int i = 0; i < N / 2; i++) {
	    	  down[i] = Integer.parseInt(br.readLine());
	    	  up[i] = Integer.parseInt(br.readLine());
	      }
	      
	      Arrays.sort(up);
	      Arrays.sort(down);
	      
	      int min = Integer.MAX_VALUE;
	      int cnt = 0;
	      for(int i = 1; i <= H; i++) {
	    	  
	    	  int upCount = binarySearch(up, 0, N / 2 - 1, i);
	    	  int downCount = binarySearch(down, 0, N / 2 - 1, H - i + 1); 
	    	  
	    	  cave[i - 1] = upCount + downCount;
	    	  
	    	  min = Math.min(min, cave[i - 1]);
	      }
	      
	      for(int i = 0; i < H; i++) {
	    	  if(min == cave[i]) {
	    		  cnt++;
	    	  }
	      }
	      
	      System.out.println(min + " " + cnt);
	}
	
	static int binarySearch(int[] arr, int start, int end, int h) {
		int min = Integer.MAX_VALUE;
		
		while(start <= end) {
			int mid = (start + end) / 2;
			
			if(arr[mid] >= h) {
				min = Math.min(min, mid);
				end = mid - 1;
			}else {
				start = mid + 1;
			}
		}
		return min == Integer.MAX_VALUE ? 0 : (N / 2) - min;
	}
}
