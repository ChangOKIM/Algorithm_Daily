import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] temp;
	static boolean[] visited;
	static StringTokenizer st;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		temp = new int[M];
		visited = new boolean[N];
		
		sb = new StringBuilder();
		
		dfs(0, 0);
		
		System.out.println(sb);
		
	}
	
	static void dfs(int depth, int start) {
		if(depth == M) {
	        for(int i = 0; i < N; i++) {
	            if(visited[i]) {
	                sb.append(i + 1).append(" ");
	            }
	        }
	        sb.append('\n');
	        return;
	    }
		
		for(int i=start; i<N; i++) {
			visited[i] = true;
			dfs(depth+1, i+1);
			visited[i] = false;
			
		}
	}
}