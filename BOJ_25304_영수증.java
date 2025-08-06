/*
문제: 백준 25304
난이도: 브론즈4
메모리: 17780KB
시간: 176ms
문제아이디어
1. N번 a와 b 입력을 받고 그 값을 곱해야함. for문 사용.
2. (영수증 충액 == 실제 계산한 총액) 함. for문이 반복할 때마다 a,b,total 값은 갱신되므로 값을 누적할 변수 sum 선언. 
또, 출력할 때 if문에서도 사용해야하므로 메인메서드 안에서 선언해야함.
3. 반복이 끝난 후 일치하면 yes, 불일치하면 No해야하므로 if문 사용.


import java.util.*;


public class main_2580 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int X = sc.nextInt(); // 영수증 상 총금액
		int N = sc.nextInt();//영수증 상 물건 종류
		int sum = 0;//for문 바깥에 선언해야함. 안에 있으면 sum 총액 x. 마지막 a*b만 담김.
		for(int i = 1; i <= N ; i++) {
			int a = sc.nextInt();//개당 가격
			int b = sc.nextInt();//물건 개수
			int total = a*b;
			sum +=total;
		}
		if(X == sum) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}sc.close();
	}

}
