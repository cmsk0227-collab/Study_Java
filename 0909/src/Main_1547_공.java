import java.util.Scanner;

public class Main_1547_공 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		int ball = 1;
		
		while(M-- > 0) {
			int cupX = sc.nextInt(); //선택한 컵의 번호 
			int cupY = sc.nextInt(); //선택한 컵의 번호
			
			if(ball == cupX) ball = cupY;
			else if(ball == cupY) ball = cupX;
//			System.out.println(ball);
		}
		
		System.out.println(ball);
		sc.close();
	}

}
