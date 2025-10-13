import java.util.*;
import java.io.*;

public class Main2563 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] papper = new int[100][100];
	
		int cnt = Integer.parseInt(br.readLine());
		
		while(cnt > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()); //행
			int c = Integer.parseInt(st.nextToken()); //열
			
			for(int i = 0 ; i < 10; i++) {
				for(int j = 0; j < 10 ; j++) {
					papper[r+i][c+j] = 1;
				}
			}
			cnt--;
		}
	
		int sum = 0;
		
		for(int i = 0 ; i < 100 ; i++) {
			for(int j = 0 ; j < 100 ; j++) {
				sum += papper[i][j];
			}
		}
		
		System.out.println(sum);
		
	}

}
