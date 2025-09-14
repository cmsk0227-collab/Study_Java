import java.util.*;
import java.io.*;

/*
 * 몰랐던 내용
 * while(flag)를 이용해 반복문 전체를 탈출 가능하다. 
 */
public class Solution_1225_암호생성기 {
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		Queue<Integer> q = new LinkedList<>();
		
		int Test_case = 10;
		int code = 8;
		while(Test_case -- >0) {
			int t = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			while(code-- > 0) {
				int num = Integer.parseInt(st.nextToken());
				q.offer(num);
			}
			
			boolean flag = true;
			
			while(flag) {
				for(int i = 1; i <= 5; i++) {
					int a = q.poll() - i;
					if(a <= 0) {//숫자가 하나가 0보다 작아지면 0으로 저장하고 멈춤
						q.add(0);
						System.out.println(q);
						flag = false;
					}
					else q.add(a);
				}
			}
			sb.append("#").append(t).append(" ");
			
			System.out.println(q);
		}
		
	}

}
