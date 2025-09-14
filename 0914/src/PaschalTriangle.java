
//이항계수 구현 
//ex) 10C7
public class PaschalTriangle {
	public static void main(String[] args) {
		int n = 10, k = 7;
		k = Math.min(n-k, k); //조합의 대칭성 -> 연산 및 메모리 절약을 위해
		int[][] comb = new int[n+1][k+1];
		for(int i = 0; i <= n ; i++) {
			int last = Math.min(i, k);
			for(int j = 0; j <= last ; j++) {
				if(j == 0 || j == i) comb[i][j] = 1;
				else comb[i][j] = comb[i-1][j-1] + comb[i-1][j];
			}
		}
		System.out.println(comb[n][k]);
	}

}

