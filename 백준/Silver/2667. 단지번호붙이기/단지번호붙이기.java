import java.io.*;
import java.util.*;

public class Main {
	static int N, cnt;
	static ArrayList<Integer> result;
	static int[][] graph;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static boolean[][] visited;
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		graph =new int[N][N];
		visited = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<N; j++) {
				graph[i][j] = s.charAt(j) - '0';
			}
		}
		
		result = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(graph[i][j] == 1 && !visited[i][j]) {
					cnt = 0;
					dfs(i, j);
					result.add(cnt);
					
				}
			}
		}
		
		Collections.sort(result);
		System.out.println(result.size());
		for(int i=0; i<result.size(); i++) {
			System.out.println(result.get(i));
		}
	}
	
	static void dfs(int x, int y) {
		visited[x][y] = true;
		cnt ++;
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(0<=nx && nx<N && 0<=ny && ny<N) {
				if(graph[nx][ny] == 1 && !visited[nx][ny]) {
					dfs(nx, ny);
				}
			}
		}
		
		
	}
}
