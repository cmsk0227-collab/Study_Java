import java.util.*;

/*
 * 체감 난이도 : 쉬움
 * 문제풀이 아이디어 : set 활용
 * 1. 비교 기준이 되는 N개의 정수를 set에 담는다
 * 2. set.contains()를 활용해 들어오는 수의 포함여부를 확인.
 *  포함되면 true -> 1 출력
 *  포함되지않으면 false -> 0 출력
 *  
 */

public class Main_1920_수찾기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashSet<Integer> set = new HashSet<>();
        // HashSet 객체 생성. 
		// 특징:
        // 1) 입력된 요소는 순서 없음(저장된 순서를 보장하지 않음)
        // 2) 중복된 값 저장 불가 (자동으로 제거됨)
        // 3) 탐색/삽입 평균 시간복잡도 O(1) (빠름)
		
		int N = sc.nextInt();//기준값의 수(set에 저장할 원소)
		
		// N번 반복하여 정수를 입력받고 set에 추가.
        // set.add()는 같은 값이 이미 있으면 false를 반환하고, 없으면 true 반환.
		while(N-- > 0) set.add(sc.nextInt());
		
		int M = sc.nextInt(); //비교값 수
		
		while(M-- > 0) {//M번 반복
			int num = sc.nextInt();//현져 비교값 입력
			
			// set.contains(num): num이 set 안에 존재하면 true, 없으면 false 반환
			boolean checked = set.contains(num); 
			
			System.out.println(checked? "1" : "0");
			//삼항 연산자. 조건식이 참이면 1 출력, 아니면 0 출력
			//boolean값은 그 자체로 true or false이므로 변수만 적어도 충분
			
//	수정 코드 :	 System.out.println(checked == true ? "1" : "0");

		}
		
	sc.close();}// Scanner 닫기(자원 해제)

}
