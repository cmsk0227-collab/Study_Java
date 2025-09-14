import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//재귀 + 메모리제이션
public class Main_2579_계단오르기2 {
	static int[] arr;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		arr = new int[n+1];
		for(int i = 1; i <= n ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dp = new int[n+1];
		//초기값
		dp[1] = arr[1];
		if(n>=2) dp[2] = arr[2] + arr[1];
		
		System.out.println(find(n));
	}
	
	static public int find(int n) {//재귀함수
		if (n <= 0) return 0;  //음수인덱스/언더플로우 방지
		if(dp[n] != 0) return dp[n]; //재귀함수
		dp[n] = arr[n] + Math.max(find(n-2), arr[n-1]+find(n-3));
		return dp[n];
	}
}
