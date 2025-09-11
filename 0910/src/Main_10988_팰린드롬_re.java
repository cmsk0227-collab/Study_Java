import java.util.Arrays;
import java.util.Scanner;

public class Main_10988_팰린드롬_re {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		char[] arr = sc.next().toCharArray();
		
		int s = 0;
		int e = arr.length;
		
		char[] reverse = new char[e];
		while(s<e) {
			reverse[s] = arr[e-1];
			reverse[e-1] = arr[s];
			s++;
			e--;
		}
		
		boolean res = Arrays.equals(arr, reverse);
		
		if(res) System.out.println(1);
		else System.out.println(0);
		
	sc.close();}

}
