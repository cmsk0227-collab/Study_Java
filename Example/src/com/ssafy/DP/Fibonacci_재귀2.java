package com.ssafy.DP;


public class Fibonacci_재귀2 {
	public static int fib(int n) {
		if(n <= 1) {// 기저조건 (0항, 1항)
			return n;
		}
		
		return fib(n-1) + fib(n-2); //재귀함수
	}
	
	public static void main(String[] args) {
		
		int n = 10;
		System.out.println("Fibonacci(" + n + ") = " + fib(n));
	
}
}
