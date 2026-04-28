import java.util.*;
import java.io.*;

/*
 * 메모리:30,976kb, 시간:127ms
 */


public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		String input = st.nextToken();
		int base = Integer.parseInt(st.nextToken());
		
		int sum = 0;
		
		for(int i=0; i<input.length(); i++) {
			int val = input.charAt(input.length() -i-1);
			if(val>=65) {
				sum += Math.pow(base, i)*(val -55);
			}else {
				sum += Math.pow(base, i)*(val-48);
			}
		}
		
		System.out.println(sum);
	}
}


