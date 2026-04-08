import java.io.*;
import java.util.*;

/*
 * 메모리: 14,244kb, 실행시간: 104ms
 */

public class Main {
	static int T;
	static int N, M;
	static int[][] dp;
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			dp = new int[M+1][N+1];
			
			for(int i=0; i<M; i++) {
				dp[i][0] = 1;
			}
			
			for(int m=1; m<=M; m++) {
				for(int n=1;n<=m && n<=N; n++) {
					dp[m][n] = dp[m-1][n-1] + dp[m-1][n];
				}
			}
			
			System.out.println(dp[M][N]);
		}
	
	}
}