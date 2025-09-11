import java.util.*;
import java.io.*;

public class Main_1744_수묶기 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		PriorityQueue<Integer> plus = new PriorityQueue<Integer>(Collections.reverseOrder());//내림차순 정렬
		PriorityQueue<Integer> minus = new PriorityQueue<>();//오름차순 정렬
		
		int N = Integer.parseInt(br.readLine());//수의 나열
		
		while(N-- > 0) {//숫자 분류
			int num = Integer.parseInt(br.readLine());
			if(num > 0) plus.add(num);
			else minus.add(num);
		}
		
		
		int sum = 0;//최대 합을 담을 변수
		
		while(!plus.isEmpty()) {//321
			int cur = plus.poll();
			
			if(plus.isEmpty()) {//짝이 없는 경우
				sum += cur;
				break;
				}
			
			//1이 포함 된 겨우
			if(cur == 1) sum += cur + plus.poll();
			else if(plus.peek() == 1) sum += cur + plus.poll();
			else {
				sum += cur*plus.poll();
			}
			
		}
		
		while(!minus.isEmpty()) {
			int cur = minus.poll();
			if(minus.isEmpty()) { 
				sum += cur;
				break;
			}
			sum += cur*minus.poll();
		}
		
		bw.write(sum+" ");
		bw.flush();
		bw.close();
		br.close();
	}
}
