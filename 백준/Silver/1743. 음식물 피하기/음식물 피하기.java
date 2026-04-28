//백준1743번

import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int N, M, K, total;  //세로, 가로, 음식물 개수, 최대갱신
	static StringTokenizer st;
	static int[][] graph;
	static boolean[][] visited;
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		total = 0;
		
		graph = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int temp_x = Integer.parseInt(st.nextToken()) - 1;
			int temp_y = Integer.parseInt(st.nextToken()) - 1;
			graph[temp_x][temp_y] = 1;		
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(graph[i][j] == 1 && !visited[i][j]) {
					int size = bfs(i, j);
					if(size>total) total = size;
				}
				
			}
		}
		
		System.out.println(total);
		
	}
	
	static int bfs(int x, int y) {
		Deque<int[]> queue = new ArrayDeque<>();
		int sum = 0;
		
		visited[x][y] = true;
		queue.add(new int[] {x, y});
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			sum +=1;
			int cx = cur[0];
			int cy = cur[1];
			
			for(int i=0; i<4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if(0<=nx && nx<N && 0<=ny && ny<M){
					if(!visited[nx][ny] && graph[nx][ny] == 1) {
						visited[nx][ny] = true;
						queue.add(new int[] {nx, ny});
					}
				}
			}
		}
		return sum;

	}
	
	
}