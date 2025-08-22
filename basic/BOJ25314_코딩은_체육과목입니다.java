/*
 * 백준_코딩은 체육과목입니다_25314
 * 난이도: 브론즈5
 * 메모리 175676KB , 시간 184ms
 * 문제요약
 * 저장공간이 4byte씩 늘어날 때마다 long이 하나 더 출력된다.
 * 문제 아이디어
 * 1. int 출력은 고정이다.
 * 2. N/4의 값은 long의 총 출력횟수다. N/4만큼  long을 반복출력하기 위해 for문 사용
 */
import java.util.*;

public class Main_25314 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();//4의 배수로 입력된 정수
		int count = N/4; //long 출력 횟수
		
		for(int i=1; i <= count; i++) {//long 출력
			System.out.print("long ");
		}
		System.out.print("int");
sc.close();
}
}
