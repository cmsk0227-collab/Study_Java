import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2579_계단오르기 {
	static int[] score; //각 계단의 점수
	static int[] dp;//n번째 계단까지 오를 떄 얻을 수 있는 총점수 중 최댓값.
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		score = new int[N+1];
		for(int i = 1; i <= N ; i++) {
			score[i] = Integer.parseInt(br.readLine());
		}
		//초기값(=기저조건)
		dp = new int[N+1]; // 테이블
		
		dp[1] = score[1];
		if(N>=2) dp[2] = score[2]+score[1];
		
		//Bottom-up + 테이블링 => 모든값을 배열에 저장
		for(int i = 3; i <= N ; i++) {
			dp[i] = score[i] + Math.max(dp[i-2], score[i-1] +  dp[i-3]);
		}
		System.out.println(dp[N]);
	}
	
}
