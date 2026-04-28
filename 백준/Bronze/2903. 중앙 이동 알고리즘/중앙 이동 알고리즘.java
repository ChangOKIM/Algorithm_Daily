import java.util.*;
import java.io.*;


public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int init = 2;
		for(int i=0; i<T; i++) {
			init = (int) (init + Math.pow(2, i));
		}
		
		System.out.println(init*init);
		
		//2 3 5 9 17 33
		
	}
}

