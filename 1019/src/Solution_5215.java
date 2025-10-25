import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5215 {
	static int N, L, max; //재료 , 제한 칼로리, 최대값
	static int[] score;
	static int[] kal;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
				
		for(int t = 1; t <= T ; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			score = new int[N];
			kal= new int[N];
			
			for(int i = 0; i < N ; i++) {
				st = new StringTokenizer(br.readLine());
				score[i] = Integer.parseInt(st.nextToken());
				kal[i] = Integer.parseInt(st.nextToken());
			}
			
			max = 0;
			subset(0,0,0);
			
			System.out.println("#"+t+" "+max);
			
		}
		
	}
	
	public static void subset(int idx, int kalSum, int scoreSum) {
		//종료 파트
		if(kalSum > L) return;
		if(idx == N) {
			max = Math.max(max, scoreSum);
			return;
		}
		
		//재귀 파트
		//포함
		subset(idx+1, kalSum+kal[idx], scoreSum+score[idx]);
		//비포함
		subset(idx+1, kalSum, scoreSum);
	}

}
