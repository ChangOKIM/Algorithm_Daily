import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] arr;
	static int[] temp;
	static StringTokenizer st;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		temp = new int[M];
		
		for(int i=0; i<N; i++) {
			arr[i] = i+1;
		}
		
		sb = new StringBuilder();
		
		dfs(0);
		
		System.out.println(sb);
	}
	
	static void dfs(int depth) {
		if(depth == M) {
			for(int i=0; i<M; i++) {
				sb.append(temp[i]).append(" ");
			}
			sb.append('\n');
			return;
		}
		
		
		for(int i=0; i<N; i++) {
			temp[depth] = arr[i];
			dfs(depth + 1);
		}
		
		
	}
}