import java.util.*;
import java.io.*;

public class Solution_3124_최소스패닝트리 {
	static int V, E; //정점, 간선
	static int[] parents;  // 부모 노드 파악하기 위하 배열
	static int[][] graph; // 간선정보
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		//입력
		int T = Integer.parseInt(st.nextToken());//테케 수
		
		for(int t = 0; t < T ; t++) {
			st = new StringTokenizer(br.readLine());
			
			V = Integer.parseInt(st.nextToken()); // 정점
			E = Integer.parseInt(st.nextToken()); // 간선
			
			graph = new int[E][3];//간선 관계 {시작점, 도착점, 가중치)
			
			for(int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				graph[i][0] = Integer.parseInt(st.nextToken()); // 시작 정점의 번호
				graph[i][1] = Integer.parseInt(st.nextToken()); // 도착 정점의 번호
				graph[i][2] = Integer.parseInt(st.nextToken()); // 가중치
			}
			
			
			//로직
			long ans = 0L; 
			// 최소 스패닝의 가중치.
			// 담길 수 있는 범위의 최댓값이 int를 초과해 Long
			parents = new int[V]; // 정점의 부모노드
			
			//간선 비용을 기준으로 오름차순 정렬
			Arrays.sort(graph, (o1, o2) -> Integer.compare(o1[2], o2[2]));
			
			//초기에 모든 접점이 자기 자신을 부모로 가르키도록 함/.
			for(int i = 0; i < V; i++) {
				parents[i] = i;
			};
			
			//최소신장트리
			for(int i = 0; i < E; i++) {
				int v = graph[i][0] - 1; //0부터 인덱스를 저장함. 다 한 칸씩 밀려서 저장. 꺼내기 편하게 -1
				int u = graph[i][1] - 1;
				int w = graph[i][2];
				
				if(find(v) != find(u)) {// 사이클 방지
				union(v, u);
				ans += w;
				}
				
			}
			
			sb.append("#").append(t+1).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
		
		
	}
	 
	static int find(int a) { // 루트 노드 찾기.
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
		
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false; 
		
		if(aRoot > bRoot) parents[aRoot] = bRoot; 
		if(aRoot < bRoot) parents[bRoot] = aRoot; 
		
		return true; 
		
	}
}

