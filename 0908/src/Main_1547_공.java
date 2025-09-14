
import java.util.*;
/*
 * 잘못된 풀이 : 문제 오독 - 공의 위치가 고정되었다고 생각함. 공은 담겨있는 컵과 함께 이동.
 * 풀이 아이디어
 * :문제에서 구하고자 하는 답 :공이 담긴 컵의 위치.
 * 1. 테스트케이스만큼 전체 코드를 반복
 * 2. 컵의 갯수, 공 위치, 교환 횟수를 입력받음
 * 3. 교환 횟수만큼 컵 위치를 바꾼다.
 *  이때, 구하자고 하는 값이 공이 담겨진 컵의 위치이므로 공의 이동 변화만 유념
 *  4.
 *   A == ball, B와 자리를 바꾸게 되므로 ball = B
 *   B == ball, A와 자리를 바꾸게 되므로 ball = A
 *  5.
 *  교환을 끝난 ball의 위치를 출력.
 *  System.out.println("#" + t + " " + ball);
 */

public class Main_1547_공 {
	
 public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in); // 입력 스트림 생성
        
        int T = sc.nextInt();// 테케 입력
        
        for(int t = 1; t <= T ; t++) {  // 테케 1 부터 
        	int N = sc.nextInt(); // 컵의 갯수
            int ball = sc.nextInt();; //공 위치 
            int k = sc.nextInt();; //컵 교환 횟수
            
            for(int i = 1; i <= k ; i++) { // 컵의 교환 횟수 만큼 반복
                int A = sc.nextInt(); // 교환할 컵의 위치 A - 인덱스
                int B = sc.nextInt(); // 교환할 컵의 위치 B - 인덱스
                
                if (A == ball) { //종이컵의 위치 - 공의 인덱스 = 컵의 인덱스
                    ball = B;
                } else if(B == ball) {   ///@@@ else 추가
                    ball = A;
                }
            }
            // tc 끝날때마다 결과 출력 : #1 공이있는컵의위치
            System.out.println("#" + t + " " + ball);
        }
    sc.close();}
}


//# input
//3       
//3 2 3
//1 2
//2 1
//1 2
//5 3 6
//1 2
//1 3
//1 4
//1 5
//2 3
//3 4
//3 3 4
//1 3
//3 2
//3 1
//2 3
//
//# output
//#1 1
//#2 3
//#3 2