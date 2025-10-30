package 기초;

import java.util.*;

public class BFS_인접행렬 {
    
    static int[][] graph;
    static boolean[] visited;
    static int n;
    
    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        
        queue.offer(start);
        visited[start] = true;
        
        while(!queue.isEmpty()) {
            int now = queue.poll();
            System.out.print(now + " ");
            
            // 모든 노드 확인
            for(int i = 1; i <= n; i++) {
                // 연결되어 있고 방문하지 않았으면
                if(graph[now][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        n = 5;
        graph = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        
        // 간선 추가
        graph[1][2] = graph[2][1] = 1;
        graph[1][3] = graph[3][1] = 1;
        graph[2][4] = graph[4][2] = 1;
        graph[2][5] = graph[5][2] = 1;
        
        bfs(1);
    }
}