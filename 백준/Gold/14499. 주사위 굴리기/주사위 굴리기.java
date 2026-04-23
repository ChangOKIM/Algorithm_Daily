import java.util.*;
import java.io.*;

public class Main {
	static int N, M, x, y, K;
	static int[][] graph;
	static int[] cmd;
	static int[] dx = {0, 0, 0, -1, 1};
	static int[] dy = {0, 1, -1, 0, 0};
	
	static StringTokenizer st;

	static ArrayDeque<Integer> colDice;
	static ArrayDeque<Integer> rowDice;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		
		graph = new int[N][M];
		cmd = new int[K];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<K; i++) {
			cmd[i] = Integer.parseInt(st.nextToken());
		}
		
		colDice = new ArrayDeque<>();
		for(int i=0; i<4; i++) {
			colDice.add(0);
		}
		
		rowDice = new ArrayDeque<>();
		for(int i=0; i<3; i++) {
			rowDice.add(0);
		}
		
		for(int i=0; i<K; i++) {
			int cmdIt = cmd[i];
			
			if(isAvail(cmdIt)) {
				rollin(cmdIt); // 전개도 움직이기 + x,y위치갱신
				change(); // 칸이 0인지  아닌지 판단해서 주사위 칸 스위치
				
				int idx = 1;
				int check = 0;
				for(Integer val : rowDice) {
					if(check == idx) {
						sb.append(val);
						sb.append('\n');
						break;
					}
					check++;
				}
				
			}else {
				continue;
			}
			
		}
		
		System.out.println(sb);
	}
	
	static boolean isAvail(int c) {
		int nx = x + dx[c];
		int ny = y + dy[c];
		
		if(0<= nx && nx<N && 0<= ny && ny<M) {
			return true;
		}else {
			return false;
		}
	}
	
	static void rollin(int c) {
		if(c == 1) {
			int temp0 = rowDice.peekFirst();
			int temp1 = rowDice.pollLast(); //3
			int temp2 = colDice.pollLast(); //6
			rowDice.addFirst(temp2);
			colDice.addLast(temp1);
			
			int realTemp = colDice.pollFirst();
			colDice.pollFirst();
			colDice.addFirst(temp0);
			colDice.addFirst(realTemp);
			
			x += dx[c];
			y += dy[c];
			
		}else if(c == 2) {
			int temp0 = rowDice.peekLast();
			int temp1 = rowDice.pollFirst();
			int temp2 = colDice.pollLast();
			colDice.addLast(temp1);
			rowDice.addLast(temp2);
			
			int realTemp = colDice.pollFirst();
			colDice.pollFirst();
			colDice.addFirst(temp0);
			colDice.addFirst(realTemp);
			
			x += dx[c];
			y += dy[c];
			
		}else if(c==3) {
			int temp1 = colDice.pollFirst();
			colDice.addLast(temp1);
			
			int realTemp = colDice.pollFirst();
			int temp0 = colDice.peekFirst();
			colDice.addFirst(realTemp);
			
			int realTemp2 = rowDice.pollFirst();
			rowDice.pollFirst();
			rowDice.addFirst(temp0);
			rowDice.addFirst(realTemp2);
			
			x += dx[c];
			y += dy[c];
			
		}else if(c==4) {
			int realTemp = colDice.peekFirst();
			int temp1 = colDice.pollLast();
			colDice.addFirst(temp1);
			
			int realTemp2 = rowDice.pollFirst();
			rowDice.pollFirst();
			rowDice.addFirst(realTemp);
			rowDice.addFirst(realTemp2);
			
			x += dx[c];
			y += dy[c];
		}
	}
	
	static void change() {
		if(graph[x][y] == 0) {
			int value = colDice.peekLast();
			graph[x][y] = value;
			
		}else {
			int value = graph[x][y];
			colDice.pollLast();
			colDice.addLast(value);
			graph[x][y] = 0;
		}
	}
}
