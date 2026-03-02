import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] start;
	static int[] link;
	static int[] arr;
	static int[][] graph;
	static boolean[] visited;
	static StringTokenizer st;
	static int result;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		visited = new boolean[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = i;
		}
		
		graph = new int[N][N];
		result = Integer.MAX_VALUE;
		start = new int[N/2];
		link = new int[N/2];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0);
		System.out.println(result);
		
	}
	
	static void dfs(int depth, int num) {
		if(depth == N/2) {
			int link_cnt = 0;
			for(int i=0; i<N; i++) {
				if(!visited[i]) {
					link[link_cnt] = i;
					link_cnt +=1;
				}
			}

			int startval = check(start);
			int linkval = check(link);
			int diff = Math.abs(startval - linkval); 
			if(diff < result) result = diff;
			
			return;
		}
		
		for(int i=num; i<N; i++) {
			if(visited[i]) continue;
			
			start[depth] = i;
			visited[i] = true;
			dfs(depth+1, i + 1);
			visited[i] = false;
			
		}
	}
	
	static int check(int[] temp) {
		int sum = 0;
		for(int i=0; i<N/2; i++) {
			for(int j=0; j<N/2; j++) {
				sum += graph[temp[i]][temp[j]];
			}
		}
		return sum;
	}
}

