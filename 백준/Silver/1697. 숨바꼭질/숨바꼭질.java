import java.io.*;
import java.util.*;

public class Main {
	static int N, K;
	static int[] arr;
	static boolean[] visited;
	static StringTokenizer st;
	
    public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[100001];
		visited = new boolean[100001];
		
		bfs(N);
		System.out.println(arr[K]);
		
	}
    
    static void bfs(int N) {
    	ArrayDeque<Integer> queue = new ArrayDeque<>();
    	queue.add(N);
    	visited[N] = true;
    	
    	while(!queue.isEmpty()) {
    		int cN = queue.pollFirst();
    		
    		int[] nN = {cN+1, cN-1, cN*2};
    		
    		for(int i=0; i<3; i++) {
    			if(0<= nN[i] && nN[i]<100001) {
    				if(!visited[nN[i]]) {
    					visited[nN[i]] = true;
    					queue.add(nN[i]);
    					arr[nN[i]] = arr[cN] + 1;
    				}
    			}
    		}
    	}
    	
    	
    }
}





