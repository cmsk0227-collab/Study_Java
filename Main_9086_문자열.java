package com.main;
/*
 * 문제: 백준 9086
 * 난이도 : 브론즈5
 * 메모리 : 18300KB
 * 시간 : 184ms
 * 풀이아이디어
 * <입력>
 * 사용 클래스 Scanner
 * 테스터 케이스의 개수는 정수니까 nextInt()
 * 나머지 값들은 문자열이니 nextLine()으로 받자!(x); 버퍼에 남은 "\n" 받고 종료.
 * 나머지 값은 공백전까지 읽은 값을 히나의 문자로 반환하는 next() 사용
 * <풀이아이디어>
 * 입력받은 문자열을 toCharArray를 사용해 문자배열로 만든 후 첫 인덱스와 끝 인덱스를 출력한다.
 * <출력>
 * 처음과 끝이 알파벳이 붙어 있어함. 
 * char는 내부적으로 정수(유니코드)이므로 문자열 결합을 할려면 앞에 "" 표시해야함.
 * 시행이 끝난 후 엔터를 하므로 println()
 */

import java.util.Scanner;

public class main9086 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 입력
		int T = sc.nextInt(); //테케 
		
		for(int i = 0; i < T ; i++) {
//		String str = sc.nextLine(); 
//		nextInt() 후 엔터 잔존. nextLine은 공백 포함 엔터까지 읽음. 엔터를 받고 메서드 종료됨.
			
		String str = sc.next(); //공백전까지 단어를 읽음. 엔터는 남김.
		char[] line = str.toCharArray();
		System.out.println(""+line[0] + line[line.length - 1 ]);//마지작 인덱스 length - 1
}
		sc.close();

	}
}

/*
 * toCharArray()
 * 사용 형식
 * char[] 배열이름 = 문자열변수.toCharArray();
 * 
 * 배열길이 확인하는 하기 : 배열이름.length
 * 
 * 메서드        반환타입   읽는 범뮈         공백 포함  버퍼 엔터 처리  
 * next()      String  공백 전까지(단어)      x       남김
 * nextLine()  String  엔터까지(한 줄 전쳬)    o       제거
 * nextInt()   int     공백 전까지(숫자)      x       남김
 * 
 * line[0]과 line[line.length-1] 두 char타입은 내부 적으로는 정수형(유니코드값).
 * char + char 는 내부적으로 문자 결합이 아니라 정수 덧셈으로 인식.
 * 문자 결합을 유도하기 위해서 앞에 ""+ 붙여줘야 문자열로 인식함.
 * 그래서 System.out.println("" + char + char) 해야함.
*/
