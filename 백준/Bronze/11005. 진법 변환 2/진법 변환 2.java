import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		String str = br.readLine();
		st = new StringTokenizer(str);
		
		int input = Integer.parseInt(st.nextToken());
		int base = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		
		while(input>=base) {
			if(input%base >=10) {
				sb.append((char) (input%base + 55));
			}else {
				sb.append((char) (input%base + 48));
			}
			input /= base;
			
		
		}
		
		if(input>=10) {
			sb.append((char) (input + 55));
		}else {
			sb.append((char) (input + 48));
		}
		
		for(int i=0; i<sb.length(); i++) {
			System.out.print(sb.charAt(sb.length()-1-i));
		}
		
		
	}
}

