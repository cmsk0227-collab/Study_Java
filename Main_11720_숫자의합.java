import java.util.Scanner;

/*
 * 풀이 아이디어
 * 문자열을 char 배열에 담는다. 
 * char[] 요소를 하나하나 합해 총합을 구한다.
 * char를 숫자로 바꿀 때 Character.getNumbericValue()를 사용해야한다.
 * int(byte) num으로 바로 담으면 아스키코드 출력하는 것을 주의.
 */
public class Main_11720_숫자의합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();//숫자의 갯수
		char[] line = sc.next().toCharArray();//문자열 만들기.
		
		int sum = 0;
		for(int i=0; i< N; i++) {
			sum += Character.getNumericValue(line[i]);//char => 숫자
		}
		
		System.out.println(sum);
	sc.close();}

}
