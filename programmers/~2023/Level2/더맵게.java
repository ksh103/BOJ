import java.util.*;

class Solution {
    
    public int solution(int[] scoville, int K) {
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for(int i = 0; i < scoville.length; i++) {
            queue.add(scoville[i]);
        }
        
        int answer = 0;
        while(queue.peek() < K) {
            // 스코빌 지수를 K이상으로 만들 수 없을 경우
            if(queue.size() < 2) {
                answer = -1;
                break;
            }
            
            int n1 = queue.poll(); // 가장 맵지 않은 음식의 스코빌 지수
            int n2 = queue.poll(); // 두 번째로 맵지 않은 음식의 스코빌 지수
            
            int scov = n1 + (n2 * 2); // 섞은 음식의 스코빌 지수
        
            queue.offer(scov);
            answer++;
        }
        return answer;
    }
}