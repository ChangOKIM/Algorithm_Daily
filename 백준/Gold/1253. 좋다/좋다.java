import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] arr;
	static StringTokenizer st;
	static boolean[] visited;
	static int startIdx, endIdx, total;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		visited = new boolean[N];
		total = 0;
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		for(int i=0; i<arr.length; i++) {
			visited[i] = true;
			
			for(int j=0; j<arr.length; j++) {
				if(!visited[j]) {
					startIdx = j;
					break;
				}
			}
			
			for(int k=arr.length-1; k>=0; k--) {
				if(!visited[k]) {
					endIdx = k;
					break;
				}
			}

			while(startIdx<endIdx) {
				int check = arr[startIdx] + arr[endIdx];
				
				if(check == arr[i]) {
					total +=1;

					break;
				}else if(check >arr[i]) {
					if(visited[endIdx-1]) {
						endIdx -=2;
					}else {
						endIdx -=1;
					}
				}else {
					if(visited[startIdx+1]) {
						startIdx +=2;
					}else {
						startIdx +=1;
					}
				}
			}
			
			visited[i] = false;
		}
		System.out.println(total);
		
	}
}