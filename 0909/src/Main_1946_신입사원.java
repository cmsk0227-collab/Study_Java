import java.util.*;
import java.io.*;

public class Main_1946_신입사원 {
	static int T, N, cnt;
	static int[][] arr;
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		//입력
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			
			arr = new int[N][2]; // 서류 성적, 면접 성적을 담을 컨테이너
			
			for(int i = 0; i < N ; i++) {//입력하기
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken()); //서류
				arr[i][1] = Integer.parseInt(st.nextToken()); //면접
			}
			
			//로직
			Arrays.sort(arr, (a,b) -> Integer.compare(a[0], b[0]));//오름차순 정렬. 등수가 작은 게 먼저
			
			cnt = 1;
			
			int best_rank = arr[0][1]; //윗 등수 중 가장 높은 등수. 현재는 1등의 인터뷰 등수
			
			for(int i = 1; i < N; i++) {
				if(best_rank > arr[i][1]) {
					best_rank = arr[i][1];
					cnt ++;
				}
			}
		//출력
			sb.append(cnt).append("\n");
		}
		
		System.out.println(sb);
	} 

}
