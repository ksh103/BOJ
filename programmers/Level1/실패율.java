import java.util.*;

class Solution {
    
    static ArrayList<Double> list = new ArrayList<>();
    public int[] solution(int N, int[] stages) {
        
        int[] answer = new int[N];
        int[] stage = new int[N + 2];
        double[] fail = new double[N + 1];
        
        // 스테이지에 도달했으나 아직 클리어하지 못한 플레이어 수 담기
        for(int i : stages) {
            stage[i]++;
        }
        
        double step = stages.length;
        
        for(int i = 1; i <= N; i++) {
            // divide by zero 처리
            if(stage[i] == 0 || step == 0) fail[i] = 0;
            else {
                // 실패율 계산
                fail[i] = stage[i] / step;
                step -= stage[i];
            }
            list.add(fail[i]);
        }
        
        Collections.sort(list, Collections.reverseOrder()); // 내림차순
        
        for(int i = 0; i < list.size(); i++) {
            for(int j = 1; j <= N; j++) {
                // fail 배열에 담긴 실패율과 list에 담긴 실패율이 같을 때
                if(list.get(i) == fail[j]) {
                    answer[i] = j; // answer 배열에 인덱스를 담는다.
                    fail[j] = -1; // 이미 탐색 한 건 -1 처리
                    break;
                }
            }
        }
        return answer;
    }
}