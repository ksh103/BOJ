import java.util.*;

class Solution {
    
    public String[] solution(String[] strings, int n) {
        
        ArrayList<String> list = new ArrayList<>();
        
        for(int i = 0; i < strings.length; i++) {
            list.add(strings[i].substring(n, n + 1) + strings[i]);
        }
        
        Collections.sort(list);
        
        String[] answer = new String[strings.length];
        
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).substring(1);
        }
        
        return answer;
    }
}