import java.util.*;
import java.io.*;

public class Main_15650 {
	static int N, M;
	static int[] num;
	static int[] sel;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		num = new int[N];
		for(int i = 0; i < N ; i++) num[i] = i+1;
		
		sel = new int[M];
		
		C(0,0);
		
		
	}
	
	public static void C(int idx, int sidx) {
		//종류파트
		if(sidx == M) {
			for(int s : sel) {
				System.out.print(s+" ");
			}
			System.out.println();
			return;
		}
		else if(idx == N) return;
		//재귀파트
		//선택
		sel[sidx] = num[idx];
		C(idx+1 , sidx+1);
		//미선택
		C(idx+1 , sidx);
	}

}
