import java.util.*;

class Solution {
    
    static int SIZE;
    static String[][] tickets;
    static boolean[]visited;
    
    static List<String> list = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        
        this.tickets = tickets;
        this.SIZE = tickets.length;
        
        visited = new boolean[SIZE];
        
        // 알파벳 오름차순 정렬
        Arrays.sort(tickets, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                // 출발 공항이 같을 때
                if(o1[0].equals(o2[0])) {
                    // 도착 공항 오름차순
                    return o1[1].compareTo(o2[1]);
                }
                // 오름차순
                return o1[0].compareTo(o2[0]);
            }
        });
        
        for(int i = 0; i < SIZE; i++) {
            String start = tickets[i][0];
            String end = tickets[i][1];
            
            // 출발은 항상 "ICN" 공항에서 한다.
            if(start.equals("ICN")) {
                visited[i] = true;
                // 1번 테케 기준
                // 0 , "ICN  ", "JFK"
                solve(0, start + " ", end);
                visited[i] = false;
            }  
        }
        
        return list.get(0).split(" ");
    }
    
    private static void solve(int count, String str, String end) {
        if(count == SIZE - 1) {
            str += end;
            list.add(str);
            return;
        }
        
        for(int i = 0; i < SIZE; i++) {
            // 현재 도착 공항과 다음 출발 공항이 같을 때
            if(!visited[i] && end.equals(tickets[i][0])) {
                visited[i] = true;
                solve(count + 1, str + tickets[i][0] + " ", tickets[i][1]);
                visited[i] = false;
            }
        }
    }
}