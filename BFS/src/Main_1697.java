/**
 * 최단거리는 중복을 허용하지않음.
 * 문제를 읽을 때 여러가지 경우의 수를 생각해봐약겠음
 * 조건에 수빈이가 항상 뒤에 있다는 전제가 없었는데, 문제의 예시대로만 생각해서 두에서만 접근한다고 생각함.
 * 그래서 앞에있는 경우의 예외처리를 못해 코드를 제대로 틀린코가됨.
  
 * 메모리 : 20448kb 
 * 시간 140ms
 * 문제 풀이 아이디어
 * 
 */
import java.io.*;
import java.util.*;
public class Main_1697 {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());//수빈이 위치
		int k = Integer.parseInt(st.nextToken());//동생 위치
		
		// 1. N >= K 예외 처리 (수빈이가 동생보다 같거나 뒤에 있을 때)
        // 이 경우 순간이동(2*X)은 불리하므로, X-1 걷기만 필요합니다.
        if (n >= k) {
            System.out.println(n - k);
            return;
        }
		
		
		int[] distance = new int[100001];
		boolean[] visited = new boolean[100001];
		
		//bfs
		Queue<Integer> q = new LinkedList<>();
		q.offer(n);
		visited[n] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			int[] nextPosition = {cur-1, cur+1, cur*2};
			
			for(int next : nextPosition) {
				if(next<0 || next > 100000) continue;
				if(visited[next]) continue;
				
				if(next == k ) {
					System.out.println(distance[cur]+1);
					return;
				}
				
				q.offer(next);
				visited[next] = true;
				
				distance[next] = distance[cur]+1;
				
				
			}
			
		}
		
		
	}

}
