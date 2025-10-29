import java.util.*;
import java.io.*;



// 문제 : Main_1916_최소비용구하기
// 난이도 : 어려움
// 메모리 : 50588KB
// 시간 : 472ms
// 풀이 아이디어 : 다익스트라  <= 양의 가중치 + 그래프에서의 최단 거리 
//  
 

/*
 * 우선순위 큐 동작원리 *
 1. Node 객체(속성+메서드)를 pq 삽입
 2. pq 내에서 새로 들어온 원소와 기존 원소 비교
 3. 비교할 때 compareTo() 호출해 음수 / 0 / 양수를 반환받음
 	반환값 
 	음수 -> this가 앞
 	0 -> 순서 유지
 	양수 0> this가 뒤
 */

public class Main_1916_최소비용2 {
	static int n,m,start, end ;
	static int[] dist; 
	static ArrayList<ArrayList<Node>> graph;//인접리스트 구현
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine()); //노드 - 도시
		m = Integer.parseInt(br.readLine()); //간선 - 버스
		
//		[이중리스트 구현]
//		(1) 외부리스트
		 graph = new ArrayList<>();
		for(int i = 0; i <= n ; i++) { //노드 번호 1~n번
//		(2) 내부리스트 
			graph.add(new ArrayList<>());
		}
		
		//인접한 정점과 가중치 입력
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());//탐색정점 - 출발지
			int v = Integer.parseInt(st.nextToken());//탐색정점과 인접한 노드 - 도착지
			int w = Integer.parseInt(st.nextToken());//탐색정점과 인접 노드까지의 가중치 - 버스이용금
			graph.get(u).add(new Node(v, w));//Node 클래스의 객체(속성,메서드)를 u번 리스트에 입력. 
		}
		
		 st = new StringTokenizer(br.readLine());
		 start = Integer.parseInt(st.nextToken());//구하고자하는 구간의 시작점	
		 end = Integer.parseInt(st.nextToken());//구하고자하는 구간의 도착점
		
		//로직
		dist = new int[n+1]; // 시작점에서 i까지의 최단거리
		Arrays.fill(dist, 1000000);//MAX_VALUE보다 10^6 이나 10^7을 써야 오버플로우 안남.
		daji();//클래스 필드에 있는 메서드는 매게변수가 없어도 순서가 되면 호출. 꼭 인자를 적을 필요는 없음.
		System.out.println(dist[end]);//출발점부터 end까지의 최단거리 출력
		
		
	}
	
	
	/*
	 * 다익스트라 구현
	 * 1. 우선순위큐  
	 * 2. 중복방문을 막기 위한 boolean 배열 또는 if(dist[v] < w)
	 * 3. 기존 최단거리와 탐색중인 v와 인접한 노드까지 최단거리를 비교해 더 작은 값으로 갱신 
	 */
	private static void daji(){
		PriorityQueue<Node> pq = new PriorityQueue<>();//큐에 현재 담아긴 자료 중 가장 작은 값을 반환.
		
		pq.add(new Node(start, 0));//시작점 - 시작점의 가중치는 항상 0. 
		dist[start] = 0;//출발점에서 출발점까지의 거리 0
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();//가중치 기준으로 가장 작은 값을 꺼냄.
			int v = now.v;
			int w = now.w;
			
			if(dist[v] < w) continue;
//			dist[] = 바로 직전 노드까지의 최단거리 + 가중치
//			이 때 가중치인 w가 최단거리도 크다면 무엇을 합하든 항상 이전 최단거리 값보다 크므로 굳이 계산할 필요 x
//			continue.
//			
			for(Node next : graph.get(v)) {//v번희 인접한 Node 정보가 차례로 나옴
				if(dist[next.v] > dist[v] + next.w) {//인접쟁점까지의 최단거리(기존) > 현재노드까지의 최단거리 + 현재 가중치
					dist[next.v] = dist[v] + next.w;//dist[next.v] 갱신(시작점부터 인접한 쟁점까지의 최단거리)
					pq.add(new Node(next.v, dist[next.v]));
				}
			}
			
		}
		
	}
	
	//클래서 Node 선언. 그리고 이 노드는 node와 비교하는 기능도 함께 수행한다

//	 인터페이스  Comparable<T> 
//	  규칙
//	  디폴트 : 숫자 - 오름차순, 문자 - 사전순(ㄱㄴㄷ,abc) 날짜 - 빠른 날짜부터 정렬
//	 a.compareTo(b)의 반환값이 음수 -> a < b -> a, b
//	 a.compareTo(b)의 반환값이 0 -> a == b -> 순서 유지
//	 a.compareTo(b)의 반환값이 음수 -> a < b -> b, a
	
	static class Node implements Comparable<Node>{//노드끼리 비교하도록 인터페이스 구현 -> pq에서 자동정렬
		//필드
		int v;//도착 정점
		int w;//가중치
		
		//생성자
//		작성 형식 : 클래스명(매개변수목록){...}
//		특징
//		1. 클래스명과 동일
//		2. 반환형 없음
//		3. 객체 생성 시 자동 호출  ex) new 클래스명()
//		4. 주로 필드 초기화에 사용
//		5. 매개변수에 따라 오버로딩 가능
		
		Node(int v, int w) {//v,w 초기화
			this.v = v;
			this.w = w;
		}
		
		//CompareTo 메서드 - 두 Node 객체 비교 시 호출
		@Override
		public int compareTo(Node node) {
			return this.w - node.w;//정렬 기준 -가중치 오름차순
			
//			 this.w - node.w 결과가 음수면 → this.w < node.w → this가 앞에 유지됨 (작은 값 우선)
//			 결과가 양수면 → this.w > node.w → this가 뒤로 감 (큰 값 뒤로)
//			 따라서 작은 w가 먼저 나오므로 오름차순 정렬
		}
		
		
	}

}

//클래스 선언 형식
//    [접근제어자] class 클래스명 [extends 부모클래스] [implements 인터페이스들] {
// 			필드(멤버 변수)
//			생성자
// 			메서드
// 			내부 클래스(선택)
//						}
