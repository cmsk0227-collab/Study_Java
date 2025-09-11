import java.util.Scanner;
/*
 체감 난이도 : 어려움
 문제의도  : 단순한 낙차 계산 문제. 최종 높이 갱신 x(시뮬레이션 x)
 틀린 내 문제 해석 : 박스가 쌓이다보면 박스의 높이가 갱신되는 것까지 고려.(시뮬레이션 관점).
 문제의 의도를 파악하는 방법 -> 예제의 입출력 분석. 예제가 나오는 형식으로 입력 및 출력해야함.
 시간복잡도 : O(N²) <- 중첩루프
 
 [문제  풀이 아이디어]
 :왼쪽에서부터 블록 i를 기준으로 오른쪽 블록들과 비교. 비교한 블록이 현재 블록보다 크거나 같은 블록을 카운팅
 : i번째 블록부터 오른쪽인 이유는 블록이 떨어졌을 때 낙차에는 쌓인 칸만 영향을 주기 때문
 i번째 블록의 낙차 = (오른쪽 칸의 개수) - (i번쩨 블록보다 높거나 같은 블록 개수)
 이 중 최대값 출력
 
 */
public class Solution_16504_Gravity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //표준입력(콘솔 등에서)을 받기 위한 입력스트림. 오류처리를 강제x. 
        //대신 형식이 다르면 InputMismatchException(런타임오류) 발생

        int T = sc.nextInt(); // 테스트 케이스 개수 입력

        for (int t = 1; t <= T; t++) { // T번 반복
            int width = sc.nextInt();      // 블록 개수 입력
            int[] block = new int[width];  // 블록 높이 배열

            for (int i = 0; i < width; i++) {//width번 반복
                block[i] = sc.nextInt();   // 각 블록 높이 입력
            }

            int max_gap = 0; // 이번 케이스의 최대 낙차 초기화

            // 각 블록별로 오른쪽 비교
            for (int i = 0; i < width; i++) {//width 반복
                int same_h = 0;           // i번째 블록보다 크거나 같은 블록 수
                int idx = width - 1 - i;  //i의 오른쪽 칸(공간) 개수

                for (int j = i + 1; j < width; j++) {//현재 블록(i) 다음 블록(i+1)부터 끝까지 조회
                    if (block[i] <= block[j]) {//i번째 블록보다 크거나 같다면
                        same_h++;//+1씩 증가
                    }
                }

            
                int fall = idx - same_h;    // 현재 블록의 낙차 계산
                max_gap = Math.max(max_gap, fall); //현재 낙차 값과 기존의 낙차의 최댓값 비교 후 큰 값으로 갱신.
            }

            // 케이스별 결과 출력
            System.out.println("#" + t + " " + max_gap);
        }

        sc.close();//입력 스트림 자원 해제
    }
}

