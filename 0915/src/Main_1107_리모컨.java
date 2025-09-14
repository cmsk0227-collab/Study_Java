import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1107_리모컨 {

    static boolean[] isBreak; // 고장난 버튼을 기록하는 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int target = Integer.parseInt(br.readLine());//목표 채널

        //+,-로만 이동 -> 기본값
        int minClick = Math.abs(100 - target); //최소 이동 클릭 수
        
        //숫자버튼 사용 1) 숫자버튼만 2)혼합
        //고장난 버튼 갯수
        int m = Integer.parseInt(br.readLine());

        if (m == 0) {//고장난 버튼이 없다면 -> 슛자 버튼만으로 이동
            int cand = Integer.toString(target).length(); //채널 번호의 배열  길이 = 버튼 누른 횟수 
            minClick = Math.min(cand, minClick);//플마 이동, 숫자 이동 중 클릭이 적은 수 => 최소 이동 클릭수
            System.out.print(minClick); //결과 츌력
            return;// 코드 실행 완전 종료
        }
        
        //고장난 버튼이 있다면 -> 숫자버튼 + (+/-) 혼합 이동
        isBreak = new boolean[10];//리모컨 번호 : 0번 ~ 9번
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; ++i) {//버튼 번호 채크
            int broken = Integer.parseInt(st.nextToken());
            isBreak[broken] = true;
        }
        
        //모든 채널을 하나하나 확인
        for (int ch = 0; ch <= 1_000_000; ++ch) {
            if (minClick == 0) break; //목표 채널까지 필요한 최소 클릭 수

            if (!isValid(ch)) continue; 
            //해당 채널으로 갈 때 눌러야하는 버튼은 고장이 났나?
            //고장나면 혼합 이동 x, 다음 채녈 체크

            int pressCount = Integer.toString(ch).length(); //숫자 버튼 누른 홧수
            int cand = pressCount + Math.abs(target - ch);//숫자 클릭 수 + (+/-) 클릭 수

            minClick = Math.min(cand, minClick); //기존 최솟값, 이번에 계산한 클릭 수 중 더 작은 클릭 수 저장
        }

        System.out.print(minClick);
    }

    static boolean isValid(int number) {
        if (number == 0) return !isBreak[0]; // 숫자 0은 길이 1 취급,

        while (number > 0) {//다른 채널 번호에 고장난 버튼이 들어 있는가
            if (isBreak[number % 10]) //1자리부터 확인 
            	return false; //해당 채널 번호에 고장난 버튼 슛자가ㅏ 포함!
            number /= 10;//다음 자릿수를 확인하기 위해 10자리로 나눔
        }
        return true;//해당 채널 번호에 고장난 버튼의 숫자가 없음!
    }
}
