import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>(N);
			
		for(int i=0; i<N; i++) {
			int key = Integer.parseInt(st.nextToken());
			
			map.put(key, map.getOrDefault(key, 0) + 1);
		}
		
		StringBuilder sb = new StringBuilder();
		
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int check = Integer.parseInt(st2.nextToken());
			
			if(map.get(check) == null) {
				sb.append(0).append(" ");
			}else {
				sb.append(map.get(check)).append(" ");
			}
			
			
		}
		
		System.out.println(sb);
	}
}
