class Solution {
    public int solution(int n) {

        // 3진법 변환
        String n1 = "";
        while(n > 0) {
            n1 = (n % 3) + n1;
            n /= 3;
        }

        // 앞뒤 반전
        String n2 = new StringBuilder(n1).reverse().toString();
        
        // 10진법으로 표현
        int answer = Integer.parseInt(n2, 3);
        
        return answer;
    }
}