import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] graph;
	static boolean[][] visited;
	static StringTokenizer st;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int max_val;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				graph[i][j] = str.charAt(j) - '0';
			}
		}
		
		bfs(0, 0);

		System.out.println(graph[N-1][M-1]);
		
	}
	
	static void bfs(int x, int y) {
		Deque<int[]> queue = new ArrayDeque<>();
		
		queue.add(new int[] {x, y});
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			int[] check = queue.pollFirst();
			int cx = check[0];
			int cy = check[1];
			
			for(int i=0; i<4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if(0<= nx && nx<N && 0<=ny && ny<M) {
					if(!visited[nx][ny] && graph[nx][ny] >= 1) {
						graph[nx][ny] = graph[cx][cy] + 1;
						visited[nx][ny] = true;
						queue.add(new int[] {nx, ny});
					}
				}
			}
		}
	}
}

