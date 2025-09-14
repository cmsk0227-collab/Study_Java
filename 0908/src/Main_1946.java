import java.io.*;
import java.util.*;

public class Main_1946 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int  T = Integer.parseInt(br.readLine());
	
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] score = new int[N][2];
			for(int i = 0; i < N ; i++) {
				st = new StringTokenizer(br.readLine());
				score[i][0] = Integer.parseInt(st.nextToken()); //서류 등수
				score[i][1] = Integer.parseInt(st.nextToken()); //면접 등수
			}
			
			Arrays.sort(score, (a, b) -> Integer.compare(a[0], b[0])); //오름차순 정렬
			
			int res = 1; //서류 1등은 무조건 합격. 서류 2등부터는 자신의 모든 윗 순위보다  면접 순위가 낮아야함.
			int best_score = score[0][1];// 2등 -> 마지막 순위로 차례로 비교. 2등은 1등하고만 비교하면 됨.

			for(int i = 1; i < N ; i++) {
				if(best_score > score[i][1]) {
					res ++;
					best_score = score[i][1]; //합격자 면접 최고 순위 갱신. 다음 등수는 이 등수보다 작아야 윗 등수들 보다 면접 등수가 높음.
				//등수가 높으면 그냥 무시	
				}
			}
			sb.append(res).append("\n");
		}
		System.out.println(sb+"");
	}
}
