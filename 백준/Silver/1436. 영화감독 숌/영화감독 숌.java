import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		int init=1;
		
		while(cnt<N) {
			init +=1;
			if(String.valueOf(init).contains("666")) {
				cnt +=1;
				
			}
			
		}
		
		System.out.println(init);
		
	}
}

