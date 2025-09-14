import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	static int n, m, tall, small;
	static int[][] adj;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T ; t ++) {
			n = Integer.parseInt(br.readLine()); //학생 수 
			m = Integer.parseInt(br.readLine()); //대소 관계 수
			
			adj = new int[n+1][n+1];
			
			for(int i = 1; i <= m ; i++) {
				StringTokenizer st  = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adj[from][to] = 1;
			}
			
			int res = 0; //키순서를 아는 학생 수
			//모든 학생 조시
			for(int i = 1; i <= n ; i++) {
				tall = 0;
				small = 0;
				//i = 현재 조사 중인 학생
				tallBfs(i); //나보다 키 큰 사람을 찾는 bfs
				smallBfs(i); //나보다 키 큰 사람을 찾는 bfs
				
				if(small + tall == n - 1) res++; 
			}
			
			System.out.println("#"+t+" "+res);
		}
		
			
	}
	//나보다 큰 학생 
	private static void tallBfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] isVisited = new boolean[n+1];
		
		q.add(start);
		isVisited[start] = true;
		
		while(!q.isEmpty()) {//탐색할 노드 방문. 그 후 인접 노드 붕만예약
			int k = q.poll();
			for(int i = 1; i <= n ; i++) {
				if(adj[k][i] == 1 && !isVisited[i]) {
					q.add(i);
					isVisited[i] = true;
					tall++;
				}
			}
			
		}
		
	}
	
	//나보다 작은 학생
	private static void smallBfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] isVisited = new boolean[n+1];
		
		q.add(start);
		isVisited[start] = true;
		
		while(!q.isEmpty()) {//탐색할 노드 방문. 그 후 인접 노드 붕만예약
			int k = q.poll();
			for(int i = 1; i <= n ; i++) {
				if(adj[i][k] == 1 && !isVisited[i]) {
					q.add(i);
					isVisited[i] = true;
					tall++;
				}
			}
			
		}
		
	}

}

/*
1
6
6
1 5
3 4
5 4
4 2
4 6
5 2

 */