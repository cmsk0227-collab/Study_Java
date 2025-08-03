import java.util.Scanner;
public class practice{
public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt(); // 테스크 케이스 개수
    
    for(int i = 1; i <=T ; i++){

        int A = sc.nextInt(); // 정수 A
        int B = sc.nextInt(); // 정수 B

        System.out.println(A+B);


    }sc.close();
}
}
