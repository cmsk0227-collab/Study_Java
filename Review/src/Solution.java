import java.util.*;
import java.io.*;
import java.security.PrivateKey;

public class Solution {
	static int n, height, min;
	static int[] cm;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T ; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			height = Integer.parseInt(st.nextToken());
			cm = new int[n];
			visited = new boolean[n];
			min = Integer.MAX_VALUE;
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				cm[i] = Integer.parseInt(st.nextToken());
			}
			
			subset(0,0);
			
			System.out.println("#"+t+" "+(min-height));
		}
		
			
	}
	
	private static void subset(int idx, int sum) {
		if(sum >= min) return;
		if(idx == n) {
			if(sum >= height) {
				min = Math.min(min, sum);
				return;
			}
			return;
		}
		
		//재귀
		visited[idx] =true;
		subset(idx+1, sum+cm[idx]);
		
		visited[idx] = false;
		subset(idx+1, sum);
		
	}

}
