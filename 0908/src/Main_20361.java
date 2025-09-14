import java.util.*;

public class Main_20361 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();//컵 갯수
		int x = sc.nextInt(); //공의 위치
		int k = sc.nextInt(); //컵 자리바꾸기 횟수
		
		while(k-- > 0){
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			if(x == A) {
				x = B;
			}else if(x == B) {
				x = A;
			}
		}
		System.out.println(x);
		
	}

}
