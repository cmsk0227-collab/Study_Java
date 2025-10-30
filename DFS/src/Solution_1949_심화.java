import java.util.*;
import java.io.*;

public class Solution_1949_심화 {
//	4방 탐색
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
//    BFS
    static int n, k, max;
    static int[][] map;
    static boolean[][] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());//테케
        
        //테케 만큼 실행하기 위한 for문 
        for(int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());//map 길이
            k = Integer.parseInt(st.nextToken());//최대로 깎을 수 있는 높이
            
//          맵 구현
            map = new int[n][n];//배열 생성
            visited = new boolean[n][n];//방문배열 구현
            int maxHeight = 0;//현재 맵에서 가장 높은 산의 높이
            
//          각 산의 높이 입력 + 맵 내 최대 높이 찾기
            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    maxHeight = Math.max(maxHeight, map[i][j]);
                }
            }
            
            max = 0;//가장 긴 등산로 길이
//            가장 높은 산에서 부터 등산로를 만듬
//            우선 가장 높은 산을 찾기 위해 map을 한칸 한 칸 조회
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(map[i][j] == maxHeight) {//가장 높은 산을 찾으면
                        visited[i][j] = true;//방문 체크
                        dfs(i, j, 1, false);//방문 - dfs 시작. 끝까지 간 후 최종적으로 이 구문으로 돌아옴
                        visited[i][j] = false;//탐색을 끝냈으므로 다른 산에서 등산로를 만들 때 이 칸을 이용할 수 있도록 방문 해제
                    }
                }
            }
            //출력 - 가장 긴 등산로 길이
            System.out.println("#" + t + " " + max);
        }
    }
    
    /**
     * 
     * @param x : 현재 탐색하는 산의 행
     * @param y : 현재 탐색하는 산의 열
     * @param len : 현재까지 연결된 등산로의 길이
     * @param used: 산을 깎은 여부; 깎으면 true, 아니면 false
     */
    
    static void dfs(int x, int y, int len, boolean used) {
        max = Math.max(max, len);//가장 긴 등산로 길이 찾기
//      사방탐색
        for(int d = 0; d < 4; d++) {
//        	다음에 탐색할 산의 좌표
            int nx = x + dx[d]; 
            int ny = y + dy[d];
//            맵 외부이거나 방문한 곳이면 가지 않는다
            if(nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny]) continue;
            
//            다음 산 높이 < 현재 산 높이 -> 등산로 연결 가능
            if(map[nx][ny] < map[x][y]) {
//            	선택
                visited[nx][ny] = true;
                dfs(nx, ny, len + 1, used);
//               미선택
                visited[nx][ny] = false;
            } 
//            깎아야지 등산로 연결이 가능하다면
            else if(!used && map[nx][ny] - k < map[x][y]) {
                int origin = map[nx][ny];//깎기 전 높이 저장
//                다음 산의 높이가 이전산의 높이보다 -1이어야 가장 길게 갈 수 있음
//                깎은 높이로 다음에 연결할 등산로를 탐색해야하므로 다음 산의 높이를 -1한 값으로 변경
                map[nx][ny] = map[x][y] - 1;
                //방문
                visited[nx][ny] = true;
                dfs(nx, ny, len + 1, true);
                //미방문
                visited[nx][ny] = false;
//                미방문을 할 경우, 산의 높이는 그대로이니 원상복구
                map[nx][ny] = origin;
            }
        }
    }
}