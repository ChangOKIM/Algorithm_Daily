import java.util.*;
import java.io.*;

/*
 * 메모리:30,976kb, 시간:127ms
 */


public class Main {
	static int[][] graph = new int[100][100];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int papers = Integer.parseInt(br.readLine());
		
		for(int i=0; i<papers; i++) {
			String str = br.readLine();
			st = new StringTokenizer(str);
			
			int init = Integer.parseInt(st.nextToken());   //3
			int end = Integer.parseInt(st.nextToken());   //7
			
			for(int x =end; x<end+10; x++) {
				for(int y=init; y<init+10; y++) {
					graph[x][y] += 1;
				}
			}
		}
		int cnt = 0;
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(graph[i][j] >0) {
					cnt += 1;
				}
			}
		}
		System.out.println(cnt);
	}
}


