import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        Map<String, Integer> map = new HashMap<>();
        String[] answer = players;
        
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }
        
        for (String call : callings) {
            // 1. 현재 불린 선수 순위
            int ranking = map.get(call); 
            
            // 2. 현재 불린 선수보다 먼저 달리고 있는 선수
            String prePlayer = answer[ranking - 1];
            
            // 3. 순위 변경
            answer[ranking - 1] = call;
            answer[ranking] = prePlayer;
            
            map.put(call, ranking - 1);
            map.put(prePlayer, ranking);
            
        }
        
        return answer;
    }
}