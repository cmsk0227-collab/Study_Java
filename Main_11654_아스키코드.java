import java.util.Scanner;

public class Main_11654_아스키코드 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		byte num = (byte) sc.nextLine().charAt(0);
		// String => char => 문자의 숫자 데이터 : 아스키코드
		// nextLine() : String(=문자열)
		// charAt() : char(단어)
		// (byte) : 단어 -> 숫자 : 아스키코드(문자의 숫자 데이터)
		
		System.out.println(num);
		
		
		sc.close();}

}
