import java.io.*;
import java.util.*;
/*
 *
 * 메모리 : 77888KB
 * 시간 : 364ms
 * 
 * 문제: 체스판에서 나이트가 시작점에서 도착점까지 가는 최소 이동 횟수를 구하기
 * 풀이 방법: BFS (너비 우선 탐색)
 * 
 * 풀이 아이디어
 * 
 * 1. 4방향, 8방향 탐색의 의미
 *    - 4방향(상하좌우) 또는 8방향(대각선 포함) 탐색은 각 칸에서 이동할 수 있는 방향을 정의한 것
 *    - 나이트처럼 L자형으로 이동하는 경우도 마찬가지로 dx, dy 배열로 정의 가능
 *    - dx, dy 배열의 값을 조정하면 한 번에 여러 칸을 이동하는 방식도 구현 가능
 *    - 예: 나이트는 한 번에 (±1, ±2) 또는 (±2, ±1)로 이동
 * 
 * 2. 반복문 제어
 *    - return : 메서드 전체를 종료하고 즉시 함수 빠져나옴 (모든 테케 중단)
 *    - break : 현재 반복문(for, while)만 종료하고 다음 테케로 진행
 *    - 테케가 여러 개일 때는 break를 사용해야 다음 테케를 처리할 수 있음
 * 
 * 3. BFS에서 거리 계산 방식
 *    - 현재 칸의 거리 = 이전 칸의 거리 + 1
 *    - 공식: dist[nr][nc] = dist[r][c] + 1
 *    - 이유: BFS는 너비 탐색이므로 같은 깊이(레벨)의 노드들은 같은 거리를 가짐
 *    - BFS는 큐를 사용해 레벨별로 처리하므로 먼저 방문한 노드가 더 가까운 거리를 보장
 *    - visited 체크와 동시에 dist를 업데이트하는 것이 중요!
 * 
 * 4. 방문 체크의 중요성
 *    - 방문한 칸을 visited 배열로 표시해야 중복 방문을 방지
 *    - 이미 방문한 칸을 다시 큐에 넣으면 무한 루프 위험
 *    - 방문 체크는 큐에 추가할 때 바로 처리하는 것이 효율적 (큐 크기 최소화)
 * 
 * 5. BFS 알고리즘의 특성
 *    - 가중치가 1인 그래프에서 최단 경로를 찾을 수 있음
 *    - DFS와 달리 BFS는 먼저 도착한 노드가 최단 경로를 보장함
 *    - 시간복잡도: O(V + E) (V: 정점 수, E: 간선 수)
 *    - 이 문제에서는 O(n²) (n×n 체스판의 모든 칸을 최악의 경우 방문)
 * 
 * 6. 알고리즘 동작 과정
 *    - 시작점을 큐에 넣고 방문 표시
 *    - 큐에서 꺼낸 칸의 8가지 이동 가능한 위치 확인
 *    - 범위 내에 있고 미방문 칸이면 큐에 추가
 *    - 도착점에 도달하면 dist 값 출력
 */
 
public class Main_7562 {
//	// 나이트의 8가지 이동 방향 (L자 모양)
	static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] dy = {-1,-2, -2, -1, 1, 2, 2, 1};
	
//	bfs
	static int n;
	static int[][] dist;
	static boolean[][] visited;
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());//테스트 케이스 수
		for(int t = 0; t  < T ; t++) {
//			입력
			n = Integer.parseInt(br.readLine());//체스판 크기
			visited = new boolean[n][n];//방문배열 초기화
			dist = new int[n][n];//거리 배열 초기화(자동으로 0으로 초기화)
			
//			시작점 입력
			st = new StringTokenizer(br.readLine());
			int sr = Integer.parseInt(st.nextToken()); //시작점 행 좌표
			int sc = Integer.parseInt(st.nextToken()); //시작점 열 좌표
			
//			도착점 입력
			st = new StringTokenizer(br.readLine());
			int fr = Integer.parseInt(st.nextToken());//도착점 행 좌표
			int fc = Integer.parseInt(st.nextToken());//도착점 열 좌표
			
			
//			로직-bfs
//			선입선출 성질을 이용해 같은 레벨 순으로 탐색하게 하는 자료구조인 큐 생성
			Queue<int[]> q = new LinkedList<>();
//			시작점에 큐 추가
			q.offer(new int[] {sr, sc});
//			중복방문을 막기위해
			visited[sr][sc] = true;// 시작점 방문 표시
			
//			큐가 다 빌떄까지 탐색
			while(!q.isEmpty()) {
//				현재 탐색 중인 노드
				int[] cur = q.poll();
				int r = cur[0];//현 탐색노드의 r좌표
				int c = cur[1];//현 탐색노드의 c좌표
				
//				목표지점에 도달한다면 거리를 춫력 후 종료
				if(r == fr && c == fc) {
					System.out.println(dist[r][c]);
					//return; return 구문 전체를 종료시킴
//					다음 테케를 실행하기 위해서 break 사용
					break; // 현재 테케 종료 후 다음 테케로 (return이 아닌 break 사용!)
				}
				
//				나이트 이동가능 칸 모두 조회
				for(int i = 0; i < 8 ; i++) {
					//다음에 방문할 칸의 r,c 좌표
					int nr = r + dx[i]; // 다음 칸의 행 좌표
					int nc = c + dy[i]; // 다음 칸의 열 좌표
					
//					체스판에서 벗어나면 건너뛰기
					if(nr < 0 || nr >= n || nc <0 || nc >= n) continue;
//					이미 방문했다면 건너뛰기
					if(visited[nr][nc]) continue; 
					
//					맵 내 에있고 방문한 적 없다면 큐에 삽입
					q.offer(new int[]{nr, nc});
					visited[nr][nc] = true;//방문표시
					//shortCut ++;
//					이렇게 하면 방문하는 모든 노드가 카운팅.
//					현제 우리는 실제 이동거리(깊이)를 저장해야하므로 각 칸에 이동 거리 저장
//					이전거리 + 1
					dist[nr][nc] = dist[r][c] + 1;
				}
			}
			
	
		}
		
	}
}
