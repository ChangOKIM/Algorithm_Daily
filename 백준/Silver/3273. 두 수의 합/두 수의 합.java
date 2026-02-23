import java.io.*;
import java.util.*;

public class Main {
	static int N, x, times;
	static int[] arr;
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		x = Integer.parseInt(br.readLine());
		times = 0;
		
		Arrays.sort(arr);
				
		two_pointer(arr);
		
		System.out.println(times);
		
	}
	
	static void two_pointer(int[] arr) {
		int start = 0;
		int end = N-1;
		
		while(start<end) {
			int check = arr[start] + arr[end];
			if(check < x) {
				start +=1;
			}
			else if(check > x) {
				end -=1;
			}else if(check == x) {
				times +=1;
				end -=1;
			}
		}
		
		return;
	}
}

