import java.util.*;
import java.io.*;

public class Main_10811_arr {
	
	public static void main(String[] args)throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 바구니 수
		int M = sc.nextInt(); // 연산 수
		
		int[] basket = new int[N]; //바구니를 담을 container
		
		for(int i = 0 ; i < N ;i++) {//초기값, 1~N번 	바구니
			basket[i] = i+1;
		}
		
		while(M-- > 0) {
			int s = sc.nextInt()-1; //시작 구간
			int e = sc.nextInt()-1; // 끝 구간
			
			int temp = 0;
			while(s < e) {
				temp = basket[s];
				basket[s] = basket[e];
				basket[e] = temp;
				
				s++;
				e--;
		
			}
		}
		
		for(int a : basket) {
			System.out.print(a+" ");
			
		}
	}

}
