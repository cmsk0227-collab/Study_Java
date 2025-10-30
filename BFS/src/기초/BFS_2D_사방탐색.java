package 기초;

import java.util.*;

public class BFS_2D_사방탐색 {
    
    static int[] dx = {-1, 1, 0, 0};  // 상하좌우
    static int[] dy = {0, 0, -1, 1};
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    
    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int cx = now[0];
            int cy = now[1];
            
            System.out.println("방문: (" + cx + ", " + cy + ")");
            
            // 4방향 탐색
            for(int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                // 범위 체크
                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                // 방문 체크
                if(visited[nx][ny]) continue;
                // 벽 체크 (1만 이동 가능)
                if(map[nx][ny] == 0) continue;
                
                queue.offer(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }
    }
    
    public static void main(String[] args) {
        N = 5;
        M = 5;
        map = new int[][] {
            {1, 1, 0, 1, 1},
            {1, 1, 0, 1, 1},
            {0, 0, 1, 0, 0},
            {1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1}
        };
        visited = new boolean[N][M];
        
        bfs(0, 0);  // (0,0)부터 시작
    }
}