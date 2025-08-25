package com.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 문제: 백준 2738 행령덧셈
 * 난이도 : 브론즈3. 아주 쉬움
 * 메모리: 15912kb , 시간 156ms
 * 
 * 풀이 아이디어
 *2차원 배열로 행렬 A, B를 저장. 동일한 인덱스 끼리 더한다.
 *행렬의 형태로 출력해야므로 StringBuilder을 이용해 행렬의 형태로 담고 출력.
 *행의 입력이 끝나면 개행문자를 떻어 내려쓴다.
 */

public class Main_2738_행렬덧셈 {
public static void main(String[ ] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	StringBuffer sb = new StringBuffer();
	
	int N = Integer.parseInt(st.nextToken()); //행
	int M = Integer.parseInt(st.nextToken()); //열 
	
	int[][] A = new int[N][M]; //행렬 A
	int[][] B = new int[N][M]; //행렬 B
	
	//행렬A 
	for(int i = 0; i < N; i++) {
		st = new StringTokenizer(br.readLine());
		for(int j =0; j <M; j++) {
			A[i][j] = Integer.parseInt(st.nextToken());
		}
	}
	//행렬 B
	for(int i = 0; i < N; i++) {
		st = new StringTokenizer(br.readLine());
		for(int j =0; j <M; j++) {
			B[i][j] = Integer.parseInt(st.nextToken());
		}
	}
	
	//행렬합
	for(int i = 0; i < N; i++) {
		for(int j=0; j < M ; j++) {
		sb.append(A[i][j]+B[i][j]).append(" ");
	}
		sb.append("\n");
	}
	
	System.out.println(sb);
	
}
}
