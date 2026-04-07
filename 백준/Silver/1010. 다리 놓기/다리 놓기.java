import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	static int N, M;
	static BigInteger top, bottom;
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			top = new BigInteger("1"); //문자열로 해야됨?
			bottom = new BigInteger("1");
			
			for( int i=M; i>M-N; i--) {
				top = top.multiply(BigInteger.valueOf(i));
			}
			
			for(int i=1; i<=N; i++) {
				bottom = bottom.multiply(BigInteger.valueOf(i));
			}
			
			System.out.println(top.divide(bottom));
		}
	}
}