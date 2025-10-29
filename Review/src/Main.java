import java.util.*;
import java.io.*;

public class Main {
	static int n, m;
	static int min = Integer.MAX_VALUE;
	static boolean[] selected;
	static ArrayList<int[]>houses = new ArrayList<>();
	static ArrayList<int[]>stores = new ArrayList<>();
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());//도시 크기
		m = Integer.parseInt(st.nextToken());//선택할 가게수
		
		//집,가게의 좌표 입력
		for(int r = 1; r <= n; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 1; c <= n ; c++) {
				int val = Integer.parseInt(st.nextToken());
				if(val == 1) houses.add(new int[] {r,c});//집 좌표
				if(val == 2) stores.add(new int[] {r,c});//가게 좌표
			}
		}
		
		//조합
		selected = new boolean[stores.size()];
		selectStore(0,0);
		
		//출력
		System.out.println(min);
		
	}

	/**
	 * @param idx : 현재 확인중인 가게의 인덱스 
	 * @param cnt : 지금까지 선택한 가게수
	 */
	private static void selectStore(int idx, int cnt ) {
		//종료조건
		//선택완료
		if(cnt == m) {
			int cityDistance = cal();
			min = Math.min(min, cityDistance);
			return;
		}
		//범위초과
		if(idx == stores.size()) return;
		//기저조건 - 조합
		//선택
		selected[idx] = true;
		selectStore(idx+1, cnt+1);
		//미선택
		selected[idx] = false;
		selectStore(idx+1, cnt);
	}
	
	//도시 치킨 거리 계산
	private static int cal() {
		int sum = 0;
		//각 집의 최단거리 구하기
		for(int[] h : houses) {
			int minDistnace = Integer.MAX_VALUE;
			for(int i = 0; i < stores.size() ; i++ ) {
				if(!selected[i]) continue;
				int dis = Math.abs(h[0]- stores.get(i)[0]) + Math.abs(h[1]-stores.get(i)[1]);
				minDistnace = Math.min(minDistnace, dis);
			}
			
			sum += minDistnace;
		}
		return sum;
	}
}
