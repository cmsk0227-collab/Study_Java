import java.util.Scanner;
/*
 * 난이도 : 어려움
 * 막힌 부분 : 반복문의 조건을 설정 x. hasNextLine() 메서드 몰랐음. 
 * 풀이 아이디어 :  sc.hasNextLine()을 활용해 더 이상 읽을 줄이 없을 때까지 출력을 반복
 * +개념 보충+
 * hasNextLine() nextLine()과 세트
 * 기능 : 입력 스트림(파일, 콘솔, 문자열 등)에 다음 줄(line)이 존재하는 확인
 * 반환값 : boolean; 
 * 읽을 수 있는 줄이 존재-> true. 
 * 더 이상 읽을 줄이 없음 -> false(EOF)
 * 
 * hasNext() next()와 세트
 */

public class Main_11718 {
	public static void main(String[] args){//자바 프로그램 시작 지점(JVM 실행 시작 위치)
		Scanner sc = new Scanner(System.in); 
		//표준 입력(System.in)과 연결된 Scanner 객체 생성
		//표준입력 스트림. 오류처리 강제 x. 잘못된 입력이 들어왔을 경우 런타임오류
		
		while(sc.hasNextLine()) {//입력이 남아 있는 동안 반복
			String str = sc.nextLine();//한 줄 단위로 읽는다(개행 기준으로 끊어 읽음)
			System.out.println(str);//읽은 문자열을 그대로 출력. 자동 줄바꿈
			
		}
		sc.close();//Scanner 자원 해제
}
}