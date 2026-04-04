import java.io.*;
import java.util.*;

public class Main {
	static int T;
	static int I;
	static int[][] graph;
	static boolean[][] visited;
	static int startX, startY, endX, endY;
	static StringTokenizer st;
	static int[] dx = {-2, -1, 1, 2, 2, 1 ,-1, -2};
	static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
	//이래서일론머스크가 우주에다 둔다고
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			I = Integer.parseInt(br.readLine());
			graph = new int[I][I];
			visited = new boolean[I][I];
			st = new StringTokenizer(br.readLine());
			startX = Integer.parseInt(st.nextToken());
			startY = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			endX = Integer.parseInt(st.nextToken());
			endY = Integer.parseInt(st.nextToken());
			
			
			bfs(startX, startY);
			System.out.println(graph[endX][endY]);
			
		}
	}
	
	static void bfs(int x, int y) {
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {x, y});
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			int[] check = queue.pollFirst();
			int cx = check[0];
			int cy = check[1];
			
			for(int i=0; i<8; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if(0<=nx && nx<I && 0<=ny && ny<I) {
					if(!visited[nx][ny]) {
						visited[nx][ny] = true;
						queue.add(new int[] {nx, ny});
						graph[nx][ny] = graph[cx][cy] + 1;
					}
				}
			}
		}
	}
}