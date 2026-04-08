import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] dp;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		dp = new int[1000001];
		
		dp[1] = 0;
		dp[2] = 1;
		dp[3] = 1;
		
		if(N<4) {
			System.out.println(dp[N]);
		}else {
			for(int i=4; i<dp.length; i++) {
					if(i%2 == 0 && i%3 == 0) {
						dp[i] = Math.min(dp[i/2]+1, Math.min(dp[i/3]+1, dp[i-1]+1));
					}
					if(i%2 == 0 && i%3 !=0) {
						dp[i] = Math.min(dp[i/2]+1, dp[i-1] + 1);
					}
					
					if(i%3 == 0 && i%2 != 0) {
						dp[i] = Math.min(dp[i/3] + 1, dp[i-1] + 1);
					}
					
					if(i%2 !=0 && i%3 != 0) {
						dp[i] = dp[i-1] + 1;
					}
					
            }
			
			System.out.println(dp[N]);
		}
		
	}
}