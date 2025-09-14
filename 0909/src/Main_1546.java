import java.util.*;

public class Main_1546 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //과목 수
		double[] score = new double[N] ;
		double max = Double.MIN_VALUE;
		
		for(int i = 0; i< N; i++) {
			score[i] = sc.nextInt();
			if(score[i] > max) {
				max = score[i];
			}
		}
		double sum = 0;
		for(int i = 0 ; i < N ; i++) {
			double new_score = score[i]*100/max;
			sum = sum + new_score;
		}
		
		
		double avg = sum/N;
		
		System.out.println(avg);
		

		sc.close();
	}
}
