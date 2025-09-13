import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1463_정혜원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int x = Integer.parseInt(br.readLine());
        // dp 배열
        // arr[i] => x에서 i까지 가는데 필요한 연산의 "최소 횟수"
        int[] arr = new int[x+1];
        
        // x-1 부터 0까지 탐색 
        for(int i=x-1; i>0; --i) { 
            // 만약 i*3 이 x보다 작다면 (x 부터 시작했기에, x보다 큰 dp는 존재하지 않음. 밑에서 Math.min에 선택되지 않기 위해  MAX_VALUE 삽입)
            // arr[i*3]을 cand1 에 저장
            int cand1 = (3*i > x) ? Integer.MAX_VALUE : arr[3*i];
            
            // 만약 i*2 가 x보다 작다면
            // arr[i*2]를 cand2 에 저장(위와 동일)
            int cand2 = (2*i > x) ? Integer.MAX_VALUE : arr[2*i];
            
            // arr[i*3], arr[i*2] 중 작은 녀석을 arr[i]에 저장함.
            arr[i] = Math.min(cand1, cand2);
            // arr[i*3], arr[i*2] 중 작은 값과 arr[i+1] 중 작은 녀석을 arr[i]에 저장함.
            arr[i] = Math.min(arr[i], arr[i+1]);
            // i*3 혹은 i*2 혹은 i+1 에서 연산을 1회 더 해서 i를 만들었으므로 1을 증가시킴.
            ++arr[i];
        }
        // arr[1] => x에서 1까지 오는데 오는 최소 연산 횟수.
        System.out.print(arr[1]);
    }
}