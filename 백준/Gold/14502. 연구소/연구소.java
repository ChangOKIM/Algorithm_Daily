import java.util.*;
import java.io.*;

public class Main {
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int N, M, cnt;
	static int[][] graph;
	static ArrayList<int[]> is_zero = new ArrayList<>();
	static boolean[][] visited;
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cnt = 0;
		
		graph = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				if(graph[i][j] == 0) {
					is_zero.add(new int[] {i, j});
				}
			}
		}
				
		for(int a =0; a<is_zero.size(); a++) {
			int[] check1 = is_zero.get(a);
			for(int b =a+1; b<is_zero.size(); b++) {
				int[] check2 = is_zero.get(b);
				for(int c =b+1; c<is_zero.size(); c++) {
					int[] check3 = is_zero.get(c);
					
					graph[check1[0]][check1[1]] = 1;
					graph[check2[0]][check2[1]] = 1;
					graph[check3[0]][check3[1]] = 1;
					
					
					visited = new boolean[N][M];
					for(int i=0; i<N; i++) {
						for(int j=0; j<M; j++) {
							if(graph[i][j] == 2) {
								bfs(i, j);
							}
						}
					}
					int sum_a = is_save(graph);
					if(sum_a > cnt) cnt = sum_a;
					
					graph[check1[0]][check1[1]] = 0;
					graph[check2[0]][check2[1]] = 0;
					graph[check3[0]][check3[1]] = 0;
					
					
				}
			}
		}
		
		System.out.println(cnt);
		
	}
	
	static void bfs(int x, int y) {
		Deque<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {x, y});
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.pollFirst();
			int cx = cur[0];
			int cy = cur[1];
			
			for(int i=0; i<4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if(0<= nx && nx<N && 0<=ny && ny<M) {
					if(graph[nx][ny] == 0 && !visited[nx][ny]) {
						queue.add(new int[] {nx, ny});
						visited[nx][ny] = true;
					}
				}
			}		
		}

	}
	
	static int is_save(int[][] graph) {
		int sum = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(graph[i][j] == 0 && !visited[i][j]) sum +=1;
			}
		}
		
		return sum;
	}
	
}
