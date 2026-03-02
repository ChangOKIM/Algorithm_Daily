import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static Deque<Integer> queue;
	static int[] arr;
	static StringTokenizer st;
	static int total;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		total =  0;
		arr = new int[N];
		queue = new ArrayDeque<>();
		
		for(int i=0; i<M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<=N; i++) {
			queue.add(i);
		}
		
		for(int i=0; i<M; i++) {
			int check = arr[i];
			
			int position = 0;
			for(int x : queue) {
				if(x == check) break;
				position +=1;
			}
			
			if(position <= queue.size()/2) {
				while(queue.peekFirst() != check){
					int temp = queue.pollFirst();
					queue.add(temp);
					total +=1;
				}
				queue.pollFirst();
			}else {
				while(queue.peekFirst() != check) {
				
					int temp = queue.pollLast();
					queue.addFirst(temp);
					total +=1;
				}
				queue.pollFirst();
			}
			
		}
		
		System.out.println(total);
		
	}
}

