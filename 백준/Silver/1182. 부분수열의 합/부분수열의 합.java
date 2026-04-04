import java.io.*;
import java.util.*;

public class Main {
	static int N, S;
	static int[] arr;
	static StringTokenizer st;
	static int result;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		result = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0, 0);
		if(S == 0) {
			result -=1;
		}
		
		System.out.println(result);
	}
	
	static void dfs(int depth, int sum) {
		if(depth == N) {
			if(sum == S) {
				result +=1;
			}
			return;
		}
		
		dfs(depth +1, sum + arr[depth]);
		
		dfs(depth +1, sum);
	}
}

