import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] temp;
	static StringTokenizer st; 
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		

		temp = new int[M];
		sb = new StringBuilder();
		
		dfs(0, 1);
		System.out.println(sb);
	}
	
	static void dfs(int depth, int start) {
		if(depth == M) {
			for(int i=0; i<M; i++) {
				sb.append(temp[i]).append(" ");
			}
			sb.append('\n');
			return;
		}
		
		for(int i=start; i<=N; i++) {
			temp[depth] = i;
			dfs(depth+1, i);
			
		}
		
	}
}







