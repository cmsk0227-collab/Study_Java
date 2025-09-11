import java.util.*;
/*
 *sublist(i, j) 일 때,
 * j는 포함하지 않는다. 고로, j범위까지 포함하길 바란다면 j+1로 작성해야한다.
 */

public class Main_10811 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i = 1; i<= N; i++) {
			list.add(i);
		}
	
		
		while(M-->0) {
			//인덱스가 0부터 시작하므로 -1.
			int i = sc.nextInt()-1;
			int j = sc.nextInt()-1;
			
			Collections.reverse(list.subList(i, j+1));
	
		}
		
		for(int i = 0; i < N ; i++) {
			if(i == N-1) {
				System.out.print(list.get(i));
				break;
			}
			System.out.print(list.get(i)+" ");
		}
		sc.close();
	}

}
