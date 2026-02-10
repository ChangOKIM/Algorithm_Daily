import java.util.*;
import java.io.*;

public class Main {
	static int N, result;
	static boolean[] col;
	static boolean[] x1;
	static boolean[] x2;
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		result =0;
		col = new boolean[N];
		x1 = new boolean[2*N-1];
		x2 = new boolean[2*N-1];
		
		dfs(0);
		
		System.out.println(result);
	}
	
	static void dfs(int row) {
		if(row == N) {
			result +=1;
			return;
		}
		
		for(int i=0; i<N; i++) {
			int check1 = row - i + (N-1);
			int check2 = row + i;
			
			if(col[i] || x1[check1] || x2[check2]) continue;
			
			col[i] = true;
			x1[check1] = true;
			x2[check2] = true;
				
			dfs(row+1);
				
			col[i] = false;
			x1[check1] = false;
			x2[check2] = false;
			
		}
	}
	
}

