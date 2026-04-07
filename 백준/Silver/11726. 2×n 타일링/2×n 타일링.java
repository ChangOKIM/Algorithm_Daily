import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	
	static int N;
	static BigInteger[] arr;
	
    public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new BigInteger[1001];
		
		arr[0] = BigInteger.valueOf(0);
		arr[1] = BigInteger.valueOf(1);
		arr[2] = BigInteger.valueOf(2);
		
		for(int i=3; i<arr.length;i++) {
			arr[i] = arr[i-1].add(arr[i-2]);
		}
		
		BigInteger input = new BigInteger("10007");
		
		BigInteger answer = arr[N].mod(input);
		
		System.out.println(answer);
	}
}