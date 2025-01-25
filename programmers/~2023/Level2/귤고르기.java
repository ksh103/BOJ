import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int t : tangerine) {
            if(!map.containsKey(t)) {
                map.put(t, 1);
            } else {
                map.put(t, map.get(t) + 1);
            }
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        
        for (int key : map.keySet()) {
            pq.offer(map.get(key));
        }
        
        while(!pq.isEmpty() && k > 0) {
            k -= pq.poll();
            answer++;
        }
        
        return answer;
    }
}