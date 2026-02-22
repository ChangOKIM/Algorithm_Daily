import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static boolean avail;
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N+1];
		
		
		dp[0] = 10000;
		dp[1] = 10000;
		dp[2] = 10000;
		dp[3] = 1;
		if(N>=4) dp[4] = -1;
		if(N>=5) dp[5] = 1;
		
		for(int i=6; i<dp.length; i++) {
			avail = false;
			check(i);
			if(!avail) {
				dp[i] = -1;
			}else {
				if(dp[i-3] == -1) {
					dp[i] = dp[i-5] + 1;
				}else if(dp[i-5] == -1) {
					dp[i] = dp[i-3] + 1;
				}else {
					dp[i] = Math.min(dp[i-3]+1, dp[i-5]+1);
				}
			}
		}
		
		System.out.println(dp[N]);
	
	}
	
	static void check(int input) {
		int check1 = input;
		
		while(check1 >=0) {
			if(check1%3 == 0) {
				avail = true;
				return;
			}
			check1 -= 5;
		}
		return;
	}
}
