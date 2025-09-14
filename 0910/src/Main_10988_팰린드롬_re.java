import java.util.Arrays;
import java.util.Scanner;

/*
 * 체감난이도 : 약간 쉬움
 * 
 * 풀이 아이디어  : 정방향 == 역방향 -> 1 출력 아니면 0 출력
 * 알고리즘
 * 1. 문자열을 char[]로 받는다
 * 2. 해당 문자열을 역순으로 만든다
 * 3. 정방향과 역방향을 일치여부를 확인한다
 * 4. 일치하면 1 아니면 0 출력
 * 
 * 개념 보충
 * Arrays.equals(배열, 배열) -> 동일한 값이며 true 아니면 false
 */
public class Main_10988_팰린드롬_re {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);          // 입력 도구 준비

	        char[] arr = sc.next().toCharArray();         // 단어 하나를 읽어 문자 배열로 변환

	        int s = 0;                                    // 왼쪽 포인터(시작 인덱스)
	        int e = arr.length;                           // 오른쪽 포인터의 "다음" 위치(배열 길이) — 인덱스는 e-1이 마지막

	        char[] reverse = new char[e];                 // arr와 같은 길이의 뒤집힌 배열 준비
	        while (s < e) {                               // 양끝에서 가운데로 이동하며 채움(중앙 교차/만날 때 종료)
	            reverse[s]   = arr[e - 1];                // 왼쪽 자리에는 arr의 오른쪽 끝 문자를
	            reverse[e-1] = arr[s];                    // 오른쪽 자리에는 arr의 왼쪽 끝 문자를
	            s++;                                      // 왼쪽 포인터 한 칸 오른쪽으로
	            e--;                                      // 오른쪽 포인터 한 칸 왼쪽으로 (e는 실제 인덱스가 아니라 "다음" 위치이므로 e-1이 유효 인덱스)
	        }

	        boolean res = Arrays.equals(arr, reverse);    // 원본과 뒤집은 배열이 같으면 팰린드롬

	        if (res) System.out.println(1);               // 팰린드롬이면 1
	        else      System.out.println(0);              // 아니면 0

	        sc.close();                                   // 자원 해제
	    }
}
