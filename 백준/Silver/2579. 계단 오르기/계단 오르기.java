import java.io.*;
import java.util.*;

public class Main {
	static int maxScore;
	static int stairNums;
	static int[] stairScores;
	static int[] dp;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		maxScore = 0;
		stairNums = Integer.parseInt(br.readLine());
		stairScores = new int[stairNums+1];
		for(int i=1; i<stairScores.length; i++) {
			stairScores[i] = Integer.parseInt(br.readLine());
		}
		dp = new int[stairNums + 1];
		dp[0] = 0;
		
		if(stairNums==1) {
			System.out.println(stairScores[1]);
		}else if(stairNums==2) {
			System.out.println(stairScores[1] + stairScores[2]);
		}else if(stairNums==3) {
			System.out.println(Math.max(stairScores[3] + stairScores[2], stairScores[3] + stairScores[1]));
		}else {
			dp[0] = 0;
			dp[1] = stairScores[1];
			dp[2] = stairScores[2] + stairScores[1];
			dp[3] = Math.max(stairScores[3] + stairScores[2], stairScores[3] + stairScores[1]);
			
			for(int i=4; i<=stairNums; i++) {
				dp[i] = Math.max(stairScores[i] + dp[i-2], stairScores[i] + stairScores[i-1] + dp[i-3]);
			}
			
			for(int i=0; i<dp.length; i++) {
				if(dp[i] > maxScore) maxScore = dp[i];
			}
			
			System.out.println(dp[stairNums]);
		}
		
		
	}
	
}