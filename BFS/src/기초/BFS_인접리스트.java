package 기초;
import java.util.*;

public class BFS_인접리스트 {
	 static ArrayList<Integer>[] graph;
	    static boolean[] visited;
	    
	    // BFS 구현
	    static void bfs(int start) {
	        Queue<Integer> queue = new LinkedList<>();
	        
	        queue.offer(start);      // 시작 노드 삽입
	        visited[start] = true;   // 방문 처리
	        
	        while(!queue.isEmpty()) {
	            int now = queue.poll();  // 큐에서 꺼내기
	            System.out.print(now + " ");  // 방문 순서 출력
	            
	            // 인접한 노드 탐색
	            for(int next : graph[now]) {
	                if(!visited[next]) {
	                    queue.offer(next);
	                    visited[next] = true;
	                }
	            }
	        }
	    }
	    
	    public static void main(String[] args) {
	        int n = 5; // 노드 개수
	        
	        // 그래프 초기화
	        graph = new ArrayList[n + 1];
	        for(int i = 1; i <= n; i++) {
	            graph[i] = new ArrayList<>();
	        }
	        visited = new boolean[n + 1];
	        
	        // 간선 추가 (양방향)
	        graph[1].add(2);
	        graph[1].add(3);
	        graph[2].add(1);
	        graph[2].add(4);
	        graph[2].add(5);
	        graph[3].add(1);
	        graph[4].add(2);
	        graph[5].add(2);
	        
	        // BFS 실행
	        bfs(1);  // 1번 노드부터 시작
	    }
}
