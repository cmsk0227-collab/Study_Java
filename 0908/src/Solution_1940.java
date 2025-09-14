import java.util.*;
import java.io.*;
/*
 * 문제 :가랏! RC카
 * 체감 난이도 : 어려움 ; 문제 이해를 잘못해서 오래 돌아감.
 * 문제풀이 아이디어
 * 1차 시도  : command 다 받은 후에 속도 * N초 = RC카의 이동거리 ; fail => 구간마다 속도가 바뀌는 것.
 * 옳은 접근
 * 1. 거리 = 시간 * 속도
 * 2. command는 1초다  바뀜 = 1초마다 속도가 바뀜 = 1초마다 이동거릭 바뀜  1초 * 
 * 3. 1초 * 변화된 속도 = 1초간의 이동거리. 이것을 누적합하면 된다.
 * 4. command 1이면 +속도,command 0 + 속도 그대로, command -속도 후 거리를 구한 뒤 이동거리에 누적한다.
 */

public class Solution_1940 {

	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		//입력
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <=T ; t++) {
		int distance = 0; //구하고자하는 값 테케 끝난 후 초기화
		int speed = 0; //rc카 기본 속도 0. 테케 하나 끝나면 초기화용
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			int cur = 0;
			int command = Integer.parseInt(st.nextToken());
			switch (command) {
			case 0:
				distance += speed;
				break;
			case 1:
				 cur = Integer.parseInt(st.nextToken());
				speed += cur;
				distance += speed;
				break;
			case 2:
				 cur = Integer.parseInt(st.nextToken());
				if(cur > speed) {
					speed = 0;
					break;
				}
				speed -= cur;
				distance += speed;
				
			}
			
		}
		sb.append("#").append(t).append(" ").append(distance).append("\n");
		}
		
		System.out.println(sb);
		
	}

}
