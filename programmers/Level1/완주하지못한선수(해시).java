import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        for(int i = 0; i < participant.length; i++) {
            if(map.containsKey(participant[i])) {
                int count = map.get(participant[i]);
                count++;
                map.put(participant[i], count);
            }else{
                map.put(participant[i], 1);
            }
        }
        
        for(int i = 0; i < completion.length; i++) {
            if(map.containsKey(completion[i])) {
                int count = map.get(completion[i]);
                count--;
                map.put(completion[i], count);
            }
        }
        
        for(String key : map.keySet()) {
            if(map.get(key) != 0) {
                answer = key;
            }
        }
        return answer;
    }
}