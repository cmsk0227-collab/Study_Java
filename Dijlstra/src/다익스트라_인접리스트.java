import java.util.*;
import java.io.*;

/**
입력

5 7 1
1 2 2
1 3 4
2 3 1
2 4 7
3 4 3
3 5 5
4 5 1

출력
0
2
3
6
7
 */
public class 다익스트라_인접리스트 {
	
	// Node 클래스: 연결된 정점과 비용을 담는 상자
	static class Node implements Comparable<Node> {
		int vertex;  // 목표 정점 번호
		int cost;    // 해당 정점까지의 비용
		
		// 생성자: 새로운 Node 만들 때 필드 초기화
		Node(int vertex, int cost) {
			this.vertex = vertex;
			this.cost = cost;
		}
		
		// compareTo: 두 Node를 비교 (비용 작은 것부터 꺼냄)
		// return 음수 = this가 더 앞 -> 먼저 나옴
		// return 양수 = o가 더 앞 -> 나중에 나옴
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	
	// 다익스트라
	static final int INF = Integer.MAX_VALUE;  // 무한대 (도달 불가능)
	static ArrayList<Node>[] graph;            // 그래프: 각 정점의 인접 정점 목록
	static int[] dist;                         // 거리: 시작점에서 각 정점까지의 최단거리
	static boolean[] visited;                  // 방문 배열
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 입력
		int V = Integer.parseInt(st.nextToken());  // 정점 수
		int E = Integer.parseInt(st.nextToken());  // 간선 수
		int S = Integer.parseInt(st.nextToken());  // 시작점
		
		// 배열 만들기
		graph = new ArrayList[V + 1];
		dist = new int[V + 1];
		visited = new boolean[V + 1];
		
		// 각 정점별 인접 리스트 초기화
		for(int i = 1; i <= V; i++) {
			graph[i] = new ArrayList<>();
		}
		
		// 모든 거리를 무한대로 초기화
		Arrays.fill(dist, INF);
		
		// 간선 입력
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());  // 출발 정점
			int v = Integer.parseInt(st.nextToken());  // 도착 정점
			int w = Integer.parseInt(st.nextToken());  // 비용
			
			graph[u].add(new Node(v, w));
			graph[v].add(new Node(u, w));  // 무방향 그래프
		}
		
		// 다익스트라 알고리즘 실행
		dijkstra(S);
		
		// 출력
		for(int i = 1; i <= V; i++) {
			if(dist[i] == INF) {
				System.out.println("INF");
			} else {
				System.out.println(dist[i]);
			}
		}
	}
	
	// 다익스트라 함수: 음의 가중치가 없는 경우의 최단거리 찾는 함수
	static void dijkstra(int start) {
		// 우선순위 큐: 비용이 작은 것부터 꺼냄
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		// Step 1: 시작점 설정
		// 시작점에서 시작점의 거리 = 0
		dist[start] = 0;
		pq.offer(new Node(start, 0));
		
		// Step 2: 큐가 비워질 때까지 반복
		while(!pq.isEmpty()) {
			// 우선순위 큐에서 비용이 가장 작은 정점 꺼내기
			Node cur = pq.poll();
			int v = cur.vertex;
			int cost = cur.cost;
			
			// 이미 방문한 정점이면 건너뛰기
			// (우선순위 큐에는 같은 정점이 여러 번 들어갈 수 있음)
			if(visited[v]) continue;
			
			// 현재 큐에 있는 비용이 실제 최단거리보다 크면 건너뛰기
			if(cost > dist[v]) continue;
			
			// 방문 표시
			visited[v] = true;
			
			// Step 3: 현재 정점에서 갈 수 있는 모든 정점 확인
			for(Node next : graph[v]) {
				int nextV = next.vertex;      // 다음 정점 번호
				int nextCost = next.cost;     // v에서 nextV로 가는 비용
				
				// Step 4: 새로운 거리 계산
				// 새 거리 = 현재까지의 거리 + 다음 간선의 비용
				int newDist = dist[v] + nextCost;
				
				// Step 5: 더 짧은 거리이면 업데이트
				if(newDist < dist[nextV]) {
					// 기존 거리보다 새 거리가 더 짧으면 업데이트
					dist[nextV] = newDist;
					pq.offer(new Node(nextV, newDist));
				}
			}
		}
	}
}