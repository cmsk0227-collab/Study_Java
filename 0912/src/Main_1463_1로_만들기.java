import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1463_1로_만들기 {
	static int[] memo;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력으로 주어진 정수 (1로 만들 대상)
		int n = Integer.parseInt(br.readLine());
		
		//각 정수가 1이 되기 위해 필요한 최소 연산 수 기록
		memo = new int[n+1];
		
//		Arrays.fill(memo, -1); -> 배열이 선언되면 자동으로 0 초기화되기 때문에 굳이 작성할 필요 없음
//		memo[1] = 0;
		
		// DP 주요 특징 -> 모든 경우의 최소 연산 횟수를 미리 배열에 저장
		// -> 필요한 값을 꺼내 쓸 때 O(n) 시간에 해결 가능

		for(int i = 2 ; i <= n ; i++) {
			// 항상 -1 연산은 가능하므로 기본값으로 설정
			memo[i] =  memo[i-1] + 1;
			//2의 배수만 계산
			if(i%2 == 0) {
				memo[i] = Math.min(memo[i], memo[i/2]+1);
			}
			//3의 배수만 계산
			if(i%3 == 0) {
				memo[i] = Math.min(memo[i], memo[i/3]+1);
			}
		}
		
		System.out.println(memo[n]);
		br.close();
	}
}
