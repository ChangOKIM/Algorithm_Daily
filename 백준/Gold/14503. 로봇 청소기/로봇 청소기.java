import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] graph;
	static boolean[][] visited;
	static int sweaped;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int rX, rY;
	static int robotDirection;
	static boolean turnOff;
	
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
				
		st = new StringTokenizer(br.readLine());
		rX = Integer.parseInt(st.nextToken());
		rY = Integer.parseInt(st.nextToken());
		robotDirection = Integer.parseInt(st.nextToken());
		
		graph = new int[N][M];
		visited = new boolean[N][M];
		
		sweaped = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		turnOff = false;
		
		
		while(!turnOff) {
			if(graph[rX][rY] == 0) {
				visited[rX][rY] = true;
			}
			
			int noSweapCnt = 0;
			
			for(int i=0; i<4; i++) {
				int nx = rX + dx[i];
				int ny = rY + dy[i];
				if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (graph[nx][ny] == 0 && !visited[nx][ny]) {
                        noSweapCnt++;
                    }
                }
			}
			
			if(noSweapCnt == 0) {
				int back = back(robotDirection);
				if(graph[rX + dx[back]][rY + dy[back]] == 1) {
					turnOff = true;
				}else {
					rX = rX + dx[back];
					rY = rY + dy[back];
				}
			}else {
				robotDirection = spin(robotDirection);
				int sx = rX + dx[robotDirection];
				int sy = rY + dy[robotDirection];
				
				if(graph[sx][sy] == 0 && !visited[sx][sy]) {
					rX = sx;
					rY = sy;
					
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(graph[i][j] == 0 && visited[i][j]) {
					sweaped++;
				}
			}
		}
		
		
		System.out.println(sweaped);
		
	}
	
	static int spin(int direction) {
		if(direction == 0) {
			return 3;
		}
		else {
			int result = direction-1;
			return result;
		}
	}
	
	static int back(int direction) {
		if(direction == 0) {
			return 2;
		}else if(direction == 1) {
			return 3;
		}else if(direction == 2) {
			return 0;
		}else {
			return 1;
		}
	}
    
}