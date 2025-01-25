class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        int count = 0;
        int zeroCount = 0;
        
        while(!s.equals("1")) {
            int tempCount = 0;
            
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '0') {
                    tempCount++; // 제거할 0의 개수 카운트
                }
            }
            
            s = Integer.toBinaryString(s.length() - tempCount); // 0 제거 후 길이 이진 변환
            count++; // 변환 횟수 카운트
            zeroCount += tempCount; // 0 개수 카운트
            
        }
        
        answer[0] = count;
        answer[1] = zeroCount;
        
        return answer;
    }
}