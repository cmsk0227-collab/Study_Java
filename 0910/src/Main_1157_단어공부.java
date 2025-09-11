import java.util.*;
/*
 * 난이도 : 어려움
 * 풀이 아이디어
 * 1. 입력 단어를 대문자로 통일
 * 2. 길이 26인 int[] 만들고, 각 문자를 'A'를 0으로 정렬해 빈도를 카운트
 * 3. 배열을 순회하면 최대 빈도와 위치와 동률을 찾는다.
 * 4. 최빈 문자가 하나면 문자(대문자) 출력. 여러 개면 ? 출력 
 * 
 * 놓친 부분
 : 최대값이 갱신되었을 때 최댓값을 카운팅하는 변수를 0를 초기화해야했음.
 : 하지않으면 최댓값이 갱신되어도 무조건 ? 출력.
 */

public class Main_1157_단어공부{
	public static void main(String[] args){//JVM 실행 시작점.
		Scanner sc = new Scanner(System.in);
		//표준 입력(System.in)과 연결된 Scanner 객체 생성
		//표준입력 스트림. 오류처리 강제 x. 잘못된 입력이 들어왔을 경우 런타임오류
		
		int[] alphabet = new int[26];
		//문자 등장 빈도 기록. 'A'를 0으로 정렬
		
		//단어 1개만 입력되므로 next() 사용(공백 전까지만 읽음)
		String str = sc.next().toUpperCase();//대문자를 출력해야므로 편의를 위해 입력값을 전부 대문자로 전환
		
		//문자 빈도 카운트
		for(int i = 0 ;  i  < str.length() ; i++) {
			int location = str.charAt(i) - 'A';//현재 문자 - 'A' -> 정렬된 자리 찾기. 
			alphabet[location] += 1;	//해당 철자에 해당하는 배열 칸 증가/
		}
		
		//최댓값 탐색 및 동률 확인
		int max= 0; //지금까지 발견한 문자 최빈값
		int same = 0;//현재 최댓값과 동률인 다른 문자 수
		int idx = -1; //max를 가진 문자의 인덱스
		for(int i = 0; i < alphabet.length ; i++) {
			if(alphabet[i] > max) {//새 최댓값 발견 → 최댓값/인덱스 갱신, 동률 카운트 초기화
				max = alphabet[i];//최댓값 갱신
				idx = i;//최댓값 인덱스 갱신
				same = 0; //최대값이 갱신되었으니 기존의 동률 카운트는 리셋
			}
			else if(alphabet[i] == max && max != 0) same ++; //가장 많이 사용된 알파벳이 하나 더 추가
		}
		
		System.out.println(same == 0 ? (char)(idx+'A') : '?');
		/*
		 [삼항 연산자] : 형식 : 조건식 ? 참일_때_값 : 거짓일_때_값
		 [아스키코드 ->char] : (char) 아스키코드(숫자)
		 */
	sc.close();}

}