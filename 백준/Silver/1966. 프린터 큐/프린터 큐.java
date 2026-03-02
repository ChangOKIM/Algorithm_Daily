import java.io.*;
import java.util.*;

public class Main {
	static int T;
	static int N, M;
	static Deque<Integer> check;
	static Deque<Integer> queue;
	static StringTokenizer st;
	static int max_val;
	static int times;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			check = new ArrayDeque<Integer>();
			queue = new ArrayDeque<Integer>();
			times = 0;
			
			for(int i=0; i<N; i++) {
				queue.add(Integer.parseInt(st.nextToken()));
			}
			
			for(int i=0; i<N; i++) {
				check.add(i);
			}
			
			while(true) {
				max_val = 0;
				for(int x : queue) {
					if(x >max_val) max_val = x;
				}
				
				while(queue.peekFirst() <max_val) {
					int temp = queue.pollFirst();
					queue.add(temp);
					
					int temp2 = check.pollFirst();
					check.add(temp2);
				}
				
				times +=1;
				
				int pop1 = queue.pollFirst();
				int pop2 = check.pollFirst();
				
				if(M == pop2) {
					break;
				}
				
			}
			
			System.out.println(times);
		}
		
		
	}
	
}

