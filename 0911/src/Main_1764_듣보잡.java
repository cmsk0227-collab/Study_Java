import java.util.*;
import java.io.*;
/*
 * /*
 * 난이도 : 실버4 
 * 체감난이도 : 약간 어려움
 * 풀이아이디어 : '노듣 & 노보'의 교집합을 사전순으로 출력.
 * 1) (존재 여부) 확인은 HashSet이 평균 O(1) → 듣지 못한 사람을 HashSet에 저장
 * 2) 보지 못한 사람을 읽으면서 contains()가 true이면 결과 TreeSet에 추가
 *    - TreeSet은 중복 X + 자동 오름차순(사전순) 정렬
 * 3) 결과 크기와 원소들을 차례대로 출력
 *
 * 시간복잡도:
 *  - 듣 목록 저장: O(n)
 *  - 보 목록 순회 + 멤버십 검사: O(m)
 *  - 결과 삽입(TreeSet): 교집합 크기를 r이라 할 때 각 삽입 O(log r) → O(r log r)
 *  => 총 O(n + m + r log r)
 */

public class Main_1764_듣보잡 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //빠른 입력
		StringBuilder sb = new StringBuilder(); //빠른 출력
		StringTokenizer st = new StringTokenizer(br.readLine().trim()); //공백 기준으로 토큰화하기 위해
		HashSet<String> set = new HashSet<>(); //순서가 없어서 조회가 빠른 hash_set
		TreeSet<String> final_set = new TreeSet<>();//중복 x, 오름차순, 사전순으로 출력용
		
		int nl  = Integer.parseInt(st.nextToken()); //듣지 못한 사람 수
		int ns  = Integer.parseInt(st.nextToken()); // 보지 못한 사람 수
		
		while(nl-- > 0) set.add(br.readLine().trim()); //듣지 못한 사람 이름 입력
		
		// 보지 못한 사람 입력을 읽으며 교집합만 결과 TreeSet에 추가
		while(ns-- > 0) {
			String name = br.readLine().trim(); //보지 못하는 사람 한 명의 이름
			boolean ans = set.contains(name); //교집합이면
			if(ans) final_set.add(name); //출력 및 정렬용 final_set에 담기
		}
		
		
		int num = final_set.size(); //듣보잡 수
		
		//출력
		sb.append(num).append("\n");
		
		for(String list : final_set) {
			sb.append(list).append("\n");
			}
		
		System.out.println(sb);
}
}

/*
수정 코드 짚고 가기
두 번 째 입력값과 일치하지않은 값을 제거하자!
포함되지않은 name(obama)를 찾음
set.remove(obama) -> 오바마를 제거.
하지만, 오바마는 원래 없었죠? 없는 문자를 없애는 거죠? 그대로죠?
그래서 틀린 코드죠!

while(ns-- > 0) {
			String name = br.readLine();
			boolean ans = set.contains(name);
			if(ans == false) set.remove(name);
			System.out.println(set);
		}
 */
