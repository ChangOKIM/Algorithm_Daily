import java.util.*;
import java.io.*;

public class Main {
	static boolean[] sosu = new boolean[250000];
	
	public static void main(String[] args) throws Exception{
		sosu[0] = true;
		sosu[1] = true;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=2; i<Math.sqrt(sosu.length); i++) {
			if(!sosu[i]) {
				for(int j=i*i; j<sosu.length; j += i) {
					sosu[j] = true;
				}
			}
		}

		while(true) {
			int N = Integer.parseInt(br.readLine());
			
			if(N == 0) break;
			
			int cnt = 0;
			
			int start = N+1;
			int end = 2*N +1;
			
			for(int i= start; i<end; i++) {
				if(!sosu[i]) {
					cnt += 1;
					
				}
			}
			
			System.out.println(cnt);
			
			
		}
	}
}

