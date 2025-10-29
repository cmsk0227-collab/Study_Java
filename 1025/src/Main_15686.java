import java.io.*;
import java.util.*;
/*
 * 문제난이도 어려움
 * 메모리 : 15632kb
 * 시간 : 196ms
 * 알고리즘 : 조합+ 브루투포스
 * 풀이 아이디어
 * 1. m개의 치킨집을 선택하는 모든 경우를 찾는다. = 조합
 * 2. 모든 '도시의 최단치킨 거리'를 구한다.
 * 	(1)집 하나와 모든 치킨집과의 거리를 구해 그 최솟값(=치킨거리)을 구한다
 * 	(2)구한 최솟값은 total(도시 최단거리)에 합한다
 * 	(3)나머지 집에서도 위 과정을 반복한다
 * 	(4)반복이 끝나면 현 조합의 도시 최단거리가 나온다.
 * 3. 이전 조합의 도시 최단거리와 현재 조합의 도시 최단거리를 
 *    게속비교해 최솟값을 찾은 후 해당 값을 출력한다 
 *    
 *    주의!
 *    도시 치킨 거리 = 모든 집의 치킨거리의 합
 *    치킨집 기준으로 구하면 모든 집이 아닌 일부(치킨집 수)만 포함됨.
 *    그러므로 집 기준으로 도시 치킨 거리를 구해야함.
*/

public class Main_15686 {
	static int n , m;//도시 크기(n*n), 선택할 치킨집 수
	static ArrayList<int[]> houses = new ArrayList<>();//집 좌표를 저장할 리스트. 
	static ArrayList<int[]> chickens = new ArrayList<>();//치킨 집 좌표 저장할 리스트
//	좌표 저장을 위해 배열이 아닌 리스트를 선택한 이유
	//1. 집 수, 선택할 치킨집 수가 입력값에 따라 변동.
	//2. 1차원 배열을 제네릭으로 받아 좌표인 r,c,를 한쌍으로 저장하고 꺼낸기 편해서
	static boolean[] selected;//선택한 치킨집(좌표)과 아닌 곳을 구분하기 위한 배열. 거리 계산 시 이용.
	static int min;//도시의 최단거리를 담을 변수 = 정답
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());	
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		min = Integer.MAX_VALUE;//기징 큰 값이 들어와야 어떤 값도 최솟값으로 갱신될 수 있음.
		
		//집, 치킨집의 좌표를 저장하는 구문
		//n*n 형태이므로 이중 for문 모두 n개 조회 
		for(int r = 0; r < n ; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < n ; c++) {
				int a = Integer.parseInt(st.nextToken());
				//구현 못했던 부분!
				if(a == 1) houses.add(new int[] {r,c});// r -> [0], c->[1]
				if(a == 2) chickens.add(new int[] {r,c});
			}
		}
		
		//선택된 치킨집 = true, 아닌 집은 = false 로 표기하기 때문에 배열의 길이는 치킨집 수
		selected = new boolean[chickens.size()];
		
		//m개의 치킨집 선택(조합)
		selectChickens(0,0);
		
		//출력
		System.out.println(min);
		
	}
	
	//M개의 치킨집 선택
	
	/**
	 * @param idx : 현재 조회 중인 치킨집의 인덱스
	 * @param cnt : 선텍된 치킨집 수 
	 */
	
	private static void selectChickens(int idx, int cnt) {
		//M개 선택 완료 -> 도시의 치킨 거리 계산
		if(cnt == m) {//치킨집 m개 선택하면
			int cityDistance = calcCityDistance();//결정된 조합의 도시의 치킨 거리 구하기
			min = Math.min(min, cityDistance);//최솟값찾기
			return;
		}
		
		//범위 초과 = 더 이상 선택할 치킨집x
		if(idx == chickens.size()) return;
		
		//재귀
		//현재 치킨집 선택
		selected[idx] = true;
		selectChickens(idx+1, cnt+1);
		
//		현재 치킨집 선택x
		selected[idx] = false;
		selectChickens(idx+1, cnt);
		
	}
	
	//선택된 치킨집들로 도시의 치킨 거리 계산
	//1. 각 집에서 치킨거리를 구한다
	//2. 구할 때마 치킨거리를 합해 도시의 치킨를 구한다
	private static int calcCityDistance() {
		int totalDistance = 0;//도시치킨거리. 변수 초기화
		
		//각 집마다 
		for(int[] house : houses) {//house : 집 하나의 좌표
			int minDistance = Integer.MAX_VALUE;//한 집의 치킨거리. 최솟값 => MAx_VALE 초기화
			
			//치킨거리 구하기 - 한 집에서 모든 선택된 치킨집까지의 거리 중 최솟값ㄹ
			for(int i = 0; i < chickens.size(); i++) {
				if(!selected[i]) continue;//선택되지 않은 값은 넘기기
				
				int[] chicken = chickens.get(i);//선택된 치킨집의 좌표
				
				//거리계산 |r1-r2| + |c1-c2|
				int dist = Math.abs(house[0]-chicken[0]) 
						+ Math.abs(house[1]-chicken[1]);
				minDistance = Math.min(minDistance, dist);//최솟값 갱신
			}
			
			//도시의 치킨거치 = 모든 집의 치킨거리의 합.
			totalDistance += minDistance;
		}
		
		return totalDistance;
		
	}
	
}
