/*
 *sublist(i, j) 일 때,
 * j는 포함하지 않는다. 고로, j범위까지 포함하길 바란다면 j+1로 작성해야한다.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main_10811_list {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		//표준 입력으로부터 정수를 읽기 위한 Scanner
		//Scanner 생성은 체크 예외를 요구하지 않지만, 자원이므로  사용 후 close
		
		
		int N = sc.nextInt(); // 바구니 수
		int M = sc.nextInt(); // 바구니 위치 변경 횟수(=연산 횟수)
		
		List<Integer> list = new ArrayList<Integer>();
		//N을 저장할 가변 길이 container로 Arraylist 사용
		//collections.reverse & sublist을 사용하기 위해 사용
		
		for(int i = 1; i <= N ; i++) {//초기 상태, 바구니 번호 1번부터 N번까지 순서대로 저장.
			list.add(i);
		}
		
		while(M-- > 0) {// M번 반복. 후위 연산자를 사용헤 간단하게 반복문 표기
			int i = sc.nextInt() -1; //구간 시작. 인덱스는 0부터 시작하므로 -1
			int j = sc.nextInt() -1; //구간 끝. 인덱스는 0부터 시작하므로 -1
			
			Collections.reverse(list.subList(i, j+1));//i~j 구간 리버스
			/*
			 * [list.sublist(i, j+1)]
			 * : 리스트에서 i부터 j까지의 뷰(원본 리스트 일부를 확대. 복사본x. 여기가 수정되면 원본도 수정)
			 * : 끝에 들어간 숫자는 포함 x
			 * [Collections.reverse()
			 * 주어진 리스트을 역순으로 뒤집기
			 */
		}
		
		for(int a : list) {//향상된 for문
			System.out.print(a + " ");
			
	
		}
	//자원정리
		sc.close();}

}
