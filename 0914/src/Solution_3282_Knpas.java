import java.util.*;
import java.io.*;

public class Solution_3282_Knpas{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine()); //테케 수
		
		for(int t = 1; t <= tc ; t++) {//t번 순회 - 1
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());//물건의 개수 - 4
			int k = Integer.parseInt(st.nextToken());//가방의 용량 - 5
			
			
			int[][] item = new int[n+1][2];//각 물건의 부피(0), 가치(1)
			for(int i = 1; i <= n ; i ++) {
				st = new StringTokenizer(br.readLine());
				item[i][0] = Integer.parseInt(st.nextToken()); //부피
				item[i][1] = Integer.parseInt(st.nextToken()); //가치
			}
			
			// 물건이 n개 있고 가방의 용량이 k 일 때 최고 가치 
			int[][] dp = new int[n+1][k+1]; // 테이블 행(물건 수 ): 0 ~ n, 얼(가방 용량) : 0  ~ k
			
			
			for(int i = 0; i <= n ; i++) dp[i][0] = 0; // 물건이 0개 일 때 가방의 가치 0
			for(int i = 0; i <= k ; i++) dp[0][i] = 0; // 용량이 0이면 가방의 가치 0
			
			
			//용량도 있고 물건도 있을 떄
			for(int i = 1; i <=n ; i++) {// i -> 물건 번호, w = 각 물건의 용량 
				for(int w  = 1 ; w <= k ; w++) {
					if(w < item[i][0]) {//용량이 커서 담을 수 없다면
						dp[i][w] = dp[i-1][w];
					}
					else {//용량이 크거나 같아 담을 수 있다면 담지않거나 담거나
						dp[i][w] = Math.max(dp[i-1][w], item[i][1]+ dp[i-1][w-item[i][0]]);
						//물건 수 i개이고 용량이 W인 가방에 물건을 담았을 때 최고 가치
					}
				}
			}
			
			System.out.println("#"+t+" "+dp[n][k]);
			
			
		}
		
	}

}
