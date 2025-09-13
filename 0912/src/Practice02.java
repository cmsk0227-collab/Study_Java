import java.util.Arrays;
import java.util.Scanner;
/*
 * 풀이 난이도 : 어려움 (특히 점화식 유도 과정이 까다로움)
 * 
 * 
 * 풀이 아이디어 :
 * 1. 하향식 접근(Top-Down, 재귀+메모이제이션)
 *    - n cm 막대 끝부분에는 오직 3가지 경우만 올 수 있음:
 *        (1) 파랑(1cm) + (n-1)cm 막대를 만드는 경우의 수
 *        (2) 노랑(1cm) + (n-1)cm 막대를 만드는 경우의 수
 *        (3) 빨강(2cm) + (n-2)cm 막대를 만드는 경우의 수
 * 
 *    → 따라서 점화식은 다음과 같음:
 *       f(n) = 2*f(n-1) + f(n-2)
 *       (1cm 색 막대 2가지 × f(n-1) + 2cm 빨강 막대 × f(n-2))
 *
 * 2. 하향식 분해의 의미
 *    - f(n)은 f(n-1), f(n-2)와 같은 더 작은 문제로 계속 쪼개짐.
 *    - 즉, f(n-1)도 다시 f(n-2), f(n-3) … 이런 식으로 내려가다 보면
 *      결국 더 이상 쪼갤 수 없는 **기저 조건(Base Case)**에 도달하게 됨.
 *
 * 3. 기저 조건(Base Case)
 *    - f(1) = 2  (노랑 1cm, 파랑 1cm 두 가지)
 *    - f(2) = 5  (노-노, 노-파, 파-노, 파-파, 빨강 → 총 다섯 가지)
 *    - (선택적으로 f(0)=1 : 길이가 0일 때 막대를 만들 수 있는 "빈 경우" 한 가지)
 * 
 */

public class Practice02 {
	static int[] memo;//계산된 값을 담을 메모리 배열(-> 메모이제이션)
	
	static public int dp(int n) {// n cm인 막대를 만드는 모든 경우의 수 구하는 함수
		if(memo[n] == -1) {//계신되지 않은 값이라면 
			memo[n] = 2*dp(n-1) + dp(n-2);//점화식을 이용해 재귀적으로 계산
		}
		return memo[n]; //이미 계산된 값이라면 바로 반환
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();//입력 : 막대 길이
		memo = new int[n+1];//배열 생성
		//계산되지않았다는 상태를 표시하기 값인 -1로 배열 초기화
		Arrays.fill(memo, -1);
		
		//초기값 설정
		memo[1] = 2;
		memo[2] = 5;
		int res = dp(n);
		System.out.println(res);
	sc.close();}
}
