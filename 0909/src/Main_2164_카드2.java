import java.util.*;

public class Main_2164_카드2 {
	/*
	 * 해당 문제에서 자료구조를 queue로 사용한 이유는?
	 */
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		Deque<Integer> q = new ArrayDeque<>();
		
		int N = sc.nextInt();//1~N번 카드
		
		for(int i = 1 ; i <= N ; i++) q.add(i);
		
		
		while(q.size() > 1) {//큐에 하나 남을 때까지 반복
			
			q.poll();//맨 앞에 있는 숫자 제거
			
			int num = q.poll(); //그 다음에 있는 숫자 제거. 이 숫자는 다시 스택에 넣을 것이라서 변수에 담음
			q.add(num);
			}
		//큐 내에 원소가 하나면 출력
		
		System.out.println(q.poll());
		sc.close();
		}
}	

