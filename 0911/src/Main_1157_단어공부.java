import java.util.*;

public class Main_1157_단어공부{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int[] alphabet = new int[26];
		String str = sc.next().toUpperCase();
		
		
		for(int i = 0 ;  i  < str.length() ; i++) {
			int location = str.charAt(i) - 'A';
			alphabet[location] += 1;	
		}
		
		int max= 0;
		int cnt = 1;
		int idx = -1;
		for(int i = 0; i < alphabet.length ; i++) {//가장 많이 중복된 수 찾기
			if(alphabet[i] > max) {
				max = alphabet[i];
				idx = i;
			}
			else if(alphabet[i] == max && max != 0) cnt ++;
		}
		
		char res = (char) (idx+'A');
		
		if(cnt == 0) System.out.println(res);
		else System.out.println("?");
		
		
	sc.close();}

}
