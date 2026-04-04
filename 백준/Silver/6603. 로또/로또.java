import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] arr;
	static int[] temp;
	static StringTokenizer st;
	static StringBuilder sb;
	static ArrayList<Integer> init;
	
	public static void main(String[] args) throws Exception{
		sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true) {

			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			
			if(N == 0) {
				System.out.println(sb);
				break;
			}else {
				arr = new int[N];
				temp = new int[6];
				
				for(int i=0; i<N; i++) {
					arr[i] = Integer.parseInt(st.nextToken());
				}
								
				dfs(0, 0);
				sb.append('\n');
			}
		}
	}
	
	static void dfs(int depth, int start) {
		if(depth == 6) {
			for(int i=0; i<6; i++) {
				sb.append(temp[i]).append(" ");
			}
			sb.append('\n');
			return;
		}
		
		for(int i=start; i<N; i++) {
			temp[depth] = arr[i];
			dfs(depth+1, i+1);
		}
	}
		
		
}