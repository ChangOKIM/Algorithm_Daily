import java.util.*;
import java.io.*;


public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc =1; tc<T+1; tc++) {
			int cash = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();
			
			int[] arr = {25, 10, 5, 1};
			
			for(int i=0; i<4; i++) {
				sb.append(cash/arr[i]).append(" ");
				cash %= arr[i];
			}
			
			
			System.out.println(sb);
			
		}
		
		
	}
}






