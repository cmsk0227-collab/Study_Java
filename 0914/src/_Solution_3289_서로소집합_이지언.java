import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 문제명 SEWA 3289 서로소집합
 * 난이도: D4 체검난이도 : 보통 ~ 약간 어려움.
 * 문제 풀이 아이디어 : 서로서 집합의 연산, 성질 활용
 * [틀린 부분]
 * for문 내 반복 변수를 잘못 씀.
 * i 자리에 j 쓰기
 * 반복변수가 아닌 비교 변수 ++
 * sb는 누적해서 입력값을 받은 후 츌력하는 것이기 때문에 출력에 앤터가 있으면 삽입해줘야함.
 * 출력 마스터를 못해서 오랫동안 헤맴. 로직이 아니라 출력이 어려웠던 문제
 * 
 */
public class _Solution_3289_서로소집합_이지언{
	static int[] parents;
	
	public static int find(int a) {//루트노드 찾기
		if(parents[a]==a) return a;
		return parents[a] = find(parents[a]);//한 칸씩 올라가다가 결국 부모노드가 루트노드가 됨.
	}
		

	private static boolean union(int a , int b) {
		int aRoot = find(a);// a가 포함된 집합의 대표자
		int bRoot = find(b);// b가 포함된 집합의 대표자
		if(aRoot == bRoot) return false; //서로 다른 집합이라 합병 x
		else {
			parents[bRoot] = aRoot;// 두 집합이 완전히 병합됨. 
			return true;
	}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(st.nextToken());// 테케
		
		for(int t = 1; t <=T ; t++) {
			st = new StringTokenizer(br.readLine());
			int n =Integer.parseInt(st.nextToken()); //원소(노드) 수
			int m =Integer.parseInt(st.nextToken()); //연산 횟수
			 
			//부모노드를 기록하는 배열
			parents = new int[n+1];//인덱스 1번 부터 사용
			for(int i = 1; i <=n ; i++) {// 서로소 노드 
				parents[i] = i;
			}
			
			sb.append("#").append(t).append(" ");
			
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int what = Integer.parseInt(st.nextToken()); // 0:합집합  1: 포함 확인 
				int a= Integer.parseInt(st.nextToken()); // 갑
				int b= Integer.parseInt(st.nextToken()); // 을

						
				switch(what) {
				case 0:// union(a,b)
					union(a,b);
					break;
					
				case 1:// 포함여부 확인
					int aRoot = find(a);
					int bRoot = find(b);
					if( aRoot == bRoot) sb.append("1");// 속하면 1
					else {
						sb.append("0");//속하지않으면 0
					}
				
				}
		}
			sb.append("\n");
	}
		System.out.println(sb);
}
}
