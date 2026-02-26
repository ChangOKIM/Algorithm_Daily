import java.util.*;
import java.io.*;

public class Main {
	static int N, C;
	static long[] arr;
	static long check;
	static StringTokenizer st;
	static long start, end, mid;
	static long cnt;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new long[N];
		check = 0;
		
		for(int i=0; i<N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		
		Arrays.sort(arr);
		
		start = 1;
		end = arr[N-1] - arr[0];
		
		while(start <= end) {
			cnt =1;
			check = (start+end)/2;
			long last = arr[0];
			
			for(int i=1; i<N; i++) {
				if(arr[i] - last >= check) {
					cnt +=1;
					last = arr[i];
				}
			}
			
			if(cnt>=C) {
				start = check + 1;
			}else {
				end = check -1;
			}	
		}
		System.out.println(end);
		
	}
}


