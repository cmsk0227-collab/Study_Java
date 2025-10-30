import java.util.*;
import java.io.*;

public class Main_2606 {
//	연결리스트
	static ArrayList<Integer>[] graph;
	static int ans;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int com = Integer.parseInt(br.readLine());//쟁점 수
		int e = Integer.parseInt(br.readLine());//간선 수
		
		graph = new ArrayList[n];
		for(int i = 0 ; i < com ; i++) {
			graph[i] = new ArrayList<>();
		}
		
//		입력
		for(int i = 0; i < e ; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			graph[A].add(B);
			graph[B].add(A);
		}
		
//		로직 - 연결된 사람 탐색
		bfs(1);
		
//		출력
		System.out.println(ans);
	}
	
	private static void bfs(int start) {
		
		
	}
}
