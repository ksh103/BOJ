class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        
        for(int i = 1; i < arr.length; i++) {
            answer = lcm(answer, arr[i]);
        }
        return answer;
    }
    
    // 최대공약수
    static public int gcd(int a, int b) {  
        while(b != 0) {
            int c = a % b;
            a = b;
            b = c;
        }
        return a;
    }
    
    // 최소공배수
    static public int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
}