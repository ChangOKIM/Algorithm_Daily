import java.util.*;
import java.io.*;

/*
 * 메모리:30,976kb, 시간:127ms
 */


public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int [][] graph = new int[9][9];
		int result = 0;
		int max_x = 1;
		int max_y = 1;
		
		for(int i=0; i<9; i++) {
			String str = br.readLine();
			st = new StringTokenizer(str);
			
		
			for(int j=0; j<9; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				if(graph[i][j]>result) {
					result = graph[i][j];
					max_x = i+1;
					max_y = j+1;
				}
			}
		}
		
		System.out.println(result);
		System.out.println(max_x + " " + max_y);
		
		
		
	}
}


