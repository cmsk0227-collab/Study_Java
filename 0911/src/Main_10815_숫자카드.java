import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/*
 * 문제난이도(체감난이도): 실버5(쉬움)
 * 풀이 아이디어  : set을 활용해 중복여부를 확인. 겹치면 1, 아니면 0 출력.
 * 알고리즘 아이디어
 * 1. 입력량이 많으므로 br+st+sb 사용.
 * 
 * 
 * Scanner를 사용하면 시간초과 나는 이유.
 * 입력이 최대 N+M = 1,000,000개 정수 → Scanner는 정규식 파싱이라 매우 느림
 */

public class Main_10815_숫자카드 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		HashSet<Integer> card = new HashSet<>();
		
		int N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		while(N-- > 0) {
			int a = Integer.parseInt(st.nextToken());
			card.add(a);
		}
		
		int M  = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		while(M-- > 0) {
			int num = Integer.parseInt(st.nextToken());
			boolean res = card.contains(num);
			sb.append(res? "1" : "0").append(" ");
		}
		System.out.println(sb);
	}

}
