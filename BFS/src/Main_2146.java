import java.util.*;
import java.io.*;

/**
 * 메모리 : 81600KB, 244ms
 *
 */
public class Main_2146 {
//	4방 탐색
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
//	BFS
	static int n;//지도 크기
	static int[][] map;
	static boolean[][] visited;//방문배열
	
	static ArrayList<int[]>[] arr; //연결된 좌표. 즉, 섬을 구성하는 좌표 저장
	static int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());//맵의 크기
		
		map = new int[n][n];
		visited = new boolean[n][n];
		
		for(int r = 0; r < n ; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c= 0; c < n ; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}		
//		로직
//		섬 구분하기 - 다른 섬은 다른 번호 붙이기
		int cnt = 1;
		for(int r = 0; r < n ; r++) {
			for(int c= 0; c < n; c++) {
				if(map[r][c] == 1 && !visited[r][c]) {
					bfs(r, c, cnt);
					cnt++;
					}
			}
		}
		
		//arr 초기화
		arr = new ArrayList[cnt];
		for(int i = 0; i < cnt ; i++) {
			arr[i] = new ArrayList<>();
		}
		
//		경계값 찾기
		for(int r= 0; r < n; r++) {
			for(int c = 0; c < n ; c++) {
				if(map[r][c] > 0) {
					for(int d = 0; d < 4; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						
						if(nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
						if(map[nr][nc]==0) {
							arr[map[r][c]].add(new int[] {r, c});
							break;
						}
					}
				}
			}
		}
//		경계값에서부터 최단거리 찾기
//		가장 먼저 다른 섬에 닿는 거리가 최단 거리
//		1 번부터 차례로 
		for(int i = 1; i < cnt ; i++) {
			int dist = bfs2(i); //i번쨰 섬에서 다른 섬까지의 최단거리
			ans = Math.min(ans, dist);
		}
		
		//출력
		System.out.println(ans);
	}
	
	/**
	 * @param i_num : 현재 섬 번호
	 */
	
//	최단거리구하는 bfs
	private static int bfs2(int i_num) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited2 = new boolean[n][n];
		
		//경계좌표 전부를 시작점으로 설정
		for(int[] pos : arr[i_num]) {
			q.offer(new int[] {pos[0], pos[1],0});//r,c,거리(시작점이니까 자기 자신 거리 0)
			visited2[pos[0]][pos[1]] = true;
	  }
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			int cost = cur[2];
			
			for(int i = 0; i < 4 ; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
				if(visited2[nr][nc]||map[nr][nc] == i_num) continue;
				
				if(map[nr][nc] == 0) {
					if(cost+1 > ans) continue;//이미 더 길면 확장 x. 왜냐, 최단거리 찾기 목표
					q.offer(new int[] {nr, nc, cost+1});
					visited2[nr][nc] = true;
				}
				else return cost;
				
			}
		}
		return Integer.MAX_VALUE; // 못 찾는 경우
	}
	
//	섬 수를 구하는 bfs
	private static void bfs(int sr, int sc, int cnt) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {sr, sc});
		visited[sr][sc] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			map[r][c] = cnt;
			
			for(int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
				if(visited[nr][nc] || map[nr][nc] == 0) continue;
				q.offer(new int[] {nr, nc});
				visited[nr][nc] = true;
				}
			}
		}
		
		
	}

