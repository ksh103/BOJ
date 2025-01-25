class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        
        int index = 0;
        for(int i = 0; i < number.length() - k; i++) {
            
            int max = 0; // 최댓값 초기화
            for(int j = index; j <= i + k; j++) {
                if(max < number.charAt(j) - '0') {
                    max = number.charAt(j) - '0'; // 최댓값 갱신
                    index = j + 1; // 인덱스 갱신
                }
            }
            sb.append(max);
        }
        return sb.toString();
    }
}