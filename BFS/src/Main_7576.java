import java.util.*;
import java.io.*;

public class Main_7576 {
//	사방탐색
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
//	BFS
	static int C, R;
	static int x = 0;//설익은 토마토 수
	static int tCnt = 0;//true 수
	static int[][] map;
	static int[][] distance;
	static boolean[][] visited;
	static ArrayList<int[]> location = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		C = Integer.parseInt(st.nextToken()); //열
		R = Integer.parseInt(st.nextToken()); //헹
		
		map = new int[R][C];
		distance = new int[R][C];
		visited = new boolean[R][C];
		
		for(int r = 0; r < R ; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < C ; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] == 1) location.add(new int[]{r,c});
				if(map[r][c] == 0)  x++ ;
			}
		}
		
		if(x == 0) System.out.println(0);
		else { 
			bfs(location);
			
			if(tCnt == x) {
				int minDis = 0;
				for(int r = 0 ; r < R ; r++) {
					for(int c = 0; c < C ; c++) {
						minDis = Math.max(minDis, distance[r][c]);
					}
				}
				System.out.println(minDis);
			}else {
				System.out.println(-1);
			}
				
		}
		
	

		
	}
	 
	private static void bfs(ArrayList<int[]> list) {
		Queue<int[]> q = new LinkedList<>();
		
		for(int[] a : list) {
			int r = a[0];
			int c = a[1];
			q.add(new int[] {r,c});
			visited[r][c] = true;
			distance[r][c] = 0;
		}
		
		
		while(!q.isEmpty()) {
			
			int[] cur = q.poll();
			int cr = cur[0];
			int cc = cur[1];
			
			
			for(int i = 0; i < 4 ; i++) {
				int nr = cr + dx[i];
				int nc = cc + dy[i];
				
				if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
				if(visited[nr][nc]||map[nr][nc] == -1 ) continue;
				
				distance[nr][nc] = distance[cr][cc] + 1;
				q.add(new int[] {nr, nc});
				visited[nr][nc] = true;
				tCnt++;
			}
		}
		
		
		
	}

}
