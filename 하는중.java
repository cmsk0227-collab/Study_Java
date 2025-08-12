package com.main;
import java.util.*;
import java.io.*;

/*
 *문제필이 아이디어
 *구현 로직(어려움)
	1. 연산자 개수 => 연산자로 치환
	2. 계산 수식 만들기. 
	3. 수식 결과를 비교해 최댓값 최솟값 찾기.
	4. 구한 뒤 차이를 출력
 * 배운점
 * 1. 사용자 지정 메서드 쓰면 공통 변수는 static으로 선언해야함. 번거로워.
 * 2. 결과값이 음수도 나올 수 있으면 min, max 초기화할 때 MAX_VALUE, MIN_VALUE 사용.
 */
ppublic class sw_4008_숫자만들기 {

    static int N;           // 숫자판에 입력된 숫자의 개수
    static int[] cul;       // 연산자 개수 {+, -, *, /}
    static int[] num;       // 수식에 들어가는 숫자들
    static int max, min;    // 최댓값 / 최솟값

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));// 한줄 입력 받는 클래스 호출하기 위해 객체 생성
        StringBuilder sb = new StringBuilder();//한번에 출력
        
        int T = Integer.parseInt(bf.readLine()); // 총 테스트 횟수

        for(int t = 1; t <= T ; t++) {
            N = Integer.parseInt(bf.readLine()); // 숫자판에 입력된 숫자의 개수

            cul = new int[4]; // 연산자의 종류는 총 4개라 4칸만 필요
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int i = 0; i < 4 ; i++) {// 배열에 연산자 개수 입력
                cul[i] = Integer.parseInt(st.nextToken());
            }

          
            st = new StringTokenizer(bf.readLine());
            num = new int[N];//N개의 숫자를 담을 배열
            for(int i = 0 ; i < N ; i++) {//N개의 숫자이니 N번 입력받기
                num[i] = Integer.parseInt(st.nextToken()); 
            }

            // 최댓값/최솟값 초기화
            max = Integer.MIN_VALUE; // 기준점이니 초기화값은 가장 작은 값
            min = Integer.MAX_VALUE; // 기준점이니 초기화값은 가장 큰 값
            
            // DFS 시작 (첫 숫자부터 시작)
            dfs(0, num[0]);

            // 출력
            sb.append("#").append(t).append(" ").append(max - min).append("\n");
        }
        System.out.println(sb);
    }

    // depth: 사용한 연산자 개수, current: 현재까지 계산 값
    static void dfs(int depth, int current) {//해당 메서드에서만 사용되는 depth, current
        if (depth == N - 1) { // 모든 연산자를 사용했을 때
            max = Math.max(max, current);//최댓값 구하기. 두 수 중 큰 거
            min = Math.min(min, current);//최솟값 구하기. 두 수 중 작은 거
            return;
        }

        // 연산자 4종 시도
        for (int i = 0; i < 4; i++) {
            if (cul[i] > 0) {
                cul[i]--; // 사용
                int next = calc(current, num[depth + 1], i); // 왼->오 순서 계산
                dfs(depth + 1, next);
                cul[i]++; // 복구
            }
        }
    }

    // i: 0:+, 1:-, 2:*, 3:/
    static int calc(int a, int b, int i) {
        if (i == 0) return a + b;
        if (i == 1) return a - b;
        if (i == 2) return a * b;
        // 나눗셈: 문제 조건대로 소수점 이하는 버림 (자바 int 나눗셈은 0쪽으로 버림)
        return a / b;
    }
}
