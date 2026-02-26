import java.util.*;
import java.io.*;

public class Main {
	static int L, C;
    static char[] arr;
    static char[] temp;
    static StringTokenizer st;
    static char[] check = {'a', 'e', 'i', 'o', 'u'};
    static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        
        L = Integer.parseInt(st.nextToken());
        temp = new char[L];
        
        C = Integer.parseInt(st.nextToken());
        arr = new char[C];
        
        st = new StringTokenizer(br.readLine());
        
        for(int i=0; i<C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);
        
        dfs(0, 0);
        System.out.println(sb);

    }
    
    static void dfs(int depth, int num) {
        if(depth == L) {
        	boolean is_ok  = check_avail(temp);
        	
        	if(is_ok) {
        		for(int i=0; i<L; i++) {
                    sb.append(temp[i]);
                }
                sb.append('\n');
                return; 		
        	}else {
        		return;
        	}
            
        }
        
        for(int i=num; i<C; i++) {
            temp[depth] = arr[i];
            dfs(depth+1, i+1);
        }
		
	}
    
    static boolean check_avail(char temp[]) {
    	int za = 0;
    	int mo = 0;
    	for(int i=0; i<5; i++) {
    		for(int j=0; j<L; j++) {
    			if(check[i] == temp[j]) {
    				mo +=1;
    			}
    		}
    	}
    	
    	za = L - mo;
    	
    	if(mo >= 1 && za >=2) {
    		return true;
    	}else {
    		return false;
    	}
    }
}


