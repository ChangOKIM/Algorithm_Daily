import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] graph;
	static boolean[][] visited;
	static int area;
	static StringTokenizer st;
	static int[][] isSafe;
	static int isSafeCnt;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[N][M];
		area = 0;
		isSafeCnt = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				if(graph[i][j] == 0) {
					isSafeCnt++;
				}
			}
		}
		
		isSafe = new int[isSafeCnt][2];
		int cntSafe = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(graph[i][j] == 0) {
					isSafe[cntSafe] = new int[] {i, j};
					cntSafe++;
				}
			}
		}
		
		dfs(0, 0);
		
		System.out.println(area);
		
	}
	
	static void dfs(int depth, int start) {
		if(depth == 3) {
			visited = new boolean[N][M];
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(graph[i][j] == 2) {
						bfs(i, j);
					}
				}
			}
			
			int result = safeArea(graph);
			if(result>area) area = result;
			return;
		}
		
		for(int i=start; i<isSafe.length; i++) {
			int[] check = isSafe[i];
			graph[check[0]][check[1]] = 1;
			dfs(depth + 1, i+1);
			graph[check[0]][check[1]] = 0;
		}

		
	}
	
	static int safeArea(int[][] graph) {
		int cnt = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(graph[i][j] == 0 && !visited[i][j]) {
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	static void bfs(int x, int y) {
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		visited[x][y] = true;
		queue.add(new int[] {x, y});
		
		while(!queue.isEmpty()) {
			int[] check2 = queue.pollFirst();
			int cx = check2[0];
			int cy = check2[1];
			
			for(int i=0; i<4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if(0<=nx && nx<N && 0<=ny && ny<M) {
					if(!visited[nx][ny] && graph[nx][ny] == 0) {
						visited[nx][ny] = true;
						queue.add(new int[] {nx, ny});
					}
				}
			}
		}
		
	}
}





