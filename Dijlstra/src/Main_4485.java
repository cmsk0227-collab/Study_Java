import java.util.*;
import java.io.*;

public class Main_4485 {
	public static class Node implements Comparable<Node> {
		int r, c, cost;
		Node(int r, int c, int cost){
			this.r = r;
			this.c = c;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static int n;
	static int[][] map;
	static int[][] dist;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = 1;
		while(true) {
			n = Integer.parseInt(br.readLine());
			
			if(n == 0) break;
			
			map = new int[n][n];
			dist = new int[n][n];
			visited = new boolean[n][n];
			
			for(int r = 0; r < n ; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c = 0; c < n ; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					dist[r][c] = Integer.MAX_VALUE;
				}
			}
			
			daijkstra(0,0);
			
			sb.append("Problem ").append(t).append(": ").append(dist[n-1][n-1]).append("\n");
			t++;
		}
		
		System.out.println(sb);
		
	}
	private static void daijkstra(int sr, int sc) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		dist[sr][sc] = map[sr][sc];
		pq.offer(new Node(sr, sc, dist[sr][sc]));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int r = cur.r;
			int c = cur.c;
			int cost = cur.cost;
			
			if(visited[r][c]) continue;
			visited[r][c] = true;
			
			for(int i = 0 ; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(nr < 0 || nr >= n || nc <0 || nc >= n) continue;
				if(visited[nr][nc]) continue;
				
				int curDist = dist[r][c] + map[nr][nc];
				if(curDist < dist[nr][nc]) {
					dist[nr][nc] = curDist;
					pq.offer(new Node(nr, nc, dist[nr][nc]));
				}
				
			}
		}
		
	}

}
