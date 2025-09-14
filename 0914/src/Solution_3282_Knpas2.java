import java.util.*;
import java.io.*;

public class Solution_3282_Knpas2{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1 ; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 물건 게수
			int w  = Integer.parseInt(st.nextToken()); // 가방 용량
			
			int[][] arr = new int[n+1][2];
			
			for(int i = 1; i<=n ; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			int[][] dp = new int[n+1][w+1];
			
			for(int i = 0 ; i <= w ; i++) dp[0][i] = 0;
			for(int i = 0 ; i <= n ; i++) dp[i][0] = 0;
			
			for(int i = 1; i <= n ; i++) {
				int v = arr[i][0], c = arr[i][1];
				for(int j = 1; j <= w ; j++) {
					if( j < v ) dp[i][j] = dp[i-1][j];
					else dp[i][j] = Math.max(dp[i-1][j], c + dp[i-1][j - v]);
				}
			}
			System.out.println("#"+t+" "+dp[n][w]);
		}
	
	}

}
