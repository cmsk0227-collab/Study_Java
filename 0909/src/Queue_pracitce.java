import java.util.*;

public class Queue_pracitce {
	
	public static void main(String[] args) {
		//큐 선언
		Queue<Integer> q = new LinkedList<>(); //int형 queue 선언, linkedlist 이용
//		Queue<String> q1 = new LinkedList<>(); //String형 queue 선언, linkedList 사용
		
		q.add(1); // q에 1 추가
		q.add(2); // q에 2 추가
		q.add(3);//  q에 3 추가 q {1,2,3}
		
		System.out.println(q);
		
	}
}
