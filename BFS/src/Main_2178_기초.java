import java.util.*;
import java.io.*;

/**
 * @주의점
 * 1.BFS 길찾기는 항상 최단경로. 
 * 왜냐, BFS는 큐를 사용해 가까운 순서대로 방문함. 시작점과 거리가 1인 애들 모두 방문 후 2인 애들 방문. 거리가 2인 애들을 다 방문하면 거리가 3인 애들 방문을 한다.
 * 고로, BFS로 목표지점을 발견한다면 그 거리는 최단거리이다. 
 * 2. visited는 큐에 넣을 때 바로 true로! (poll할 때 하면 중복 삽입)
 * 3.dx = 행, dy = 열
 * 
 * @실수
 * 1. x,y 좌표와 r,c 배열 위치 혼동
 *
 */
/*
 * 메모리 :  14728KB 
 * 시간  : 112ms
 * 풀이아이디어
 * 1. (1,1)에서 시작해 BFS로 탐색
 * 2. 큐에 {r, c, 거리} 저장
 * 3. (R,C) 도착 시 거리 반환 (최단 거리 보장)
 * 4. visited로 중복 방문 방지
 */

public class Main_2178_기초 {
//	4방 탐색 - 상하좌우
	static int[] dx = {-1,1,0,0};//행의 변화량
	static int[] dy = { 0,0,-1,1};//열의 변화량
	
//	bfs
	static int R, C, min;//행,  열, 최단거리
	static boolean[][] visited;//중복방지를 위한 방문배열
	static int[][] graph;//길을 표기하는 자료구조
	
	public static void main(String[] args) throws IOException {
//		입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());//행
		C = Integer.parseInt(st.nextToken());//열
		visited = new boolean[R+1][C+1];//중복방문배열. 1~n번까지라 한 칸 확장
		
//		그래프 입력
		graph = new int[R+1][C+1];// 1~n번까지라 한 칸 확장
		for(int r = 0; r < R; r++) {
			String line = br.readLine();
			for(int c = 0 ; c < C ; c++) {
				graph[r+1][c+1] = line.charAt(c) - '0';
			}
		}
//		로직
		min = 0;//0,0 ~ n,m 최단거리
		bfs(1,1);
//		출력
		System.out.println(min);
		
	}
	/**
	 * @param r : 현재 칸의 y좌표
	 * @param c : 현재 칸의 x 좌표
	 */
	private static void bfs(int r, int c){
//		큐 생성. 순서대로(깊이 순으로) 방문하기위해 만드는 자료구조
		Queue<int[]> q = new LinkedList<>();
//		시작점 입력
		q.offer(new int[] {r,c,1});//행, 열, 길이
//		값을 큐에 담았으므로 방문으로 상태 변경
		visited[r][c] =true;
		
//		q가 다 빌 때까지 반복 = 순서대로 끝까지 방문한다
		while(!q.isEmpty()) {
			int[] cur = q.poll(); //[현재 칸의 x좌표, 현재 칸의 y좌표, 현재 지점까지 경로의 길이]
			int curR = cur[0];//현재 칸의 r
			int curC= cur[1];//현재 칸의 c
			int curDist = cur[2];//현재 지점까지의 경로의 길이
			
//			(r,c) 목표지점까지 도달하면 거리 반환.
//			bfs니까 최단거리 보장
			if(curR == R && curC == C) {
				min = curDist;
				return;
			}
			
//			탐색
			for(int i = 0; i < 4 ; i++) {
				int nr = curR + dy[i];//다음 탐색 칸의  r좌표
				int nc = curC + dx[i];//다음 탐색칸의 c 좌표
				
				
				if(nr < 1 || nr > R||nc < 1 || nc >  C ) continue;//맵외부에 있으면 안됨
				if(visited[nr][nc]||graph[nr][nc]==0) continue;//방문했거나 접근 불가지역이면 안됨.
				
				//접근 가능지역이면 큐에 삽입. 거리 +1
				q.offer(new int[]{nr, nc, curDist+1});
				visited[nr][nc] = true;
			}
		}
		
		
		
	}

}
