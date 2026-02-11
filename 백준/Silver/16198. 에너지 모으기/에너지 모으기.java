import java.util.*;
import java.io.*;


public class Main {
    static int N, sum, cur;
    static ArrayList<Integer> arr = new ArrayList<>();
    static StringTokenizer st;
    
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	N = Integer.parseInt(br.readLine());
    	sum = 0;
    	cur = 0;
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i=0; i<N; i++) {
    		arr.add(Integer.parseInt(st.nextToken()));
    	}
    	
    	dfs(0);
    	System.out.println(sum);
    }
    
    static void dfs(int cur){
    	if(arr.size() == 2) {
    		if(cur > sum) {
    			sum = cur;
    			return;
    		}
    		return;
    	}
    	
    	for(int i=1; i<=arr.size()-2; i++) {
    		
    		int temp = arr.get(i);
    		int add = arr.get(i-1) * arr.get(i+1);
    		arr.remove(i);
    		dfs(cur + add);
    		arr.add(i, temp);
	
    	}
    }
    
}

