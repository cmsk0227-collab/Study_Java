import java.util.*;
import java.io.*;

public class Main_1916_최소비용{
	static int INF = 1000000;
	static int n, m, start, end;
	static ArrayList<Node>[] graph;
	static int[] dist;
	static class Node implements Comparable<Node>{
		int v, cost;
		
		Node(int v, int cost) {
			this.v = v;
			this.cost = cost;
		}
		
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine()); //노드 
		m = Integer.parseInt(br.readLine()); //간선
		
		//그래프 구현
		graph = new ArrayList[n+1];
		for(int i = 1; i <= n ; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i = 1 ; i <= m ; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());//탐색노드
			int v = Integer.parseInt(st.nextToken());//인접노드
			int w = Integer.parseInt(st.nextToken());//탐색 -> 인접 가중치
			graph[u].add(new Node(v, w));
		}
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		//다익스트라
		dist = new int[n+1]; //도시번호 1~n반
		Arrays.fill(dist, INF);//최솟값 갱신할 수 있도록 초기화.
		
		daji();
		System.out.println(dist[end]);
	}
	
	private static void daji() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		//시작점
		dist[start] = 0;
		pq.offer(new Node(start, 0));
		
		//연산시작!
		while(!pq.isEmpty()) {
			Node now = pq.poll();//현재 탐색노드 { 인접 노드, 가중치 , 비교메서드}
			int now_v = now.v;// 인접노드
			int now_cost = now.cost;// 인접노드의 가중치
			
			if(dist[now_v] < now_cost) continue; 
			
			for(Node next : graph[now_v]) {//인접노드 조회 왜 안돼
				if(dist[next.v] > dist[])
				
			}
			
		}
		
	}
	
}