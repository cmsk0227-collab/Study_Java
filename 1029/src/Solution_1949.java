import java.util.*;
import java.io.*;

public class Solution_1949 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, k, max;
    static int[][] mountain;
    static boolean visited; // "공사 1회 사용 여부"로 사용

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            mountain = new int[n][n];

            int high_height = Integer.MIN_VALUE;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    mountain[i][j] = Integer.parseInt(st.nextToken());
                    high_height = Math.max(high_height, mountain[i][j]);
                }
            }

            max = 0;

            // 최고 높이에서 시작
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    if (mountain[r][c] == high_height) {
                        visited = false;
                        dfs(r, c, 1);
                    }
                }
            }

            System.out.println("#" + t + " " + max);
        }
    }

    private static void dfs(int r, int c, int len) {
        max = Math.max(max, len);

        for (int i = 0; i < 4; i++) {
            int nr = r + dy[i];
            int nc = c + dx[i];
            if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;

            // 더 낮은 곳
            if (mountain[nr][nc] < mountain[r][c]) {
                dfs(nr, nc, len + 1);
            } 
            // 깎을 수 있는 곳 (아직 안 깎았고, 깎으면 이동 가능)
            else if (!visited && mountain[nr][nc] - k < mountain[r][c]) {
                int original = mountain[nr][nc];
                visited = true; // 공사 시작

                for (int cut = 1; cut <= k; cut++) {
                    mountain[nr][nc] = original - cut;
                    if (mountain[nr][nc] < mountain[r][c]) {
                        dfs(nr, nc, len + 1);
                    }
                }

                // 복원 및 공사 해제
                mountain[nr][nc] = original;
                visited = false;
            }
        }
    }
}
