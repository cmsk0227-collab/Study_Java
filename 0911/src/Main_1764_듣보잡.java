import java.util.*;
import java.io.*;



public class Main_1764_듣보잡 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		TreeSet<String> set = new TreeSet<>();
		TreeSet<String> final_set = new TreeSet<>();
		
		int nl  = Integer.parseInt(st.nextToken()); //듣지 못한 사람 수
		int ns  = Integer.parseInt(st.nextToken()); // 보지 못한 사람 수
		
		while(nl-- > 0) set.add(br.readLine()); 
				
		while(ns-- > 0) {
			String name = br.readLine();
			boolean ans = set.contains(name);
			if(ans) final_set.add(name);
		}
		
		
		int num = final_set.size(); //듣보잡 수
		
		sb.append(num).append("\n");
		
		for(String list : final_set) {
			sb.append(list).append("\n");
			}
		
		System.out.println(sb);
}
}

/*
내 논리
두 번 째 입력값과 일치하지않은 값을 제거하자!
포함되지않은 name(obama)를 찾음
set.remove(obama) -> 오바마를 제거.
하지만, 오바마는 원래 없었죠? 없는 문자를 없애는 거죠? 그대로죠?
그래서 틀린 코드죠!

while(ns-- > 0) {
			String name = br.readLine();
			boolean ans = set.contains(name);
			if(ans == false) set.remove(name);
			System.out.println(set);
		}
 */
