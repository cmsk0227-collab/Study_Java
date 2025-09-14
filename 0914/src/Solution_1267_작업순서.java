/*
 * 문제: Solution_1267_작업순서
 * 체검난이도 : 약간 어려움.
 * 풀이 아이디어
 * 1. 희소그래프 -> 인접리스트(이중리스트, 메서드)
 * 2. 선행관계가 존제 -> 위상정렬(진입차수, 큐)
 * 사용개념
 * 1. 이중리스트(인접리스트)
 * 2. 진입차수 배열
 * 3. 큐(BFS 활용)
 * 4. 위상정렬
 * 5. 반복문(for, while)
 * 6. 조건문 (if)
 * 7. 전위 감소 연산자 동작 처리.
 * 8. 문자열처리(StringBuilder)
 */
import java.util.*;
import java.io.*;

public class Solution_1267_작업순서 {
	static ArrayList<ArrayList<Integer>> graph; //인접리스트
	static int[] indegree;//진입차수 배열

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = 10;//테케
	
		for(int t =1 ; t <= T; t++) {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken()); //정점
		int E = Integer.parseInt(st.nextToken()); //간선
		indegree = new int[V+1];
		
		//인접리스트 선언& 초기화
		graph = new ArrayList<>();//시작 노드를 담는 리스트 = 외부리스트
		for(int i=0; i <= V ; i++) {//노드 번호가 1번 부터 시작해 인덱스 0 사용 안 하니까 배열의 길이 V+1 
			graph.add(new ArrayList<>());//인접 노드 담는 리스트 = 내부리스트
		}
		
		//간선 입력(방향 그래프 from -> to)
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0 ; i < E ; i++) {
			int from = Integer.parseInt(st.nextToken()); //외부리스트 인덱스											
			int to = Integer.parseInt(st.nextToken()); //내부 리스트 인덱스
			graph.get(from).add(to);//이중리스트 삽입. from -> to 표현
			indegree[to]++;//진입차수 담기. 이거 진입차수 기준으로 0이 되면 queue에 담아야함.
		}																																																																																				                                                                                                                                                                                                                                                                                                                                                                                     
		
		//위상 정렬 실행
		//방문순서를 출력해야하므로 list 사용.
		
		/*
		 * 매게변수가 시작노드가 아닌 V(노드 수)인 이유? 진입노드가 0인 모든 노드를 찾기 위한 for문을 돌리려고.
		 * 위상정렬의 시작점 = 진입차수(indegree) 0인 모든 노드.
		 * BFS나 DFS처럼 단 하나의 시작점이 없음. 그래프 크기(V)와 indegree 기반으로 전체를 돌려야함
		 * V번 루트를 돌면서 진입차수가 0인 모든 노드를 찾아 큐에 넣어 어려 개의 시작 노드에서 동시에 출발하는 구조를 만들기 위해
		 * 매개변수를 노드 수(V)로 둠.
		 */
		List<Integer> order = sort(V);//작업 순서 기록 저장/
		
		//출력
		sb.append("#").append(t);//띄어쓰기 없음. #t
		for(int v : order) sb.append(" ") .append(v);//#t 2 4 ...
		sb.append("\n");
		}
		
		System.out.println(sb);
		
	} 
	
	static List<Integer> sort(int V) {
		List<Integer> result = new ArrayList<Integer>();//작업 순서 저장하기 위한 리스트
		Queue<Integer> queue = new ArrayDeque<>();//진입차수 0인 노드. 즉, 시작점을 담는 큐. 
		
		for(int i = 1; i <= V ; i++) {//진입차수가 0인 노드 큐에 삽입.
			if(indegree[i] == 0) {
				queue.offer(i);
			}
		}
		
		while(!queue.isEmpty()) {
			int cur = queue.poll(); //현재 작업 노드.
			result.add(cur); //작업 순서 기록.
	
			//현재 작업하는 노드의 진출차수 제거. -> 진입차수를 기록한 indegree 감소
			//graph.get(cur) => cur 인덱스 내부리스트 조회
			for(int next : graph.get(cur)) {
				/*
				 * 전위감 감소 연산자라 가장 먼저 intdegree[next] 값이 실제로 감소함.
				 * 조건문 속 조건() 안에 있지만 실제값이 감소. 조건에서만 영향력ㅇ 국한 x
				 */
				if(--indegree[next] == 0) 
					queue.offer(next);//반복되는 순서대로 추가.
				}

			}
		return result;
		
	}
	
}