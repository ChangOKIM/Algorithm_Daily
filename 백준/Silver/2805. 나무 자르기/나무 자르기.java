import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] arr;
	static StringTokenizer st;
	static int result;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		result = 0;
		
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		cutTree(M);
		
		System.out.println(result);
	
	}
	
	static void cutTree(int M) {
		int start = 1;
		int end = 0;
		for(int i=0; i<N; i++) {
			if(arr[i] > end) {
				end = arr[i];
			}
		}
		
		
		
		while(start <= end) {
			int mid = (start + end) /2;
			long sum = 0;
			
			for(int i=0; i<N; i++) {
				if(arr[i] - mid > 0) {
					sum += arr[i] - mid;
				}
				
			}
			
			if(sum >= M) {
				result = mid;
				start = mid+1;
			}else {
				end = mid-1;
			}
		}
		
	}
	
}