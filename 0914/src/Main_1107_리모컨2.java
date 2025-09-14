import java.util.*;
import java.io.*;

public class Main_1107_리모컨2 {
	public static boolean[] isBroken;
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//입력
		int target = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		isBroken = new boolean[10];
		
		//로직
		//숫자 버튼 사용 x
		int minClick = Math.abs(100 - target); //플마로만 이동
		
		//숫자 버튼 사용
		if(m==0) {//고장난 버튼 x
			int cand = Integer.toString(target).length(); //목표 숫자로 가기 위해 숫자버튼을 누른 횟수
			minClick = Math.min(minClick, cand);
			System.out.println(minClick);
			return;
			
		}
		
		st = new StringTokenizer(br.readLine());
		while(m-- > 0) {
			int broken = Integer.parseInt(st.nextToken());
			isBroken[broken] = true;
		}
		
	
		for(int ch = 0 ; ch < 1000000 ; ch++) {
			if(minClick == 0) break;
			if(!isValid(ch)) continue;
			
			int clickCount = Integer.toString(ch).length();
			int cand = clickCount + Math.abs(target - ch);
			
			minClick = Math.min(minClick, cand);
		}
		
		System.out.println(minClick);
	}
				
	static public boolean isValid(int num) {
		if(num == 0) return !isBroken[num];
		//num이 0이 아니라면
		while(num > 0) {
				if(isBroken[num % 10]) return false;
				num /= 10;
			}
			
			return true;
		}

	}
