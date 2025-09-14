import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/*
 * 문제: BOJ 10815. 숫자 카드 (실버5)
 * 체감 난이도: 쉬움
 * 
 * 풀이 아이디어:
 *  - 보유 카드 N개를 HashSet에 저장 → 평균 O(1) 탐색
 *  - M개의 질의 숫자에 대해 contains() 확인 후 1/0 출력
 * 
 * 알고리즘 흐름:
 *  1 입력 최적화: br + st + sb 사용 (Scanner는 정규식 파싱이라 N+M=100만 이상 입력에서 TLE 위험)
 *  2 N개의 숫자를 HashSet에 add
 *  3 M개의 숫자에 대해 contains()로 존재 여부 검사
 *  4 결과를 StringBuilder에 누적 후 한 번에 출력
 * 
 * 시간복잡도:
 *  - N개의 삽입: O(N)
 *  - M개의 탐색: O(M)
 *  - 총 O(N + M) (HashSet 평균 O(1) 연산 가정)
 */

public class Main_10815_숫자카드 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 빠른 입력
		StringBuilder sb = new StringBuilder(); // 빠른 출력
		StringTokenizer st;

		HashSet<Integer> card = new HashSet<>(); // 카드 집합(중복 허용 X, 탐색 빠름)

		
		int N = Integer.parseInt(br.readLine());//상근이가 가진 카드 개수

	
		st = new StringTokenizer(br.readLine());	//N개의 숫자 입력 받아 HashSet에 저장
		while (N-- > 0) {
			int a = Integer.parseInt(st.nextToken());
			card.add(a); // HashSet에 삽입 (중복 자동 제거)
		}

		int M = Integer.parseInt(br.readLine());

		// M개의 숫자  처리
		st = new StringTokenizer(br.readLine());
		while (M-- > 0) {
			int num = Integer.parseInt(st.nextToken());
			boolean res = card.contains(num); // 존재 여부 확인
			sb.append(res ? "1" : "0").append(" "); // 결과 추가
		}

		// 5) 한 번에 출력
		System.out.println(sb);
	}
}
