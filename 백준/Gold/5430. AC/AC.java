import java.io.*;
import java.util.*;

public class Main {
	static int T, n;
	static String cmd;
	static int[] arr;
	static boolean zero, zero_in;
	static Deque<Integer> queue;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			cmd = br.readLine();
			
			n = Integer.parseInt(br.readLine());
			zero = false;
			zero_in = false;
			
			if(n ==0) {
				String check = br.readLine();
				for(int i=0; i<cmd.length(); i++) {
					if(cmd.charAt(i) == 'D') {
						zero = true;
						break;
					}
				}
				
				if(zero) {
					System.out.println("error");
					continue;
				}else {
					System.out.println("[]");
					continue;
				}
				
			}
			queue = new ArrayDeque<>();
			arr = new int[n];
			String check = br.readLine();
			check = check.substring(1, check.length() -1);
			
			String[] parts = check.split(",");
			
			for(int i=0; i<parts.length; i++) {
				arr[i] = Integer.parseInt(parts[i]);
				queue.add(arr[i]);
			}
			
			int cnt_r = 0;
			for(int i=0; i<cmd.length(); i++) {
				if(cmd.charAt(i) == 'R') {
					cnt_r +=1;
				}else if(cmd.charAt(i) == 'D') {
					if(queue.isEmpty()) {
						zero_in = true;
						break;
					}else {
						if(cnt_r == 0 || cnt_r%2 == 0) {
							queue.pollFirst();
						}else if(cnt_r%2 == 1){
							queue.pollLast();
						}
					}
				}	
			}
			
			if(zero_in) {
				System.out.println("error");
				continue;
			}else {
				if(queue.isEmpty()) {
					System.out.println("[]");
					continue;
				}else {
				if(cnt_r %2 == 0) {
					sb = new StringBuilder();
					sb.append("[");
					for(int x : queue) {
						sb.append(x).append(",");
					}
					String fina_sb = sb.substring(0, sb.length() -1);
					System.out.println(fina_sb + "]");
				}else {
					sb = new StringBuilder();
					sb.append("[");
					while(!queue.isEmpty()) {
						sb.append(queue.pollLast()).append(",");
					}
					String fina_sb = sb.substring(0, sb.length() -1);
					System.out.println(fina_sb + "]");
				}
				
				}
			}
			
		}
		
	}
}

