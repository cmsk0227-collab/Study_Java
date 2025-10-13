import java.util.Scanner;

/*
 * 메모리 : 17608kb 시간: 160ms
 * 풀이아이디어 
 * 단어의 수(행), 철자의 최댓값(열)이 고정되어 있고 가로,세로,위치가 중요하므로
 * 2차원 배열로 입력을 받은 후 열 기준으로 출력한다. 이때 미기입값이존재할 경우 바로 다음 칸을 출력하는 로직을 만든다
 * 
 * 입력,
 * 5행 15열의 2차원 배열을 생성한다. 
 * 단어는 공백없이 입력되므로 sc.next()입력 받은 후 charAt()로 철자를 입력받는다
 * 이때 반환되는 데이터 타입은 char이므로 char[][] 생성해야한다.
 * 
 * 출력,
 * 이중 for문으로 출력하되 안쪽 for문 반복 변수를 열로 두어야한다
 * 공백이 존재할 경우, 바로 해당 반복을 종료하고 다음 반복 실행 => continue 
 * char[]의 초기값 = '\u0000' ='\0'
 * 다른 배열의 초기값
 * int, byte, short, long[] = 0
 * float, double[] = 0.0
 * String[] 등 참조자료형 = null
 * boolean[] = false
 * 
 */
public class Main_10798_이지언 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		//입력
		char [][] word = new char[5][15]; 
		//배열 입력
		for(int i = 0; i < 5 ; i++) {//5번 반환, 인덱스 0 ~4
			String str = sc.next();//string 타입 반환
			for(int j = 0 ; j < str.length(); j++) {//문자열 길이만큼 반환, 인덱스 0 ~ (length-1)
				word[i][j] = str.charAt(j);//0 ~ (length-1) 순으로 철자 입력.
			}
		}
		
		//출력 
		for(int j = 0; j < 15 ; j++) {//열
			for(int i = 0; i < 5 ; i++) {//행
				if(word[i][j] == '\0') continue;//초기값(미기입값)이면 건너뛰기
				System.out.print(word[i][j]);//공백없이 연속으로 출력 <- print
			}
		}
sc.close();
		
	}
}