import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 생성자 활용 및 람다식을 이용한 오름차순 정렬
 * 그래프를 인접리스토 표현하기
 */

public class Main_1916 {
	static int n, m ;
	static int[][] map;
	static int[][] dist;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine()); //노드
		m = Integer.parseInt(br.readLine()); //간선
		
		//이 부분 구현 x -> 인접리스트 구현 연습 필요
		ArrayList<ArrayList<Node>> graph = new ArrayList<>();
		
		for(int i = 0; i <= n ; i++) { //노드가 1번부터 시작
			graph.add(new ArrayList<>());
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph.get(u).add(new Edge(v, w));
		}
		
		
		//로직
		dist = new int[n+1][n+1]; // i에서 j까지 최단거리
		Arrays.fill(dist, Integer.MAX_VALUE);
		dijk();
		
		
	}
	
	private class Node implements Comparable<Node>{
		int v,w;//시작,도작, 비용
		
		static class Node(int s, int e, int c) {
			this.v = v;
			this.w = w;
		}
		
		
		
	}

}

