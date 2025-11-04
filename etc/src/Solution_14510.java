import java.util.*;
public class Solution_14510 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();//테스트 케이스 수
        
        for(int t = 1; t <= T; t++) {//테케만큼 반복
            int n = sc.nextInt();//나무의 개수
            int[] trees = new int[n];//각 나무의 키를 저장하기 위한 배열
            int maxHeight = 0;//목표하는 나무 높이 (가장 큰 나무 높이)
            
            //나무 높이 입력 및 최대 높이 찾기
            for(int i = 0; i < n; i++) {
                trees[i] = sc.nextInt();
                maxHeight = Math.max(maxHeight, trees[i]);
            }
            
            int odd = 0;  //홀수날 작업 횟수 (1씩 성장)
            int even = 0; //짝수날 작업 횟수 (2씩 성장)
            
            //각 나무가 자라야 할 높이를 1과 2의 조합으로 분해
            for(int tree : trees) {
                int diff = maxHeight - tree; //자라야 할 높이
                even += diff / 2;  //2로 채울 수 있는 횟수
                odd  += diff % 2;  //나머지 1
            }
            
            int ans;//정답을 담는 변수
            
            if (odd > even) {
                //홀수가 더 많은 경우
                //홀-짝-홀-짝-...-홀 패턴으로 배치
                //마지막은 홀수로 끝남
                ans = 2 * odd - 1;
                
            } else if (odd == even) {
                //홀수와 짝수가 같은 경우
                //홀-짝-홀-짝 완벽하게 교대 배치
                ans = odd + even; // = odd * 2
                
            } else {
                //짝수가 더 많은 경우 (even > odd)
                //전략: 짝수 일부를 홀수 2개로 쪼개서 최적 배치
                
                int gap = (even - odd) * 2; //짝수를 홀수로 바꿀 때 필요한 날짜 차이
                // 짝수 1개 = 홀수 2개이므로, 차이가 2배가 됨
                
                int remain = (gap / 3) * 2; //3일마다 2일 추가 (나란히 배치)
                // 짝수 1개를 쪼개면 홀-홀로 2일 추가되고,
                // 원래 짝수 자리 1일이 사라지므로 순증가는 2-1=1일
                // 하지만 전체 패턴상 3일마다 2일씩 추가됨
                
                if (gap % 3 == 1) {
                    remain += 1; //1 부족: 홀수 하나 건너뛰기 +1일
                } else if (gap % 3 == 2) {
                    remain += 2; //2 부족: 홀수 두 개 건너뛰기 +2일
                }
                
                ans = odd * 2 + remain;
                //기본 홀수 배치(odd*2) + 추가 날짜(remain)
            }
            
            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
        sc.close();
    }
}