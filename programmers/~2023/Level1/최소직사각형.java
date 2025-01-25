import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int result_w = 0, result_h = 0;
        
        for(int i = 0; i < sizes.length; i++) {
            // 명함이 회전이 가능하다는 조건
            // 가로 길이 : 큰 길이 중에서 가장 큰 길이
            // 세로 길이 : 작은 길이 중에서 가장 큰 길이
            result_w = Math.max(result_w, Math.max(sizes[i][0], sizes[i][1]));
            result_h = Math.max(result_h, Math.min(sizes[i][0], sizes[i][1]));
        }
        
        return result_w * result_h;
    }
}