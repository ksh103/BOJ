import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        
        int successTime = 0, endTime = 0; // 공격 시간, 공격 종료 시간
        int hp = health; // 체력 저장
        
        Map<Integer, Integer> map = new HashMap<>();
        
        // 공격 시간, 피해량 저장
        for (int[] attack : attacks) {
            map.put(attack[0], attack[1]);
            endTime = attack[0];
        }
        
        int attackTime = 1; // 순차적인 공격 시간
        while (attackTime <= endTime) {
            // 몬스터 공격 차례일 때
            if (map.containsKey(attackTime)) {
                hp -= map.get(attackTime); // 체력 감소
                successTime = 0; // 연속 성공 초기화
            } else {
                successTime++;  // 연속 성공
                hp += bandage[1]; // 초당 회복
                
                // 시전 시간일 때
                if (successTime == bandage[0]) {
                    hp += bandage[2]; // 추가 회복
                    successTime = 0; // 연속 성공 초기화
                } 
                
                // 최대 체력을 넘길 수 없으므로 초기화
                if (hp > health) {
                    hp = health;
                }
            }
            attackTime++;
            
            // 중간에 체력이 0이하 될 경우 끝냄
            if (hp <= 0) {
                break;
            }
        }
        
        answer = hp <= 0 ? -1 : hp;
    
        return answer;
    }
}