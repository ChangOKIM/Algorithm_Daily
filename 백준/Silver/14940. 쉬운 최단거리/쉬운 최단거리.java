import java.io.*;
import java.util.*;

/*
 * int[] dx = {1, 2}; 이건 되는데 int[] dx; 선언하고 나중에 dx = {1, 2};이건 왜 안됨
 * 
 */
public class Main {
	static int N, M;
	static int[][] graph;
	static boolean[][] visited;
	static StringTokenizer st;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int startX, startY;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				if(graph[i][j] == 2) {
					graph[i][j] = 0;
					startX = i;
					startY = j;
				}
			}
		}	
		bfs(startX, startY);
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(graph[i][j] == 1 && !visited[i][j]) {
					graph[i][j] = -1;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				sb.append(graph[i][j]).append(" ");
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
	
	static void bfs(int x, int y) {
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {x, y});
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			int[] current = queue.pollFirst();
			int cx = current[0];
			int cy = current[1];
			
			for(int i=0; i<4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if(0<= nx && nx< N && 0<= ny && ny<M) {
					if(graph[nx][ny] == 1 && !visited[nx][ny]) {
						queue.add(new int[] {nx, ny});
						graph[nx][ny] = graph[cx][cy] + 1;
						visited[nx][ny] = true;
					}
				}
			}
		}
	}
}