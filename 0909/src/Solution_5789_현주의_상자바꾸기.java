import java.util.Arrays;
import java.util.Scanner;

public class Solution_5789_현주의_상자바꾸기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//표준입력(콘솔)을 위한 입력스트림. 
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		
		for(int t = 1 ; t <= T; t++) {
			int N = sc.nextInt();
			int Q = sc.nextInt();
			
			int[] box = new int[N];
			
			Arrays.fill(box, 0);
			
			for(int q = 1 ; q <= Q ; q++)	{//구간 바꾸기
				
				int i = sc.nextInt()-1;//시작
				int j = sc.nextInt()-1;//끝
				
				Arrays.fill(box, i, j+1, q);
			}
			
			sb.append("#").append(t).append(" ");
			for(int a : box) {
				sb.append(a).append(" ");
			}
			
			sb.append("\n");
		}
		System.out.println(sb);
		sc.close();
	}

}
