import java.io.*;
import java.util.*;

public class Main {
	static int k, check;
	static int[] arr;
	static boolean[] visited;
	static StringTokenizer st;
	static int[] temp;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = 18;

		while(true) {
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if(k == 0) break;
			arr = new int[k];
			for(int i=0; i<k; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			temp = new int[6];
			visited = new boolean[k];

			dfs(0, 0);
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
	
	static void dfs(int depth, int num) {
		if(depth == 6) {
			for(int i=0; i<6; i++) {
				sb.append(temp[i]).append(" ");
			}
			sb.append('\n');
			return;
		}
		
		for(int i=num; i<k; i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			temp[depth] = arr[i];
			dfs(depth+1, i+1);
			
			visited[i] = false;
		}
	}
	
}