import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] arr;
	static int[] nums;
	static int[] tempNums;
	static StringTokenizer st;
	static int maxVal, minVal;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		nums = new int[4];
		tempNums = new int[4];
		maxVal = Integer.MIN_VALUE;
		minVal = Integer.MAX_VALUE;
		
		
		st = new StringTokenizer(br.readLine());
		
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<4; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0, arr[0]);
		System.out.println(maxVal);
		System.out.println(minVal);
		
	}
	
	static void dfs(int depth, int sum) {
		if(depth == N-1) {
			if(sum>maxVal) {
				maxVal = sum;
			}
			if(sum<minVal) {
				minVal = sum;
			}
			return;
		}
		
		
		if(tempNums[0] < nums[0]) {
			tempNums[0]++;
			dfs(depth+1, sum + arr[depth+1]);
			tempNums[0]--;
		}
		
		if(tempNums[1] < nums[1]) {
			tempNums[1]++;
			dfs(depth+1, sum - arr[depth+1]);
			tempNums[1]--;
		}
		
		if(tempNums[2] < nums[2]) {
			tempNums[2]++;
			dfs(depth+1, sum * arr[depth+1]);
			tempNums[2]--;
		}
		
		if(tempNums[3] < nums[3]) {
			tempNums[3]++;
			dfs(depth+1, sum / arr[depth+1]);
			tempNums[3]--;
		}
	}
	
	
}







