import java.io.*;
import java.util.*;

public class Main {
	static StringTokenizer st;
	static int N, M;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		Map<Integer, String> map = new HashMap<>();
		Map<String, Integer> map_r = new HashMap<>();
		
		for(int i=0; i<N; i++) {
			String val = br.readLine();
			map.put(i+1, val);
			map_r.put(val, i+1);
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<M; i++) {
			String input = br.readLine();
			
			if(Character.isDigit(input.charAt(0))) {
				int num = Integer.parseInt(input);
				sb.append(map.get(num));
				sb.append('\n');
			}else {
				sb.append(map_r.get(input));
				sb.append('\n');
			}
		}
		
		System.out.println(sb);
		
	}
}
