package com.ssafy.DP;

import java.util.Arrays;

/*
  메모이제이션 배열 초기화
	Arrays.fill(memo, -1) 로 전부 -1 세팅
	memo[0] = 0, memo[1] = 1 은 직접 지정
재귀 호출 필수
	memo[n] = fibo(n-1) + fibo(n-2)
	단순히 memo[n-1] + memo[n-2] 하면 아직 계산되지 않은 값(-1)이 들어올 수 있음
시간 복잡도
	일반 재귀: O(2^n) (중복 호출 많음)
	메모이제이션: O(n) (한 번씩만 계산)
 */

public class Fibonacci_DP{
	static int[] memo; //중복 계산을 막기 위해 이전 값을 저장하기 위한 배열
	
	//메모이제이션을 적용한 피보나치 메서드
	public static int fibo(int n) {
		//계산이 되지 않은 경우
		if(memo[n] == -1) {
			//피보나치 로직; 메모리 = 재귀함수(함수 + 함수)
			memo[n] = fibo(n-1) + fibo(n-2);
		}
		return memo[n];//계산 끝난 값이면 바로 호출, 아니면 계산 한 후 값 반환
	}
	
	
	public static void main(String[] args) {
		int n = 10;//원하는 피보나치 수
		
		//배열 할당 후 모두 -1 초기화. 
		//여기서 -1 은 계산되지않은 값을 나타내는 값으로 다른 값도 가능.
		memo = new int[n+1];
		Arrays.fill(memo, -1);
		
		//피보나치는 초기값(0항, 1항)를 메모리에 저장
		memo[0] = 0;
		memo[1] = 1;
		
		System.out.println("Fibonacci(" + n + ") = " + fibo(n));
	
}
}
