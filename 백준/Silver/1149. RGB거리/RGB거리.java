import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] arr;
	static int[][] dp;
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1][3];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp = new int[N+1][3];
		for(int i=0; i<3; i++) {
			dp[0][i] = 0;
			dp[1][i] = arr[1][i];
		}
		
		for(int i=2; i<=N; i++) {
			for(int j=0; j<3; j++) {
				if(j==0) {
					dp[i][j] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][j];
				}else if(j==1) {
					dp[i][j] = Math.min(dp[i-1][0], dp[i-1][2]) + arr[i][j];
				}else {
					dp[i][j] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i][j];
				}
			}
		}
		
		int answer = Math.min(dp[N][0] ,Math.min(dp[N][1], dp[N][2]));
		
		System.out.println(answer);
		
	}
}