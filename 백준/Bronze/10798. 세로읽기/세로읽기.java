import java.util.*;
import java.io.*;

/*
 * 메모리:30,976kb, 시간:127ms
 */


public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		char[][] graph = new char[5][15];
		int width = 0;
		
		for(int i=0; i<5; i++) {
			String str = br.readLine();
			if(str.length()>width) width = str.length();
			
			for(int j=0; j<str.length(); j++) {
				graph[i][j] = str.charAt(j);
			}
		}
		
		for(int j=0; j<width; j++) {
			for(int i=0; i<5; i++) {
				if(graph[i][j] != 0) sb.append(graph[i][j]);
			}
		}
		
		System.out.println(sb);
		
		
		
		
		
	}
}


