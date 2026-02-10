/*
 * 메모리:27,136kb, 시간:99ms
 */
import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;
	static StringTokenizer st;
	static int cnt, N, S;
    
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	S = Integer.parseInt(st.nextToken());
    	cnt = 0;
    	
    	arr = new int[N];
    	st = new StringTokenizer(br.readLine());
    	for(int i=0; i<N; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	dfs(0, 0);
    	
    	if(S == 0) cnt--;
    	System.out.println(cnt);
	}
	
	static void dfs(int depth, int sum) {
		if(depth == N) {
			if(sum == S) {
				cnt +=1;
			}
			return;
		}
		
		dfs(depth+1, sum);
		dfs(depth+1, sum + arr[depth]);
	}
}