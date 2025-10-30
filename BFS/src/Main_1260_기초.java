import java.util.*;
import java.io.*;

public class Main_1260_기초 {
	static ArrayList<Integer>[] graph;
	static boolean[] visited; //각자 따로 객체 생성하면 다른 메모리 사용하니까 하나만 사용해도 충분
	static ArrayList<Integer> d_order = new ArrayList<>();
	static ArrayList<Integer> b_order = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken()); //정점 수
		int e = Integer.parseInt(st.nextToken()); //간선 수 
		int s = Integer.parseInt(st.nextToken()); //시작 번호
		
		//노드 번호 1~
		//연결리스트 구현
		graph = new ArrayList[n+1];
		for(int i = 0 ; i < n+1 ; i++) graph[i] = new ArrayList<>();
		//관계 입력
		for(int i = 0; i < e ; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
//			양방향 그래프
			graph[a].add(b);
			graph[b].add(a);
		}
		
		//내부리스트 오름차순 정렬
		for(int i = 1 ; i <= n; i++) Collections.sort(graph[i]);
		
//		로직
		visited = new boolean[n+1];
		dfs(s);
		visited = new boolean[n+1];
		bfs(s);
//		출력 : dfs 방문순서 -> bfs 방문순서
		for(int d : d_order) System.out.print(d+" ");
		System.out.println();
		for(int b : b_order)System.out.print(b+" ");
	}
	
	/**
	 * @param now : 현재 탐색 쟁점의 번호
	 */
	private static void dfs(int now) {
		//종료
		if(visited[now]) return;
		visited[now] = true;
		d_order.add(now);
		
		//재귀
		for(int next : graph[now]) {
			if (visited[next]) continue;
			dfs(next);
		}
		
	}
	
	
	/**
	 * @param start :  탐색을 시작한 정점의 번호
	 */
	
	private static void bfs(int start) {
		Queue<Integer> q= new LinkedList<>();
		q.offer(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();//맨 앞에 있는 원소
			b_order.add(cur);
			
			for(int next : graph[cur]) {
				if(visited[next]) continue;
				q.offer(next);
				visited[next] = true;
			}
		}
				
			
	}
		
}

