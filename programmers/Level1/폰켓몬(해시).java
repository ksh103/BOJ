import java.util.*;

class Solution {
    
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        
        int size = nums.length / 2; // 폰켓몬 N마리 중 N/2마리 선택
        int answer = 0;
        
        for(int n : nums) {
            set.add(n);
        }
        
        if(set.size() > size) answer = size;
        else answer = set.size();
        
        return answer;
    }
}