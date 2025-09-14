import java.util.*;
import java.io.*;

public class Main_1744_re {
	static int ans = 0;
	static PriorityQueue<Integer> plus = new PriorityQueue<Integer>(Collections.reverseOrder());//양수는 내림차순 정렬
	static PriorityQueue<Integer> minus = new PriorityQueue<Integer>();//음수는 오름차순 정렬
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N ; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num > 0) {//내림차순 정렬하는 우선순위큐에 양수 입력
				plus.offer(num);
			}else {//오름차순 정렬하는 우선순위 큐에 0, 음수 입력
				minus.offer(num);
			}
		}
			//양수 - 큰값끼리 *. 마지막에 홀로 남은 수는 +
			while(!plus.isEmpty()) {
				int cur = plus.poll();
				if(plus.isEmpty()) {
					ans += cur;
					break;
				}
				if(cur == 1 || plus.peek() == 1) {
					ans += cur + plus.poll();
					continue;
				}
							
				ans += cur*plus.poll();
				
			}
			
			while(!minus.isEmpty()) {
				int cur = minus.poll();
				if(minus.isEmpty()) {
					ans += cur;
					break;
				}
				ans += cur*minus.poll();
			}
			
			System.out.println(ans);

	}
	

}
