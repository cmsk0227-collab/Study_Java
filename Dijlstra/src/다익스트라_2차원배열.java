import java.util.*;
import java.io.*;

/**
입력

3 3
5 4 3
2 6 1
1 2 3

출력
13
 */
public class 다익스트라_2차원배열 {
//	Node 클래스 : 칸의 위치와 비용을 담는 상자
	static class Node implements Comparable<Node>{
		int r, c, cost; //행, 열, 비용
		
//		생성자 : 새로운 node만들 때 필드 초기화
		Node(int r, int c, int cost) {
			this.r = r;
			this.c = c;
			this.cost = cost;
		}
		
//		compareTo : 두 Node 비교.(작은 것부토 꺼냄)
//		return 음수 = this가 더 앞. -> 먼저 나옴
//		return 음수 = this가 더 뒤. -> 나중에 나옴
		
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	

//	4방 탐색
	 static int[] dr = {-1, 1, 0, 0};  // 위, 아래, 왼쪽, 오른쪽 (행 변화)
	 static int[] dc = {0, 0, -1, 1};  // 위, 아래, 왼쪽, 오른쪽 (열 변화)x
	 
//	 다익스트라
	 static final int INF = Integer.MAX_VALUE; //무한데(도달 불가능), 최솟값이 항상 갱신
	 static int R, C; //2차원 배열의 행의 개수, 열의 개수
	 static int[][] map;//각 칸마다의 가중치(시간, 비용) 입력
	 static int[][] dist;// 거리 : 시작점에서 각 칸까지의 최단거리
	 static boolean[][] visited; //방문베열
	 
	 public static void main(String[] args) throws IOException{
		 BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 
		 //입력
		 R = Integer.parseInt(st.nextToken());
		 C = Integer.parseInt(st.nextToken());
		 
//		 배열 만들기
		 map = new int[R][C];
		 dist = new int[R][C];
		 visited = new boolean[R][C];
		 
//		 모든 거리를 무한대로 초기화
		 for(int r = 0; r < R; r++) {
	            for(int c = 0; c < C; c++) {
	                dist[r][c] = INF;
	            }
	        }
		 
		 
//		2차원 배열의 각 칸마다 데이터 입력받기
		for(int r = 0; r < R ; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < C ; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
//		 다익스트라 알고리즘 실행
//		(0,0)칸에서 시작해서 모든 칸의 최단거리 찾기
		dijkstra(0,0);
		
//		출력
//		우측 하단 (R-1, C-1)까지의 최단거리 출력
		System.out.println(dist[R-1][C-1]); 
		 
		 
	}
	 
	 //다익스트라 함수 : 음의 가중치가 없는 경우의 최단거리 찾는 함수
	 private static void dijkstra(int sr, int sc) {
		//우선순위 큐 : 비용이 작은 것부터 꺼냄
		 PriorityQueue<Node> pq = new PriorityQueue<>();
		 
//		 step1 : 시작점 결졍
//		 시작점에서 시작점의 거리 = 시작점 칸의 비용(시작점을 밟으므로)
		 dist[sr][sc] = map[sr][sc];
		 pq.offer(new Node(sr, sc, dist[sr][sc]));
		 
//		 step2 : 큐가 비워질 때까지 반복
//		 int step = 0 //몇단계인지 표시(디버깅용)
		 
		 while(!pq.isEmpty()) {
			 //step++;
			 
//			 우선순위 큐에서 비용이 가장 작은 칸 꺼내기
			 Node cur = pq.poll();
			 int r= cur.r;
			 int c= cur.c;
			 int cost = cur.cost;
			 
//			 이미 방문한 칸이면 건너뛰기
			 if(visited[r][c]) continue;
//			 방문 표시
			 visited[r][c] = true;
			 
//			 현재 칸에 인접한 4방향 칸 확인
			 for(int i = 0; i < 4 ; i++) {
				 int nr = r + dr[i]; //다음칸의 행
				 int nc = c + dc[i]; //다음칸의 열
				 
				 //맵에서 벗어나면 건너뛰기
				 if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
				 if(visited[nr][nc]) continue;
				 
//				  새로운 거리 계산
//				 새 거리 = 현재까지의 거리 +다음 칸의 비용
				 int newDist = dist[r][c] + map[nr][nc];
				 
//				 더 짧은 거리이면 업데이트
				 if(newDist < dist[nr][nc]) {
//					 기존 거리보다 새 거리가 더 짧으면 업데이트
					 dist[nr][nc] = newDist;
					 pq.offer(new Node(nr, nc, newDist));
				 }
			 }
		}
	}
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
