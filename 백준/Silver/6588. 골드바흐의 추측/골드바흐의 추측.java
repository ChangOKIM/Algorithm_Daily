import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static boolean[] isDecimal = new boolean[1000001];
	//function도 static가능?
	static StringBuilder sb;
	
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	sb = new StringBuilder();
    	decimalFind();
    	
    	while(true) {
    		N = Integer.parseInt(br.readLine());
        	
    		if(N == 0) {
    			break;
    		}else {
    			boolean isFound = false;
    			for(int i=2; i<N/2+1; i++) {
            		if(!isDecimal[i] && !isDecimal[N-i]) {
            			sb.append(N).append(" = ").append(i).append(" + ").append(N-i);
            			sb.append('\n');
            			isFound = true;
            			break;
            		}
            	}
    			if(!isFound) {
    				sb.append("Goldbach's conjecture is wrong.");
    				sb.append('\n');
    			}
            	
    		}
        	
    	}
    	
    	System.out.println(sb);
    	
	}
    
    static void decimalFind() {
    	isDecimal[0] = true;
    	isDecimal[1] = true;
    	
    	for(int i=2; i<(int)Math.sqrt(1000001); i++) {
    		if(!isDecimal[i]) {
    			for(int j=i*i; j<isDecimal.length; j+=i) {
    				isDecimal[j] = true;
    			}
    		}
    	}
    	
    }
}