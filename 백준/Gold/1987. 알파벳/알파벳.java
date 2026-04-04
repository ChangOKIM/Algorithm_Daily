import java.io.*;
import java.util.*;

public class Main {
	static int R, C;
	static char[][] graph;
	static boolean[][] visited;
	static boolean[] alphabet;
	static StringTokenizer st;
	static int maxMove;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		graph = new char[R][C];
		visited = new boolean[R][C];
		alphabet = new boolean[26];
		maxMove = 1;
		
		
		for(int i=0; i<R; i++) {
			String s = br.readLine();
			for(int j=0; j<C; j++) {
				graph[i][j] = s.charAt(j);
			}
		}
		alphabet[graph[0][0] - 'A'] = true;
		
		dfs(0, 0, 1);
		System.out.println(maxMove);
	}
	
	static void dfs(int x, int y, int move) {		
		if(move > maxMove) {
			maxMove = move;
		}
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(0<= nx && nx<R && 0<= ny && ny<C) {
				int idx = graph[nx][ny] - 'A';
				
				if(!visited[nx][ny] && !alphabet[idx]) {
					visited[nx][ny] = true;
					alphabet[idx] = true;
					
					dfs(nx, ny, move +1);
					
					visited[nx][ny] = false;
					alphabet[idx] = false;
				}
			}
		}
	}
		
}







