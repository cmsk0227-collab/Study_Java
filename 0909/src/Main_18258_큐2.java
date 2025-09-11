import java.util.*;
import java.io.*;

public class Main_18258_큐2 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Deque<Integer> q = new ArrayDeque<>();
		
		int N = Integer.parseInt(br.readLine());
		
		while(N-- > 0) { // N번 반복
			st = new StringTokenizer(br.readLine());
			String command =st.nextToken();//입력을 string으로 받음. String만 입력을 받은 공백, 개행을 기준으로 토큰화
			
			switch (command) {//한 변수에 대해 여러 개의 조건이 달리면 편의를 위해 switch문 사용 조건이 끝날 때마다 break 필요 없으며 아래 조건문 쭉 실행
			case "push"://command가 push면
				int x = Integer.parseInt(st.nextToken()); //뒤에 들어올 숫자를 입력받는다
				q.offer(x); //그 숫자를 큐에 넣는다
				break;// break가 없으면 fall-thorough 발생해 다음 case가 연쇄 실행하니 break 반드시 표기

			case "pop": //command가 pop이면
				if(q.isEmpty()) sb.append(-1).append("\n"); //큐가 비어있으면 -1 출력
				else{//그렇지 않다면
					sb.append(q.poll()).append("\n");//큐에서 맨 앞에 값을 꺼내고 그 값을 반환 후 출력
				}
				break;//조건문 실행 끝.
			
			case "size" ://command가 size면
				sb.append(q.size()).append("\n"); //큐의 현재 크기를 출력한다
				break;//조건문 실행 끝
				
			case "empty" ://command가 empty면
				if(q.isEmpty()) sb.append(1).append("\n"); //큐가 비어있으면 1을 출력
				else sb.append(0).append("\n");//그렇지않다면 0 을 출력
				break;//조건문 실행 끝
				
			case "front" ://command가 front면
				if(q.isEmpty()) sb.append(-1).append("\n");//큐가 비어있으면 -1 출력
				else sb.append(q.peekFirst()).append("\n");//그렇지않다면 맨 앞에 값이 무엇인지 출력. 이떄, 큐에서 꺼내지않음.
				break;//조건문 실행 끝
				
			case "back" ://command가 back면
				if(q.isEmpty()) sb.append(-1).append("\n");//큐가 비어있으면 -1 출력
				else sb.append(q.peekLast()).append("\n");//그렇지않다면 맨 마지막 값이 무엇인지 출력. 이떄, 큐에서 꺼내지않음.
				break;//조건문 실행 끝
			
			}
			
		}
		System.out.println(sb);
		
	}

}
