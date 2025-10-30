import java.util.*;
import java.io.*;

/**
 * @주의점
 * 1.BFS 길찾기는 항상 최단경로. 
 * 왜냐, BFS는 큐를 사용해 가까운 순서대로 방문함. 시작점과 거리가 1인 애들 모두 방문 후 2인 애들 방문. 거리가 2인 애들을 다 방문하면 거리가 3인 애들 방문을 한다.
 * 고로, BFS로 목표지점을 발견한다면 그 거리는 최단거리이다. 
 * 
 * @실수
 * 1. x,y 좌표와 r,c 배열 위치 혼동
 *
 */
/*
 * 메모리 :  14728KB 
 * 시간  : 112ms
 * 풀이아이디어
 */

public class Main_2178_기초 {
//	4방 탐색
	static int[] dx = {-1,1,0,0};
	static int[] dy = { 0,0,-1,1};
	
//	bfs
	static int R, C, min;
	static boolean[][] visited;
	static int[][] graph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
//		입력
		R = Integer.parseInt(st.nextToken());//행
		C = Integer.parseInt(st.nextToken());//열
		visited = new boolean[R+1][C+1];
		
//		그래프 입력
		graph = new int[R+1][C+1];
		for(int r = 0; r < R; r++) {
			String line = br.readLine();
			for(int c = 0 ; c < C ; c++) {
				graph[r+1][c+1] = line.charAt(c) - '0';
			}
		}
//		로직
		min = 0;
		bfs(1,1);
//		출력
		System.out.println(min);
		
	}
	/**
	 * @param r : 현재 칸의 y좌표
	 * @param c : 현재 칸의 x 좌표
	 */
	private static void bfs(int r, int c){
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {r,c,1});
		visited[r][c] =true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll(); //현재 칸의 x좌표, y좌표
			int curR = cur[0];
			int curC= cur[1];
			int curDist = cur[2];
			
			if(curR == R && curC == C) min = curDist;
			
			for(int i = 0; i < 4 ; i++) {
				int nr = curR + dy[i];
				int nc = curC + dx[i];
				
				if(nr < 1 || nr > R||nc < 1 || nc >  C ) continue;
				if(visited[nr][nc]||graph[nr][nc]==0) continue;
				
				q.offer(new int[]{nr, nc, curDist+1});
				visited[nr][nc] = true;
			}
		}
		
		
		
	}

}
