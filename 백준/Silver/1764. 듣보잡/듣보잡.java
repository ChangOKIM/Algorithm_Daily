import java.io.*;
import java.util.*;

public class Main {
	static int N, M, cnt;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cnt = 0;
		
		Map<String, Integer> map1 = new HashMap<String, Integer>();
		
		for(int i=0; i<N; i++) {
			String key1 = br.readLine();
			map1.put(key1, null);
		}
		
		StringBuilder sb = new StringBuilder();
		ArrayList<String> ans = new ArrayList<>();
		
		for(int i=0; i<M; i++) {
			String key2 = br.readLine();
			if(map1.containsKey(key2)) {
				cnt +=1;
				ans.add(key2);
			}
		}
		Collections.sort(ans);
		for(int i=0; i<ans.size(); i++) {
			sb.append(ans.get(i)).append('\n');
		}

		System.out.println(cnt);
		System.out.println(sb);
		
	}
}
