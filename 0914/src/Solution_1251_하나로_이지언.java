import java.io.*;
import java.util.*;
/*
 * SWEA_1251_하나로
 * 체감난이도 : 어려움
 * 풀이 아이디어 : 가중치가 있는 최단 경로 문제 ;  무뱡향 + 연결 + 가중치 그래프 -> prim 알고리즘  
 * 몰랐던 부분
 * 1. 입력된 값에 맞는 자료형 선택. 
 * 
 * 	숫자는 무작정  int형으로 기계적을 선택. 오버플로우가 발생하거나 오차가 발생해 출력값이 다르게 나옴.
 *  범위가 21억을 넘으면 long(정수형), double(실수형)을 사용함.
 * 
 * 2. 타입별  최대상수, 최소 상수, 파싱
 * 
 * 3. 수학적 지식 : 원래 계산식은 Math.round(E*L^2) 후 합산하면 실제값과 차이가 존재. 반올림은 맨 마지막에 하기.
 *
 */

public class Solution_1251_하나로_이지언 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for(int t = 0; t < tc ; t++) {
            int N = Integer.parseInt(br.readLine()); // 섬 개수
            long [] dx = new long[N]; // x 좌표를 담을 배열
            long [] dy = new long[N]; // y 좌표를 담을 배열

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N ; i++) {// 섬의  x좌표 입력
                dx[i] = Long.parseLong(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N ; i++) { // 섬의 y좌표 입력.
                dy[i] = Long.parseLong(st.nextToken());
            }

            /*
              * 파싱
              *  int    -> Integer.parseInt()
              *  long   -> Long.parseLong()
              *  double -> Double.parseDouble()
             */
            
            // 환경부담 세율 E, 세율은 소수점으로 표현되므로 double
            double E = Double.parseDouble(br.readLine());
            
            //환경부담금 = E * L^2(=거리의 제곱)
            //최단거리 -> 최소환경부담금 -> prim 로직.
            long[][] adjMatrix = new long[N][N];
            // 가중치 = 두 섬 사이의 "거리^2"
            // 인접배열은 연결이 되지않으면 0, 연결이 되면 1 or 가중치.
            
            boolean[] visited = new boolean[N];// 방문관리 배열
            long[] minEdge = new long[N];//현재 트리까지의 각 노드별 최소거리. 트리가 갱신될 때마다 하나하나 비교 후 더 작은 값으로 갱신

            //가중치 입력
            for(int i = 0; i < N ; i++) {//간선별 가중치 입력. 해당 배열 안에는 모든 간선의 가중치가 저장.
                for(int j = 0; j < N ; j++) {
                    long ddx = dx[i] - dx[j];
                    long ddy = dy[i] - dy[j];
                    
                    // 거리의 제곱 = L^2
                    adjMatrix[i][j] = ddx*ddx + ddy*ddy;
    
                }
            }

            // 전처리 
            Arrays.fill(minEdge, Long.MAX_VALUE);
            //어떤 값이든 최솟값으로 들어갈 수 있게 무한대를 담음.
            
            /*
             *   최대/최소 상수
             *  int    -> Integer.MAX_VALUE / Integer.MIN_VALUE
             *  long   -> Long.MAX_VALUE    / Long.MIN_VALUE
             *  double -> Double.MAX_VALUE  / Double.MIN_VALUE  // 가장 작은 '양의' 값(음수 아님)
             *  float  -> Float.MAX_VALUE   / Float.MIN_VALUE   // 가장 작은 '양의' 값
             */
            
           
            minEdge[0] = 0; // 시작 정점. 루트값 -> 간선 x -> 거리^2 = 0

            long sumSq = 0; // 선택된 간선들의 "거리^2" 합

            for(int c = 0; c < N ; c++) {  // 비트리 정점 중 간선비용(거리^2)이 최소인 정점 찾기
                long min = Long.MAX_VALUE;//최솟값이니 가장 큰 값을 담어 어떤 수든 최솟값으로 갱신되도록 함.
                int minVertex = -1;//정점번호는 0번부터 시작하니 -1을 담아 어떤 인덱스가 오든 갱신되도록 함.

                for(int i = 0; i < N ; i++) {//트리에 추가할, 거리^2이 가장 작고 트리와 인접한 노드를 찾기
                    if(visited[i]) continue;//트리노드 제외.
                    if(min > minEdge[i]) {
                    	//비트리 노드 중 제일 작은 값
                    	
                        min = minEdge[i];
                        minVertex = i;
                    }
                }
                
              // 연결되지 않으면 조건 성립 x(MAX_VALUE == MAX_VALUE) => if문 실행 x => minVertex == -1
              // 비연결이면 전체 반복문 종료. 왜냐, prim 알고리즘의 기본전제 : 그래프가 무방향, 연결, 가중치 그래프여야함.
              // 해당 문제 같은 경우에는 모든 그래프가 연결되있다고 선언해둬서 굳이 있을 필요 없는 코드.
                if(minVertex == -1) break; 

                //기존 트리에 노드를 추가.
                visited[minVertex] = true;
                sumSq += minEdge[minVertex]; // 거리^2만 누적

                
                for(int i = 0 ; i < N ; i++) {//인접 정점 갱신
                    if(!visited[i] && adjMatrix[minVertex][i] != 0 && minEdge[i] > adjMatrix[minVertex][i]) {
                        minEdge[i] = adjMatrix[minVertex][i];
                    }
                }
            }

            //마지막에만 E를 곱해 반올림
            //내가 가장 많이 헤멘 point
            //원래 계산식은 Math.round(E*L^2) 후 합산.
            //이럴 경우 반올림에 의해 오차가 생길 수 있으므로 반올림은 맨 마지막에 해야한다.
            long distance = Math.round(E * sumSq);
            System.out.println("#"+(t+1)+" "+distance);
        }
    }
}
