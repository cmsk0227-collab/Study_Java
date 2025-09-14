import java.util.*;
import java.io.*;

public class Main_4485 {
	static int n; //한변의 길이
	static int[][] map; //map 구현
	static int[][] dist; // 최단 거리
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = 1;//반복 횟수 기록. 출력용
		
		while(true) {//반복횟수 명시 x -> 툭정 조건에 종료하도록 설계
			n = Integer.parseInt(br.readLine());
			if(n==0) break; //n=0이면 arr 존재 x
			map = new int[n][n]; 
			dist = new int[n][n];//다익스트라는 시작점부터 모든 노드 간의 최소 거리를 구하는 알고리즘이므로 각 노드의 최단 거리를 다 저장해야하므로 map과 동일한 크기의 2차배열 

			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());//가중치 입력
					dist[i][j] = Integer.MAX_VALUE;//초기화
				}
			}
			daji();
			sb.append("Problem ").append(t).append(": ").append(dist[n-1][n-1]).append("\n");
			//도착지(n-1, n-1)까지의 최단 거리 = dist[n-1][n-1]
			t ++ ;//반복이 끝날 때마다 +1 => 몇번째 테케인지 알 수 있음.
		}
		System.out.println(sb);
	}
	public static void daji() {
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(0, 0, map[0][0]));//시작점을 우선순위 큐에 넣기.
		dist[0][0] = map[0][0]; // 가중치
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		while(!q.isEmpty()) {
			Node now = q.poll();//x, y, cost. comparble -> 가중치가 작은 값이 먼저 나옴.
			int x = now.x;//현 위치의 x
			int y= now.y; //현 위치의 y
			
			for(int i=0;i<4;i++) {//상 -> 하 -> 좌 -> 우 탐색해 시작점에서 각 위치의 최단거리를 찾는 코드
				int nowx = x+dx[i]; //탐색하는 위치의 x 좌표
				int nowy = y+dy[i]; //탐색하는 위치의 y 좌표
				if(0>nowx||0>nowy||n<=nowx||n<=nowy) continue; //map 바깥으로 안 나가게 경계검사
				/*
				 * dist[x][y] -> 시작점에서 현 위치까지의 최단 거리
				 * map[nowx][nowy] -> 현 위치에서  현재 탐색 중인 위치까지의 거리
				 * dist[nowx][nowy] -> 이제까지 찾은 시작 위치에서 현재 탐색 중인 위치까지의 최단거리 값
				 */
				if(dist[x][y]+map[nowx][nowy]<dist[nowx][nowy]) {
					dist[nowx][nowy] = dist[x][y]+map[nowx][nowy];
					q.add(new Node(nowx, nowy, dist[nowx][nowy]));
				}
			}
		}
	}
}
class Node implements Comparable<Node>{
	int x, y, cost;

	
	public Node(int x, int y, int cost) {
	    this.x = x;
	    this.y = y;
	    this.cost = cost;
	}



	//Integer와 달리 노드 클래스는 정렬기준을 알 수 없음. 그렇기에 자체적으로 오름차순 정렬 기준으로 만들어줘야힘
	@Override
	public int compareTo(Node o) {//우선순위 q에서 가중치가 작은 값을 나오도록 해줌.
		return this.cost-o.cost;
	}
	
	
}
