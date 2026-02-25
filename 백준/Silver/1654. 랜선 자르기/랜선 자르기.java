import java.util.*;
import java.io.*;

public class Main {
	static int K, N;
	static int[] arr;
	static long cnt;
	static long max, min, cur;
	static StringTokenizer st;
	static int result;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[K];
		result = 0;
		
		max = Integer.MIN_VALUE;
		min = 1;
		
		for(int i=0; i<K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(arr[i] > max) max = arr[i];
		}
		
		while(min<=max) {
			cnt = 0;
			cur = min+(max-min)/2;
			
			for(int i=0; i<K; i++) {
				cnt += arr[i]/cur;
			}
			
			if(cnt<N) {
				max = cur-1;
			}else{
				min = cur+1;
			}
		}
		
		
		System.out.println(max);
		
		
	}
}


