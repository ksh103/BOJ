import java.util.*;

class Solution {
    static boolean[] prime = new boolean[3001];
    static int answer;
    public int solution(int[] nums) {
        
        // 에라토스테네스의 체를 사용하여 소수 판별
        Arrays.fill(prime, true);
        
        for(int i = 2; i * i <= 3000; i++) {
            for(int j = i * i; j <= 3000; j+=i) {
                prime[j] = false;
            }
        }
        
        answer = 0;
        Combination(nums, 0, 0, 0);
    
        return answer;
    }

    // 조합을 이용해서 서로 다른 수 3개 골라 더해 소수가 되는 경우 확인
    public void Combination(int[] nums, int idx, int cnt, int sum) {
        if(cnt == 3) {
            if(prime[sum]) {
                answer++;
            }
            return;
        }
        
        for(int i = idx; i < nums.length; i++) {
            Combination(nums, i + 1, cnt + 1, nums[i] + sum);
        }
    }
}