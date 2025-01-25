import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        int[] xArr = new int[10];
        int[] yArr = new int[10];
           
        numberCheck(xArr, X);
        numberCheck(yArr, Y);
        
        StringBuilder sb = new StringBuilder();
        for(int i = 9; i >= 0; i--) {
            while(xArr[i] >= 1 && yArr[i] >= 1) {
                sb.append(i);
                xArr[i]--;
                yArr[i]--;
            }
        }
        
        if(sb.length() == 0) return "-1";
        else if(sb.charAt(0) == '0') return "0";
        
        return sb.toString();
    }
    
    private static void numberCheck(int[] arr, String str) {
        for(int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - '0']++;
        }
    }
}