import java.util.*;

class Solution {
    
    static final int SIZE = 5;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[SIZE];
        
        for(int p = 0; p < SIZE; p++) {
            answer[p] = check(places[p]); 
        }
        
        return answer;
    }
    
    private int check(String[] board) {
        for(int i = 0; i < SIZE; i++) {
            for(int j = 0; j < SIZE; j++) {
                if(board[i].charAt(j) == 'P') {
                    if(!bfs(board, i, j)) return 0;
                }
            }
        }
        return 1;
    }
    
    private boolean bfs(String[] board, int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[SIZE][SIZE];
        
        queue.offer(new Node(x, y));
        visited[x][y] = true;
        
        while(!queue.isEmpty()) {
            Node n = queue.poll();
            
            for(int d = 0; d < 4; d++){
                int nx = n.x + dx[d];
                int ny = n.y + dy[d];
                
                int distance = Math.abs(nx - x) + Math.abs(ny - y); // 맨해튼 거리
                
                // 범위를 벗어났거나 이미 방문했을 경우
                if(nx < 0 || nx >= SIZE || ny < 0 || ny >= SIZE || visited[nx][ny]) continue;
                
                // 범위 내에 파티션이 존재하거나 맨해튼 거리가 2를 초과할 경우
                if(board[nx].charAt(ny) == 'X' || distance > 2) continue;

                visited[nx][ny] = true;
                
                // 범위 내에 응시자가 존재하면 false
                if(board[nx].charAt(ny) == 'P') return false; 
                // 범위 내에 빈테이블이 존재
                else if(board[nx].charAt(ny) == 'O') queue.offer(new Node(nx, ny));
            }
        }
        return true;
    }
    
    
    public class Node {
        int x, y;
        
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}