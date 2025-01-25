import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        
        int[] answer = new int[photo.length]; 
        Map<String, Integer> map = new HashMap<>();
        
        // 1. 그리워하는 사람, 그리움 점수 저장
        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }
        
        for (int i = 0; i < photo.length; i++) {
            for (int j = 0; j < photo[i].length; j++) {
                // 2. 그리워하는 사람에 사진 속 인물이 포함되어 있을 때
                if (map.containsKey(photo[i][j])) {
                    // 3. 그리움 점수 더함
                    answer[i] += map.get(photo[i][j]); 
                }
            }
        }
        return answer;
    }
}