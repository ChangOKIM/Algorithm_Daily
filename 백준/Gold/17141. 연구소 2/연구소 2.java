import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] graph;
	static boolean[][] visited;
	static StringTokenizer st;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[][] virusAvail;
	static int virusAvailCnt;
	static int[][] temp;
	static int[][] copy;
	static int answer;
	static boolean unavail;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N][N];
		unavail = true;
		
		temp = new int[M][2];
		virusAvailCnt = 0;
		answer = Integer.MAX_VALUE;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				if(graph[i][j] == 2) virusAvailCnt++;
			}
		}
		
		virusAvail = new int[virusAvailCnt][2];
		int cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(graph[i][j] == 2) {
					virusAvail[cnt][0] = i;
					virusAvail[cnt][1] = j;
					cnt++;
				}
			}
		}
		
		
		
		dfs(0, 0);
		if(unavail) {
			System.out.println(-1);
		}else {
			System.out.println(answer);
		}
		
		
		
	}
	
	static void dfs(int depth, int start) {
		if(depth == M) {
			visited = new boolean[N][N];

			copy = new int[graph.length][];
			for(int i=0; i<N; i++) {
				copy[i] = graph[i].clone();
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(graph[i][j] == 1) {
						copy[i][j] = -1;
					}
					if(graph[i][j] == 2) {
						boolean chosenTwo = false;
						for(int k=0; k<temp.length; k++) {
							if(temp[k][0] == i && temp[k][1] == j) {
								chosenTwo = true;
							}
						}
						if(!chosenTwo) {
							copy[i][j] = 0;
						}
					}
				}
			}
			
			int result = bfs();
			if(result<answer) {
				answer = result;
			}
			
			return;
			
		}
		
		for(int i=start; i<virusAvail.length; i++) {
			temp[depth] = virusAvail[i];
			dfs(depth+1, i+1);
		}
	}
	
	static int bfs() {
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		for(int t=0; t<temp.length; t++) {
			queue.add(new int[] {temp[t][0], temp[t][1]});
			visited[temp[t][0]][temp[t][1]] = true;
		}
		
		int times = M;
		int maxTime = 2;
		
		while(times !=0) {
			int timesCheck = 0;
			for(int tc=0; tc<times; tc++) {
				int[] check = queue.pollFirst();
				int cx = check[0];
				int cy = check[1];
				
				for(int i=0; i<4; i++) {
					int nx = cx + dx[i];
					int ny = cy + dy[i];
					
					if(0<=nx && nx<N && 0<=ny && ny<N) {
						if(!visited[nx][ny] && copy[nx][ny] >= 0) {
							visited[nx][ny] = true;
							queue.add(new int[] {nx, ny});
							copy[nx][ny] = copy[cx][cy]+1;
							if(copy[nx][ny] > maxTime) {
								maxTime = copy[nx][ny];
							}
							timesCheck++;
						}
					}
				}
			}
			times = timesCheck;
			
		}
		
		int cntZero = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(copy[i][j] == 0) {
					cntZero++;
				}
			}
		}
		
		if(cntZero == 0) unavail = false;
		
		if(cntZero !=0) {
			return Integer.MAX_VALUE;
		}else {
			return maxTime-2;
		}
		
		
		
	}
}











