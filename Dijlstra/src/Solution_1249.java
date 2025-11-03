import java.io.*;
import java.util.*;

public class Solution_1249 {
//	다익스트라
//	Node 클래스
//	목적 : 다익스트라 탐색을 위한 여러 가지의 값을 입력받기 위해 Node 클래스를 만듬
	public static class Node implements Comparable<Node>{
		int r, c, cost;//좌표(r,c),시작점에서 현재 칸까지의 복구 시간
		
//		생성자 :  node 객체를 만들 때 필드 초기화
		Node(int r, int c, int cost){
			this.r = r;
			this.c = c;
			this.cost = cost;
		}
		
//		우선순위 큐가 오름차순 정렬할 때 아래의 메서드 호출
//		return >0 : this 뒤, return <0 this 앞
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
//	이동 - 사방탐색
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
//	전역변수
	static int INF = Integer.MAX_VALUE; //무한대값 
	static int N;//변의 길이
	static int[][] map;//각 칸의 복구 시간 저장
	static int[][] dist;//시작점(0,0)에서부터 각 칸까지의 최단 복구 시간
	static boolean[][] visited;//방문배열
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());//테케 수
//		테케수만큼 반복
		for(int t = 1; t <= T ; t++) {
//			NxN 격자 크기 입력
			N = Integer.parseInt(br.readLine());
//			배열 초기화
			map = new int[N][N];
			dist = new int[N][N];
			visited = new boolean[N][N];
			
			//map 입력
//			공백구분없이 제공되니 문자열로 받은 뒤에 나누기
			for(int r = 0 ; r < N ; r++) {
				String str = br.readLine();
				for(int c = 0; c < N ; c++) {
					map[r][c] = str.charAt(c) - '0';//문자를 숫자로 변환
					dist[r][c] = INF;//모든 거리를 무한대로 초기화
					}
			}
//			다익스트라 알고리즘
//			(0,0)에서 시작해서 모든 칸까지의 최단 복구 시간 계산
//			모든 값 가중치가 음의 가중치가 아니므로 다익스트라 사용가능
			daijkstra(0,0);
			
//			결과 저장: (N-1, N-1)까지의 최단 복구 시간
			sb.append("#").append(t).append(" ").append(dist[N-1][N-1]).append("\n");
			
		}
//		모든 테케 결과 출력
		System.out.println(sb);
	}
	
	
	// sr, sc: 시작점의 행, 열
	// 목적: (sr, sc)에서 모든 칸까지의 최단 복구 시간 구하기
	private static void daijkstra(int sr, int sc) {
//		우선순위 큐 생성 - 탐색 순서만 결정
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		//시작점 설정
		//시작점까지의 거리 = 시작점 칸의 복구 시간
		dist[sr][sc] = map[sr][sc];
//		탐색하기 위해서 우선순위 큐에 추가(탐색 시작
		pq.offer(new Node(sr, sc, dist[sr][sc]));
		
		//탐색
//		pq가 빌때까지 반복
		while(!pq.isEmpty()) {
//			복구 시간이 가자아 작은 칸 꺼내기.
			Node cur = pq.poll();
			
			int r = cur.r;//현재 칸의 r 좌표
			int c = cur.c;//현재 칸의 c 좌표
			int cost = cur.cost;//현재 칸의 복구 시간
			
			if(visited[r][c]) continue;//방문한 적 있는 칸이면 건너뛰기
			visited[r][c] = true;//아니라면 방문할꺼니까 방문 표시
			
//			4방탐색
			for(int i = 0 ; i < 4; i++) {
				int nr = r + dr[i];//다음 r 좌표
				int nc = c + dc[i];//다음 c 좌표
				
//				맵 외부에 있으면 건너뛰기
				if(nr < 0 || nr >= N || nc < 0|| nc >=N) continue;
//				방문했다면 건너뛰기
				if(visited[nr][nc]) continue;
				
//				시작점부터 현재 지점까지의 복구 시간 = 이전까지의 복구 시간 + 현재 지점의 복구시간
				int newDist = dist[r][c] + map[nr][nc];
				
//				조회 중인 칸의 기존 복구시간 > 새로 구한 복구 시간, 최소시간 갱신
//				어차피 최소 복구시간을 구하는 것이 목적이니 작은 경우 조회
				if(dist[nr][nc] > newDist) {
					dist[nr][nc] = newDist;
					pq.offer(new Node(nr, nc, newDist));//방문해야하니 큐에 삽입
				}
				
			}
		}
		
	}
}
