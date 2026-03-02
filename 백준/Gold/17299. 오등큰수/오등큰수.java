import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] arr;
	static Deque<int[]> stack; 
	static int[] times;
	static int[] result;
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		times = new int[1000001];
		arr = new int[N];
		result = new int[N];
		
		st = new StringTokenizer(br.readLine());
		stack = new ArrayDeque<>();
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			times[arr[i]] +=1;
		}
				
		for(int i=arr.length -1; i>=0; i--) {
			if(stack.isEmpty()) {
				stack.add(new int[] {arr[i], times[arr[i]]});
				result[i] = -1;
			}else {
				while(!stack.isEmpty() && stack.peekLast()[1] <= times[arr[i]]) {
					stack.pollLast();
				}
				if(stack.isEmpty()) {
					stack.add(new int[] {arr[i], times[arr[i]]});
					result[i] = -1;
				}else {
					result[i] = stack.peekLast()[0];
					stack.add(new int[] {arr[i], times[arr[i]]});
					
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<result.length; i++) {
			sb.append(result[i]).append(" ");
		}
		
		System.out.println(sb);
	}
}

