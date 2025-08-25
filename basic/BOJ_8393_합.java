/*
사이트: 백준
문제: 8393_합
난이도: 브론즈5 체감난이도
문풀 아이디어
입력값 n -> 정수 -> int형, scanner 사용
1부터 n까지의 합 -> for문 통해 n번까지 i가 1씩 증가하도로고 그 값들을 sum 에 누적 반복이 끝나면 출력.
 */

import java.util.Scanner;

public class Main {//클래스 선언
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int sum = 0;

    for(int i = 1; i <= n; i++){
        sum = sum + i;
    }

   System.out.println(sum);

}
}
