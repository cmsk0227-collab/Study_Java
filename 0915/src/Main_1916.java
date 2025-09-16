import java.util.*;
import java.io.*;


/*
 * 생성자 활용 및 람다식을 이용한 오름차순 정렬
 * 그래프를 인접리스트로 표현하기
 */

public class Main_1916 {
	static int start, end ;
	static int[] dist;
	static ArrayList<ArrayList<Node>> graph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine()); //노드
		int m = Integer.parseInt(br.readLine()); //간선
		
		//이 부분 구현 x -> 인접리스트 구현 연습 필요
		 graph = new ArrayList<>();
		
		for(int i = 0; i <= n ; i++) { //노드가 1번부터 시작
			graph.add(new ArrayList<>());
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());//출발
			int v = Integer.parseInt(st.nextToken());//도착
			int w = Integer.parseInt(st.nextToken());//이동 비용
			graph.get(u).add(new Node(v, w));
		}
		
		st = new StringTokenizer(br.readLine());
		 start = Integer.parseInt(st.nextToken());		
		 end = Integer.parseInt(st.nextToken());		
		
		//로직
		dist = new int[n+1]; // 시작점에서 i까지의 최단거리
		Arrays.fill(dist, Integer.MAX_VALUE);//MAX_VALUE보다 10^6 이나 10^7을 써야 오버플로우 안남.
		daji();
		System.out.println(dist[end]);
		
		
	}
	
	//다익스트라 논리 이해 부족
	private static void daji(){
		PriorityQueue<Node> pq = new PriorityQueue<>();//큐에 현재 담아긴 자료 중 가장 작은 값을 반환.
		
		pq.add(new Node(start, 0));//시작점
		dist[start] = 0;//이게 안되기도 한다구??
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();//가중치 기준으로 가장 작은 값을 꺼냄.
			int v = now.v;
			int w = now.w;
			
			if(dist[v] < w) continue;//이거 없으면 시간 초과남.
			
			for(Node next : graph.get(v)) {
				if(dist[next.v] > dist[v] + next.w) {
					dist[next.v] = dist[v] + next.w;
					pq.add(new Node(next.v, dist[next.v]));
				}
			}
			
		}
		
	}
	
	//implements??
	static class Node implements Comparable<Node>{
		int v;
		int w;//시작,도작, 비용
		
		Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
		//생성자 선언, 오버라이드 개념 보충
		@Override
		public int compareTo(Node node) {
			return this.w - node.w;
		}
		
		
	}

}

